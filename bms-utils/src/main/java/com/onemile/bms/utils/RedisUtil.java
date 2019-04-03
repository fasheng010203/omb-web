package com.onemile.bms.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Eric
 * Redis工具类
 */
@Configuration
public class RedisUtil {

    private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    private static JedisPool jedisPool;

    @Value("${redis.ip}")
    private String ip;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.maxTotal}")
    private int maxTotal;
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.maxWaitMillis}")
    private int maxWaitMillis;
    @Value("${redis.maxTimeout}")
    private int maxTimeout;


    private JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        return jedisPoolConfig;
    }

    private JedisPool getJedisPool() {
        if (jedisPool == null) {
            jedisPool = new JedisPool(getJedisPoolConfig(), ip, port, maxTimeout);
        }
        return jedisPool;
    }

    @Bean
    public JedisPool RedisUtil() {
        return getJedisPool();
    }

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String set(String key, String value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("set {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("set {} = {}", key, value, e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * set
     *
     * @param key
     * @param value
     * @return
     */
    public static byte[] set(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
//            if (this.expire != 0) {
//                jedis.expire(key, this.expire);
//            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                value = jedis.get(key);
                logger.debug("get {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("get {} = {}", key, value, e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * get value from redis
     *
     * @param key
     * @return
     */
    public static byte[] get(byte[] key) {
        byte[] value = null;
        Jedis jedis = jedisPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static void del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            logger.warn("del {} = {}", key, e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * del
     *
     * @param key
     */
    public static void del(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param key
     * @param list
     * @param cacheSeconds
     * @param <T>
     */
    public static <T> void setList(String key, List<T> list, int cacheSeconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key.getBytes(), serialize(list));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
        } catch (Exception e) {
            logger.error("Set key error : " + e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取list
     *
     * @param <T>
     * @param key
     * @return list
     */
    public static <T> List<T> getList(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null || !jedis.exists(key.getBytes())) {
                return null;
            }
            byte[] in = jedis.get(key.getBytes());
            List<T> list = (List<T>) deserialize(in);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 设置 map
     *
     * @param <T>
     * @param key
     */
    public static <T> void setMap(String key, Map<String, T> map, int cacheSeconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key.getBytes(), serialize(map));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
        } catch (Exception e) {
            logger.error("Set key error : " + e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取list
     *
     * @param <T>
     * @param key
     * @return list
     */
    public static <T> Map<String, T> getMap(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null || !jedis.exists(key.getBytes())) {
                return null;
            }
            byte[] in = jedis.get(key.getBytes());
            Map<String, T> map = (Map<String, T>) deserialize(in);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }



    /**
     * keys
     * @param
     * @return
     */
    public static Set<byte[]> keys(String pattern) {
        Set<byte[]> keys = null;
        Jedis jedis = jedisPool.getResource();
        try {
            keys = jedis.keys(pattern.getBytes());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return keys;
    }

    public static void flushDB() {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.flushDB();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public static Long dbSize() {
        Long dbSize = 0L;
        Jedis jedis = jedisPool.getResource();
        try {
            dbSize = jedis.dbSize();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return dbSize;
    }


    /**
     * 设置shiro session
     *
     * @param sessionId
     * @param session
     */
    public static void setSession(String sessionId, Session session) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(sessionId, serializeSession(session));
            //获取session设置的超时时间，并设置key的超时时间
            int cacheSeconds = Integer.parseInt((session.getTimeout() / 1000) + "");
            jedis.expire(sessionId, cacheSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 替换
     *
     * @param sessionId
     * @param session
     */
    public static void replaceSession(String sessionId, Session session) {
        setSession(sessionId, session);
    }

    /**
     * 删除 shiro session
     *
     * @param sessionId
     */
    public static void deleteSession(String sessionId) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(sessionId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取 shiro session
     *
     * @param sessionId
     * @return
     */
    public static Object getSession(String sessionId) {
        Jedis jedis = null;
        Object obj = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(sessionId);
            if (str != null && !str.isEmpty()) {
                obj = deserializeSeesion(jedis.get(sessionId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return obj;
    }


    /**
     * 序列化
     *
     * @param value
     * @return
     */
    public static byte[] serialize(Object value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return rv;
    }

    /**
     * 反序列化
     *
     * @param in
     * @return
     */
    public static Object deserialize(byte[] in) {
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = is.readObject();
                is.close();
                bis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return rv;
    }

    /**
     * shiro sesssion 序列化
     *
     * @param str
     * @return
     */
    private static Object deserializeSeesion(String str) {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(Base64.decode(str));
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);
        } finally {
            try {
                ois.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * shiro sesssion 反序列化
     *
     * @param obj
     * @return
     */
    private static String serializeSession(Object obj) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            return Base64.encodeToString(bos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("serialize session error", e);
        } finally {
            try {
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}