package com.onemile.bms.controller;

import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eric
 * @Description:
 * @date 2018/6/7
 */
@Controller
public class DemoController {


//    /**
//     * 执行定时任务
//     * @param jobExecutionContext
//     * @throws JobExecutionException
//     */
//    @Override
//    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("quartz task "+new Date());
//    }


//    @RequestMapping(value = "/dashboard")
//    public String dashboard(Model model) {
//
//        model.addAttribute("avatar", "");
//
//        return "dashboard";
//    }
//
//    @RequestMapping(value = "/dashboard1")
//    public String dashboard1(Model model) {
//
//        model.addAttribute("avatar", "");
//
//        return "dashboard1";
//    }
//
//    @RequestMapping(value = "/demo/list")
//    public String demoList(Model model) {
//
//        return "demo/list";
//    }
//
//    @RequestMapping(value = "/demo/form")
//    public String demoForm(Model model) {
//
//        return "demo/form";
//    }
//
//    @RequestMapping(value = "/demo/index")
//    public String index(Model model) {
//
//        return "demo/index";
//    }
}
