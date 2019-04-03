package com.onemile.bms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.onemile.bms.result.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/12
 */
@Controller
public class MyErrorController implements ErrorController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {

        String requestType = httpServletRequest.getHeader("X-Requested-With");

        Integer statusCode = (Integer) httpServletRequest.getAttribute("javax.servlet.error.status_code");

        if ("XMLHttpRequest".equals(requestType)) {
            logger.debug("........AJAX请求异常........错误代码：{}", statusCode);
            if (statusCode == 400) {
                responseJsonMsg(httpServletResponse, "请求接口参数异常(参数类型不正确)！");
                return null;
            } else if (statusCode == 404) {
                responseJsonMsg(httpServletResponse, "请求接口地址不存在，请联系管理员！");
                return null;
            } else {
                responseJsonMsg(httpServletResponse, "服务器处理异常，请联系管理员！");
                return null;
            }
        } else {
            logger.debug("........非AJAX请求异常........错误代码：{}", statusCode);
            if (statusCode == 400) {
                return "/400";
            } else if (statusCode == 404) {
                return "/404";
            } else if (statusCode == 403) {
                return "/403";
            } else {
                return "/500";
            }
        }

    }

    private static ModelAndView responseJsonMsg(HttpServletResponse httpServletResponse, String msg) {
        httpServletResponse.setStatus(200);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = httpServletResponse.getWriter();
            out.append(JSON.toJSONString(AjaxResult.failed(msg), SerializerFeature.WriteMapNullValue));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return null;
    }

}
