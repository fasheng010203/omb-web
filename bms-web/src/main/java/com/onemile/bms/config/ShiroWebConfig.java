package com.onemile.bms.config;

import com.onemile.bms.config.shiro.MyExceptionResolver;
import com.onemile.bms.config.shiro.ShiroWebDbRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Eric
 * @Description: shiro 配置管理
 * @date
 */
@Configuration
public class ShiroWebConfig implements EnvironmentAware {

    @Autowired
    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //登录页
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();

        //限制同一帐号同时在线的个数。
       // filtersMap.put("kickout", kickoutSessionFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        //权限控制拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/loginDo", "anon");
        filterChainDefinitionMap.put("/userApi/**", "anon");
        //配置退出
        filterChainDefinitionMap.put("/logout", "logout");
        // 需要认证的
        filterChainDefinitionMap.put("/**", "authc");

        //filterChainDefinitionMap.put("/**", "authc,kickout"); 需要登录认证的 且限制单个账户在线个数 就打开kickout过滤器。

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroWebDbRealm shiroWebDbRealm() {
        ShiroWebDbRealm shiroWebDbRealm = new ShiroWebDbRealm();
        return shiroWebDbRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(shiroWebDbRealm());

        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());

        // 自定义权限缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());

        //注入记住我管理器;
        // securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }


    /**
     * 配置redis Manager
     * 开源插件 https://github.com/Eric1984/shiro-redis
     * note: 注意shiro 版本 。20180613 时 shiro-redis版本1.26，shiro版本1.4.0 .要修改shiro-redis的shiro版本为1.4.0
     * 否则有兼容性问题
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        //redis地址，主从集群模式，哨兵模式配置参考github上该项目的说明
        redisManager.setHost(env.getProperty("redis.ip"));
        //redis 端口
        redisManager.setPort(Integer.parseInt(env.getProperty("redis.port")));
        return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 开源插件 https://github.com/Eric1984/shiro-redis
     *
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();

        redisCacheManager.setRedisManager(redisManager());
        //Shiro-redis needs an id field to identify your authorization object in Redis.
        //So please make sure your principal class has a field which you can get unique id of this object.
        redisCacheManager.setPrincipalIdFieldName("id");
        // 缓存key值前缀
        redisCacheManager.setKeyPrefix("shiro:cache:bms:");
        //权限缓存有效期 单位:秒
        redisCacheManager.setExpire(Integer.parseInt(env.getProperty("shiro.cachedTimeout")));
        return redisCacheManager;
    }

    /**
     * Session Manager
     * 开源插件 https://github.com/Eric1984/shiro-redis
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        //shiro 缓存有效期
        defaultWebSessionManager.setGlobalSessionTimeout(Integer.parseInt(env.getProperty("shiro.sessionTimeout")) * 1000);

        defaultWebSessionManager.setSessionDAO(redisSessionDAO());
        return defaultWebSessionManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 开源插件 https://github.com/Eric1984/shiro-redis
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        // 缓存key值前缀
        redisSessionDAO.setKeyPrefix("shiro:session:bms:");
        //缓存有效期 单位:秒
        //redisSessionDAO.setExpire(Integer.parseInt(env.getProperty("shiro.sessionTimeout")));

        return redisSessionDAO;
    }

    /**
     * 记住我 cookie对象;
     *
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //记住我cookie生效时间30天 ,单位秒
        simpleCookie.setMaxAge(Integer.parseInt(env.getProperty("shiro.cookieMaxAge")));
        return simpleCookie;
    }

    /**
     * cookie管理对象;记住我功能
     *
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * 限制同一账号登录同时登录人数控制
     *
     * @return
     */
//    @Bean
//    public KickoutSessionFilter kickoutSessionFilter() {
//        KickoutSessionFilter kickoutSessionFilter = new KickoutSessionFilter();
//        kickoutSessionFilter.setCacheManager(cacheManager());
//        kickoutSessionFilter.setSessionManager(sessionManager());
//        kickoutSessionFilter.setKickoutAfter(false);
//        kickoutSessionFilter.setMaxSession(1);
//        kickoutSessionFilter.setKickoutUrl("/login?ko");
//        return kickoutSessionFilter;
//    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启注解功能
     * SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)
     * 和AuthorizationAttributeSourceAdvisor)即可实现此功能
     *
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 定义处理异常handler
     *
     * @return
     */
    @Bean
    public HandlerExceptionResolver exceptionResolver() {
        HandlerExceptionResolver handlerExceptionResolver = new MyExceptionResolver();
        return handlerExceptionResolver;
    }


}
