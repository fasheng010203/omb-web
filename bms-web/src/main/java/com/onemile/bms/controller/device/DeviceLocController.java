package com.onemile.bms.controller.device;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.entity.device.SbLoc;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.service.device.SbEventService;
import com.onemile.bms.service.device.SbLocService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author eric
 * @Description:
 * @date 2018/9/20
 */
@Controller
@RequestMapping("/device")
public class DeviceLocController extends BaseController {
    @Autowired
    private SbLocService sbLocService;
    @RequestMapping(value = "/locmgr")
    @RequiresPermissions(PermResourceConst.DEVICE_LOCMGR)
    public String locMgr(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.DEVICE_LOCMGR);
        permMap.put("update", PermResourceConst.DEVICE_LOCMGR);
        model.addAllAttributes(permMap);

        return "device/deviceloc";
    }



    @ResponseBody
    @RequestMapping(value = "/getDeviceLocList")
    public PageInfoRsp<SbLoc> getDeviceLocList(DeviceEventQuery deviceInfoQuery){
         try{
             PageInfoRsp<SbLoc> pageInfoRsp=sbLocService.getDeviceLocList(deviceInfoQuery);
             return pageInfoRsp;
         }catch (Exception e){
             logger.error("DeviceLocController.getDeviceLocList", e);
             return null;
         }
    }



}
