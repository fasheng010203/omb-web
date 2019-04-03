package com.onemile.bms.config.shiro;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * @author Eric
 * freemarker 集成shiro tags 。
 */

public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {

    @Override

    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }

}