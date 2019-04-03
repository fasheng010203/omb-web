package com.onemile.bms.config.filter;

import com.alibaba.fastjson.JSON;
import com.onemile.bms.handler.HttpServletRequestWrapperNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Eric
 * @Description:
 * @date 17/12/13
 */
@Component
public class SignFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SignFilter.class);

    private final String signKey = "94853-JKD94-3JK2S-1SDZM-G1S84-834U2";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        ServletRequest requestWrapper = new HttpServletRequestWrapperNew(request);

        //  String bodyJson = HttpHelper.getBodyString(requestWrapper);

        if (!request.getRequestURI().contains("static") && !request.getRequestURI().contains("favicon")) {
            logger.info("请求URL：{}, 请求参数：{}", request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        }

        //继续执行
        if (null == requestWrapper) {
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(requestWrapper, response);
        }

    }


}
