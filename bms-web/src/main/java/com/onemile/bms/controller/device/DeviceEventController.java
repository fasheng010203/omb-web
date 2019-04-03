package com.onemile.bms.controller.device;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.pojo.dto.device.DeviceInfoQuery;
import com.onemile.bms.service.device.SbEventService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @author eric
 * @Description:
 * @date 2018/9/20
 */
@Controller
@RequestMapping("/device")
public class DeviceEventController extends BaseController {
    @Autowired
    private SbEventService sbEventService;

    @RequestMapping(value = "/eventmgr")
    @RequiresPermissions(PermResourceConst.DEVICE_EVENTMGR)
    public String appVersion(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.DEVICE_EVENTMGR);
        permMap.put("update", PermResourceConst.DEVICE_EVENTMGR);
        model.addAllAttributes(permMap);

        return "device/deviceevent";
    }



    @ResponseBody
    @RequestMapping(value = "/getDeviceEventList")
    public PageInfoRsp<SbEvent> getDeviceEventList(DeviceEventQuery deviceInfoQuery){
         try{
             PageInfoRsp<SbEvent> pageInfoRsp=sbEventService.getDeviceEventList(deviceInfoQuery);
             return pageInfoRsp;
         }catch (Exception e){
             logger.error("DeviceInfoController.getDeviceEventList", e);
             return null;
         }
    }


//    /**
//     * 增加
//     * @param appVersionReq
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/saveAppVersion")
//    @RequiresPermissions(PermResourceConst.APP_VERSION_ADD)
//    public AjaxResult saveAppVersion(AppVersionReq appVersionReq, HttpServletRequest request){
//        try{
//
//            AppVersionVO appVersionVO=appVersionService.findByPlatform(appVersionReq.getPlatform());
//            if(appVersionVO!=null){
//                return AjaxResult.failed("已有该系统版本，请修改改系统版本");
//            }
//
//            Boolean result=appVersionService.saveAppVersion(appVersionReq);
//            if (result){
//                return  AjaxResult.success();
//            }else{
//                return AjaxResult.failed("失败");
//            }
//
//        }
//        catch (Exception e){
//            logger.error("AppVersionController.saveAppVersion异常", e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//
//    /**
//     * 修改
//     * @param appVersionReq
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/updateAppVersion")
//    @RequiresPermissions(PermResourceConst.APP_VERSIONT_UPDATE)
//    public AjaxResult updateAppVersion(AppVersionReq appVersionReq, HttpServletRequest request){
//        try{
//
//
//            Boolean result=appVersionService.updateAppVersion(appVersionReq);
//            if (result){
//                return  AjaxResult.success();
//            }else{
//                return AjaxResult.failed("失败");
//            }
//
//        }
//        catch (Exception e){
//            logger.error("AppVersionController.updateAppVersion异常", e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }


//
//    @RequestMapping("/auditSuggest")
//    @ResponseBody
//    public AjaxResult auditSuggest(SuggestReq suggestReq) {
//        try {
//            Assert.notNull(suggestReq.getId(), "id不能为空！");
//            Assert.notNull(suggestReq.getStatus(), "状态不能为空！");
//        } catch (Exception e) {
//            return AjaxResult.failed(e.getMessage());
//        }
//        try {
//            SuggestVO suggestVO= suggestService.getBySuggestId(suggestReq.getId());
//
//            if (suggestVO.getStatus() ==1) {
//                return AjaxResult.failed("该反馈已处理");
//            }
//            Boolean result=suggestService.auditCompanyVerify(suggestReq);
//            if(result){
//                return AjaxResult.success();
//            }else{
//                return AjaxResult.failed("处理失败");
//            }
//
//        } catch (Exception e) {
//            logger.error("SuggestController.auditSuggest：{}",e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//    }

}
