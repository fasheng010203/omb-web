package com.onemile.bms.config.shiro;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.onemile.bms.result.AjaxResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author Eric
 * @Description: shiro 权限异常处理
 * @date 2018/7/12
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {

        String requestType = httpServletRequest.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestType)) {
            if (ex instanceof UnauthorizedException) {
                // 返回200正常代码
                return writeMsgReturnNull(httpServletResponse, 200, "无操作权限，请联系管理员！");
            } else {
                return writeMsgReturnNull(httpServletResponse, 500, "服务器处理异常，请联系管理员！");
            }
        }else{
            if (ex instanceof UnauthorizedException) {
                ModelAndView mv = new ModelAndView("/403");
                return mv;
            } else {
                ModelAndView mv = new ModelAndView("/500");
                ex.printStackTrace();
                return mv;
            }
        }

    }

    /**
     * response 自定义错误代码 给MyErrorController处理
     *
     * @param httpServletResponse
     * @param statusCode          错误代码
     * @return
     */
    private static ModelAndView writeMsgReturnNull(HttpServletResponse httpServletResponse, Integer statusCode, String msg) {
        httpServletResponse.setStatus(statusCode);
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
