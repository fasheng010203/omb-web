package com.onemile.bms.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author Eric
 * @Description:
 * @date 2018/5/14
 */
@Component
public class QiniuUtil {

    private static Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    private static final String ACCESS_KEY = "MpvYIRRSejM2G7ykXAqefpoTaT1fKy-u98GmgsAM";
    private static final String SECRET_KEY = "91qd6RMym1NEK6j6cOrJ1miwp2LEPV_Ae0vGFUAt";
    public  static final String DEFAULT_BUCKET = "opencv-out";

    /**
     *
     */
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static Configuration cfg = new Configuration(Zone.zone0());

    /**
     * 获取上传的凭证
     *
     * @param bucket
     * @param key    如果key 不为空则是覆盖上传，key是将要进行覆盖的文件名称。
     * @return
     */
    public static String getToken(String bucket, String key) {
        if (key != null && key != "") {
            return auth.uploadToken(bucket, key);
        } else {
            return auth.uploadToken(bucket);
        }
    }

    /**
     * 上传文件--服务端直传
     *
     * @param bucket
     * @param filePath 文件路径
     * @param key      上传后的文件名
     * @return
     */
    public static String upload(String bucket, String filePath, String key) {

        String upToken = auth.uploadToken(bucket);

        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            logger.debug("=============== 上传后文件名称：" + putRet.key);
            return putRet.key;
        } catch (QiniuException ex) {
            logger.error(ex.error());
            return "";
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 上传文件--接收文件流
     *
     * @param bucket
     * @param in 文件流
     * @param key      上传后的文件名
     * @return
     */
    public static String upload(String bucket, InputStream in, String key) {

        String upToken = auth.uploadToken(bucket);

        UploadManager uploadManager = new UploadManager(cfg);
        try {
            //生成字节数组
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = in.read(buffer))) {
                output.write(buffer, 0, n);
            }
            Response response = uploadManager.put(output.toByteArray(), key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            logger.debug("=============== 上传后文件名称：" + putRet.key);
            return putRet.key;
        } catch (QiniuException ex) {
            logger.error("七牛上传文件异常",ex);
            return "";
        } catch (Exception e) {
            logger.error("上传文件异常",e);
            return "";
        }
    }


}
