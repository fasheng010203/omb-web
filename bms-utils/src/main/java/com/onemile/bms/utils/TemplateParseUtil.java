package com.onemile.bms.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * @author hzx
 */
@Component
public class TemplateParseUtil {

    private static String ftlPath;

    public static String getFtlPath() {
        return ftlPath;
    }

    @Value("${excel.ftlPath}")
    public void setFtlPath(String ftlPath) {
        TemplateParseUtil.ftlPath = ftlPath;
    }

    private static final Logger logger = LoggerFactory.getLogger(TemplateParseUtil.class);
    public static final String TEMPLATE_PATH = "src/main/resources";
    public static final String ENCODING = "UTF-8";


    /**
     * 解析模板生成Excel stream
     *
     * @param templateName 模板名称
     * @param data         数据
     * @param url          路径
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static ByteArrayOutputStream parse(String templateName, Map<String, Object> data, String url) throws IOException, TemplateException {
        //初始化工作  
        Configuration cfg = new Configuration();
        //设置默认编码格式为UTF-8  
        cfg.setDefaultEncoding(ENCODING);
        //全局数字格式  
        cfg.setNumberFormat("0");
        //指定模板路径
        org.springframework.core.io.Resource resource = new DefaultResourceLoader().getResource("/src");
        //设置模板文件位置
        url = ftlPath + url;
        cfg.setDirectoryForTemplateLoading(new File(url));
        cfg.setObjectWrapper(new DefaultObjectWrapper());
//        //加载模板  
        Template template = cfg.getTemplate(templateName, ENCODING);
        ByteArrayOutputStream outStream = null;
        Writer out = null;
        try {
            outStream = new ByteArrayOutputStream();
            out = new OutputStreamWriter(outStream, ENCODING);
            template.process(data, out);
            logger.info("-----------导出成功--------");
            return outStream;
        } finally {
            out.close();
        }
    }


}
