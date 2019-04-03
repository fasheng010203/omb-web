package com.onemile.bms.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eric
 * @Description:
 * @date 17/7/25
 */
@Configuration
public class AliFastJsonConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//
//        fastJsonConfig.setFeatures(Feature.AllowArbitraryCommas,
//                Feature.AllowUnQuotedFieldNames,
//                Feature.DisableCircularReferenceDetect
//        );
//
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullBooleanAsFalse,
//                SerializerFeature.WriteEnumUsingToString,
//                SerializerFeature.QuoteFieldNames,
//                SerializerFeature.WriteNonStringKeyAsString,
//                SerializerFeature.WriteNullStringAsEmpty,
//                SerializerFeature.WriteDateUseDateFormat
//        );
//        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }

}
