package com.onemile.bms.controller.device;

import com.alibaba.fastjson.JSON;
import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.constant.RedisKey;
import com.onemile.bms.constant.SystemConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.device.CmdSend;
import com.onemile.bms.entity.device.DeviceInfo;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceInfoDTO;
import com.onemile.bms.pojo.dto.device.DeviceInfoQuery;
import com.onemile.bms.pojo.dto.device.DeviceInfoReq;
import com.onemile.bms.pojo.vo.zxshare.base.BaseCityVO;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.device.BaseCityService;
import com.onemile.bms.service.device.DeviceInfoService;
import com.onemile.bms.utils.HttpSendCenter;
import com.onemile.bms.utils.QRCodeUtil;
import com.onemile.bms.utils.RedisUtil;
import com.onemile.bms.utils.UploadFileUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.util.Assert;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


/**
 * @author eric
 * @Description:
 * @date 2018/9/20
 */
@Controller
@RequestMapping("/device")
public class DeviceInAndOutController extends BaseController {
    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private BaseCityService baseCityService;


    @Autowired
    private Environment env;



    @RequestMapping(value = "/deviceinandout")
    @RequiresPermissions(PermResourceConst.DEVICE_INANDOUT)
    public String deviceinfo(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.DEVICE_INANDOUT_UPDATE);
        permMap.put("update", PermResourceConst.DEVICE_INANDOUT_UPDATE);
        model.addAllAttributes(permMap);

        String sfiter= RedisUtil.get(RedisKey.USER_ADMIN_CITY+getUserId().toString());

        List<BaseCityVO> listBaseCityPar = baseCityService.getBaseCityByType(1);
        List<BaseCityVO> listBaseCity = baseCityService.getBaseCityByType(2);

        model.addAttribute("listBaseCityPar",listBaseCityPar);
        model.addAttribute("listBaseCity",listBaseCity);

        return "device/deviceinandout";
    }



//    @ResponseBody
//    @RequestMapping(value = "/getDeviceInfoList")
//    public PageInfoRsp<DeviceInfoDTO> getDeviceInfoList(DeviceInfoQuery deviceInfoQuery){
//         try{
//
//             String sfiter= RedisUtil.get(RedisKey.USER_ADMIN_CITY+getUserId().toString());
//
//             if(!"".equals(sfiter)){
//                 deviceInfoQuery.setCityid(sfiter);
//
//             }
//
//             PageInfoRsp<DeviceInfoDTO> pageInfoRsp=deviceInfoService.getDeviceInfoList(deviceInfoQuery);
//
//             return pageInfoRsp;
//         }catch (Exception e){
//             logger.error("DeviceInfoController.getDeviceInfoList异常", e);
//             return null;
//         }
//    }
//
//
//    /**
//     * 获取所有城市信息
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/getBaseCityListByPid")
//    public AjaxResult getBaseCityListByPid(DeviceInfoQuery deviceInfoQuery) {
//        try {
//
//            List<BaseCityVO> baseCityVOList =baseCityService.getBaseCityByParentId(deviceInfoQuery.getCitypid());
//
//            return AjaxResult.success(baseCityVOList);
//
//        } catch (Exception e) {
//            logger.error("AdminCityController.getBaseCityListByPid: 异常 ", e);
//            return null;
//        }
//    }
//
//
//
//    /**
//     * 增加
//     * @param deviceInfoReq
//     * @param request
//     * * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/saveDeviceInfo")
//    @RequiresPermissions(PermResourceConst.DEVICE_MANAGEMENT)
//    public AjaxResult saveDeviceInfo(DeviceInfoReq deviceInfoReq, HttpServletRequest request){
//
//        try{
//
//            String s=deviceInfoReq.getAuthInfo();
//            DeviceInfo deviceInfoVO=deviceInfoService.findByAutoInfo(s);
//            if(deviceInfoVO!=null){
//                return AjaxResult.failed("鉴权号已经注册，请检查鉴权号");
//            }
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("title", deviceInfoReq.getTitle());
//            jsonObject.put("desc", deviceInfoReq.getDevdesc());
//            //jsonObject.put("tags", "['china','mobile']");
//            jsonObject.put("private", "true");
//            jsonObject.put("auth_info", deviceInfoReq.getAuthInfo());
//            //jsonObject.put("other", "{}");
//
//            CmdSend cResult= JSON.parseObject((HttpSendCenter.post(SystemConst.ONENET_APIKET, "http://api.heclouds.com/devices", jsonObject).toString()),CmdSend.class);
//
//            if (!"0".equals(cResult.getErrno())){
//
//                return AjaxResult.failed("OneNet注册失败");
//            }
//
//            deviceInfoReq.setDevId(cResult.getData().getDevice_id()) ;
//
//            //生成唯一二维码
//            String qrUrl=QRCodeUtil.generateQRCode(cResult.getData().getDevice_id(),env.getProperty("qrcode.filePath"));
//
//            logger.info("qrUrl================================="+qrUrl);
//
//            Boolean result=deviceInfoService.saveDeviceInfo(deviceInfoReq);
//
//
//            if (result){
//                return  AjaxResult.success();
//            }else{
//                return AjaxResult.failed("保存失败");
//            }
//
//
//        }
//        catch (Exception e){
//            logger.error("DeviceInfoController.saveDeviceInfo", e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
////
//    /**
//     * 发送命令
//     * @param deviceInfoReq
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/sendCmdToDevice")
//    public AjaxResult sendCmdToDevice(DeviceInfoReq deviceInfoReq, HttpServletRequest request){
//        try{
//
//            String sUrl=SystemConst.ONENET_DOMAIN+"cmds?device_id="+deviceInfoReq.getDevId()+"&qos=1";
//
//            logger.info(sUrl);
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("req", deviceInfoReq.getCmd());
//
//            CmdSend cResult=  JSON.parseObject((HttpSendCenter.post(SystemConst.ONENET_APIKET, sUrl, jsonObject).toString()),CmdSend.class);
//            logger.info(cResult.toString());
//
//            if ("0".equals(cResult.getErrno())){
//                return  AjaxResult.success();
//            }else{
//                return AjaxResult.failed("失败");
//            }
//
//        }
//        catch (Exception e){
//            logger.error("DeviceInfoController.sendCmdToDevice", e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//    @RequestMapping("/updateDeviceInfo")
//    @ResponseBody
//    public AjaxResult updateDeviceInfo(DeviceInfoReq deviceInfoReq) {
//        try {
//            Assert.notNull(deviceInfoReq.getId(), "设备ID不能为空！");
//        } catch (Exception e) {
//            return AjaxResult.failed(e.getMessage());
//        }
//        try {
//            DeviceInfo deviceInfo = new DeviceInfo();
//            deviceInfo.setId(deviceInfoReq.getId());
//            deviceInfo.setIslost(deviceInfoReq.getIslost());
//            deviceInfo.setIsfix(deviceInfoReq.getIsfix());
//            deviceInfo.setIsinstock(deviceInfoReq.getIsinstock());
//            deviceInfo.setGmtModified(new Date());
//
//            deviceInfoService.updateDeviceInfo(deviceInfo);
//            return AjaxResult.success();
//        } catch (Exception e) {
//            logger.error("DeviceInfoController.updateDeviceInfo", e);
//            e.printStackTrace();
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//
//    @RequestMapping("/updateDeviceInfoCity")
//    @ResponseBody
//    public AjaxResult updateDeviceInfoCity(DeviceInfoReq deviceInfoReq) {
//        try {
//            Assert.notNull(deviceInfoReq.getId(), "设备ID不能为空！");
//        } catch (Exception e) {
//            return AjaxResult.failed(e.getMessage());
//        }
//        try {
//            DeviceInfo deviceInfo = new DeviceInfo();
//            deviceInfo.setId(deviceInfoReq.getId());
//            deviceInfo.setCityid(deviceInfoReq.getCityid());
//            deviceInfo.setGmtModified(new Date());
//
//            deviceInfoService.updateDeviceInfo(deviceInfo);
//            return AjaxResult.success();
//        } catch (Exception e) {
//            logger.error("DeviceInfoController.updateDeviceInfo", e);
//            e.printStackTrace();
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//
//
//    /**
//     * 增加
//     *
//     * @param deviceInfoReq
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/saveBatData")
//    public AjaxResult saveBatData(DeviceInfoReq deviceInfoReq, MultipartFile picFile, HttpServletRequest request) {
//
//        try {
//
//            String name = picFile.getOriginalFilename();
//            if(!StringUtils.hasLength(name)){
//                return AjaxResult.failed("请选择正确的文件");
//            }
//            if(name.indexOf(".csv")< 0){
//
//                return AjaxResult.failed("请选择正确类型的文件");
//            }
//
////            if(nameadd.length > 1){
////
////                if (!"csv".equals(nameadd[1].toLowerCase())){
////                    return AjaxResult.failed("请选择正确类型的文件");
////                }
////            }else {
////                return AjaxResult.failed("请选择正确的文件");
////            }
//
//
//        } catch (Exception e) {
//            return AjaxResult.failed(e.getMessage());
//        }
//
//        try {
//
//            boolean result=true;
//
//            String csvPathout=env.getProperty("excel.csvPath");
//            String csvFileName = UploadFileUtil.uploadFile(picFile, "ZZ",csvPathout);
//            String csvPathe=csvPathout+csvFileName;
//
//            DataInputStream in = new DataInputStream(new FileInputStream(new File(csvPathe)));
//            BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));
//            //第一行信息，为标题信息，不用,如果需要，注释掉
//            reader.readLine();
//            String line;
//
//            List<DeviceInfoReq> listNewDevice=new ArrayList<DeviceInfoReq>();
//
//            while((line=reader.readLine())!=null){
//                //CSV格式文件为逗号分隔符文件，这里根据逗号切分
//                String item[] = line.split(",");
//                DeviceInfoReq deviceInfoReqN=new DeviceInfoReq();
//                deviceInfoReqN.setTitle(item[0]);
//                deviceInfoReqN.setDevdesc(item[1]);
//                deviceInfoReqN.setAuthInfo(item[2]);
//                listNewDevice.add(deviceInfoReqN);
//            }
//            for (int i=0;i<listNewDevice.size();i++){
//                AjaxResult r=registNewDevice(listNewDevice.get(i));
//            }
//
//            if (result) {
//                return AjaxResult.success();
//            } else {
//                return AjaxResult.failed("失败");
//            }
//
//        } catch (Exception e) {
//            logger.error("BannerController.saveBanner异常", e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//    /**
//     * 注册新设备
//     *
//     * @param deviceInfoReq
//     * @return
//     */
//    public AjaxResult registNewDevice(DeviceInfoReq deviceInfoReq) {
//
//        try{
//
//            String sAuthInfo=deviceInfoReq.getAuthInfo();
//            DeviceInfo deviceInfoVO=deviceInfoService.findByAutoInfo(sAuthInfo);
//
//            if(deviceInfoVO!=null){
//                return AjaxResult.failed("鉴权号已经注册，请检查鉴权号");
//            }
//
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("title", deviceInfoReq.getTitle());
//            jsonObject.put("desc", deviceInfoReq.getDevdesc());
//            jsonObject.put("private", "true");
//            jsonObject.put("auth_info", deviceInfoReq.getAuthInfo());
//            CmdSend cResult= JSON.parseObject((HttpSendCenter.post(SystemConst.ONENET_APIKET, "http://api.heclouds.com/devices", jsonObject).toString()),CmdSend.class);
//            if (!"0".equals(cResult.getErrno())){
//                return AjaxResult.failed("OneNet注册失败");
//            }
//
//            deviceInfoReq.setDevId(cResult.getData().getDevice_id()) ;
//
//            //生成唯一二维码
//            String qrUrl=QRCodeUtil.generateQRCode(cResult.getData().getDevice_id(),env.getProperty("qrcode.filePath"));
//
//            logger.info("qrUrl================================="+qrUrl);
//
//            deviceInfoReq.setQrurl(qrUrl);
//            Boolean result=deviceInfoService.saveDeviceInfo(deviceInfoReq);
//
//
//            if (result){
//                return  AjaxResult.success();
//            }else{
//                return AjaxResult.failed("保存失败");
//            }
//            @ResponseBody
//            @RequestMapping(value = "/getDeviceInfoList")
//            public PageInfoRsp<DeviceInfoDTO> getDeviceInfoList(DeviceInfoQuery deviceInfoQuery){
//                try{
//
//                    String sfiter= RedisUtil.get(RedisKey.USER_ADMIN_CITY+getUserId().toString());
//
//                    if(!"".equals(sfiter)){
//                        deviceInfoQuery.setCityid(sfiter);
//
//                    }
//
//                    PageInfoRsp<DeviceInfoDTO> pageInfoRsp=deviceInfoService.getDeviceInfoList(deviceInfoQuery);
//
//                    return pageInfoRsp;
//                }catch (Exception e){
//                    logger.error("DeviceInfoController.getDeviceInfoList异常", e);
//                    return null;
//                }
//            }
//
//
//            /**
//             * 获取所有城市信息
//             *
//             * @return
//             */
//            @ResponseBody
//            @RequestMapping(value = "/getBaseCityListByPid")
//            public AjaxResult getBaseCityListByPid(DeviceInfoQuery deviceInfoQuery) {
//                try {
//
//                    List<BaseCityVO> baseCityVOList =baseCityService.getBaseCityByParentId(deviceInfoQuery.getCitypid());
//
//                    return AjaxResult.success(baseCityVOList);
//
//                } catch (Exception e) {
//                    logger.error("AdminCityController.getBaseCityListByPid: 异常 ", e);
//                    return null;
//                }
//            }
//
//
//
//            /**
//             * 增加
//             * @param deviceInfoReq
//             * @param request
//             * * @return
//             */
//            @ResponseBody
//            @RequestMapping(value = "/saveDeviceInfo")
//            @RequiresPermissions(PermResourceConst.DEVICE_MANAGEMENT)
//            public AjaxResult saveDeviceInfo(DeviceInfoReq deviceInfoReq, HttpServletRequest request){
//
//                try{
//
//                    String s=deviceInfoReq.getAuthInfo();
//                    DeviceInfo deviceInfoVO=deviceInfoService.findByAutoInfo(s);
//                    if(deviceInfoVO!=null){
//                        return AjaxResult.failed("鉴权号已经注册，请检查鉴权号");
//                    }
//                    JSONObject jsonObject=new JSONObject();
//                    jsonObject.put("title", deviceInfoReq.getTitle());
//                    jsonObject.put("desc", deviceInfoReq.getDevdesc());
//                    //jsonObject.put("tags", "['china','mobile']");
//                    jsonObject.put("private", "true");
//                    jsonObject.put("auth_info", deviceInfoReq.getAuthInfo());
//                    //jsonObject.put("other", "{}");
//
//                    CmdSend cResult= JSON.parseObject((HttpSendCenter.post(SystemConst.ONENET_APIKET, "http://api.heclouds.com/devices", jsonObject).toString()),CmdSend.class);
//
//                    if (!"0".equals(cResult.getErrno())){
//
//                        return AjaxResult.failed("OneNet注册失败");
//                    }
//
//                    deviceInfoReq.setDevId(cResult.getData().getDevice_id()) ;
//
//                    //生成唯一二维码
//                    String qrUrl=QRCodeUtil.generateQRCode(cResult.getData().getDevice_id(),env.getProperty("qrcode.filePath"));
//
//                    logger.info("qrUrl================================="+qrUrl);
//
//                    Boolean result=deviceInfoService.saveDeviceInfo(deviceInfoReq);
//
//
//                    if (result){
//                        return  AjaxResult.success();
//                    }else{
//                        return AjaxResult.failed("保存失败");
//                    }
//
//
//                }
//                catch (Exception e){
//                    logger.error("DeviceInfoController.saveDeviceInfo", e);
//                    return AjaxResult.failed("服务器处理异常");
//                }
//
//            }
//
////
//            /**
//             * 发送命令
//             * @param deviceInfoReq
//             * @param request
//             * @return
//             */
//            @ResponseBody
//            @RequestMapping(value = "/sendCmdToDevice")
//            public AjaxResult sendCmdToDevice(DeviceInfoReq deviceInfoReq, HttpServletRequest request){
//                try{
//
//                    String sUrl=SystemConst.ONENET_DOMAIN+"cmds?device_id="+deviceInfoReq.getDevId()+"&qos=1";
//
//                    logger.info(sUrl);
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put("req", deviceInfoReq.getCmd());
//
//                    CmdSend cResult=  JSON.parseObject((HttpSendCenter.post(SystemConst.ONENET_APIKET, sUrl, jsonObject).toString()),CmdSend.class);
//                    logger.info(cResult.toString());
//
//                    if ("0".equals(cResult.getErrno())){
//                        return  AjaxResult.success();
//                    }else{
//                        return AjaxResult.failed("失败");
//                    }
//
//                }
//                catch (Exception e){
//                    logger.error("DeviceInfoController.sendCmdToDevice", e);
//                    return AjaxResult.failed("服务器处理异常");
//                }
//
//            }
//
//            @RequestMapping("/updateDeviceInfo")
//            @ResponseBody
//            public AjaxResult updateDeviceInfo(DeviceInfoReq deviceInfoReq) {
//                try {
//                    Assert.notNull(deviceInfoReq.getId(), "设备ID不能为空！");
//                } catch (Exception e) {
//                    return AjaxResult.failed(e.getMessage());
//                }
//                try {
//                    DeviceInfo deviceInfo = new DeviceInfo();
//                    deviceInfo.setId(deviceInfoReq.getId());
//                    deviceInfo.setIslost(deviceInfoReq.getIslost());
//                    deviceInfo.setIsfix(deviceInfoReq.getIsfix());
//                    deviceInfo.setIsinstock(deviceInfoReq.getIsinstock());
//                    deviceInfo.setGmtModified(new Date());
//
//                    deviceInfoService.updateDeviceInfo(deviceInfo);
//                    return AjaxResult.success();
//                } catch (Exception e) {
//                    logger.error("DeviceInfoController.updateDeviceInfo", e);
//                    e.printStackTrace();
//                    return AjaxResult.failed("服务器处理异常");
//                }
//
//            }
//
//
//            @RequestMapping("/updateDeviceInfoCity")
//            @ResponseBody
//            public AjaxResult updateDeviceInfoCity(DeviceInfoReq deviceInfoReq) {
//                try {
//                    Assert.notNull(deviceInfoReq.getId(), "设备ID不能为空！");
//                } catch (Exception e) {
//                    return AjaxResult.failed(e.getMessage());
//                }
//                try {
//                    DeviceInfo deviceInfo = new DeviceInfo();
//                    deviceInfo.setId(deviceInfoReq.getId());
//                    deviceInfo.setCityid(deviceInfoReq.getCityid());
//                    deviceInfo.setGmtModified(new Date());
//
//                    deviceInfoService.updateDeviceInfo(deviceInfo);
//                    return AjaxResult.success();
//                } catch (Exception e) {
//                    logger.error("DeviceInfoController.updateDeviceInfo", e);
//                    e.printStackTrace();
//                    return AjaxResult.failed("服务器处理异常");
//                }
//
//            }
//
//
//
//            /**
//             * 增加
//             *
//             * @param deviceInfoReq
//             * @param request
//             * @return
//             */
//            @ResponseBody
//            @RequestMapping(value = "/saveBatData")
//            public AjaxResult saveBatData(DeviceInfoReq deviceInfoReq, MultipartFile picFile, HttpServletRequest request) {
//
//                try {
//
//                    String name = picFile.getOriginalFilename();
//                    if(!StringUtils.hasLength(name)){
//                        return AjaxResult.failed("请选择正确的文件");
//                    }
//                    if(name.indexOf(".csv")< 0){
//
//                        return AjaxResult.failed("请选择正确类型的文件");
//                    }
//
////            if(nameadd.length > 1){
////
////                if (!"csv".equals(nameadd[1].toLowerCase())){
////                    return AjaxResult.failed("请选择正确类型的文件");
////                }
////            }else {
////                return AjaxResult.failed("请选择正确的文件");
////            }
//
//
//                } catch (Exception e) {
//                    return AjaxResult.failed(e.getMessage());
//                }
//
//                try {
//
//                    boolean result=true;
//
//                    String csvPathout=env.getProperty("excel.csvPath");
//                    String csvFileName = UploadFileUtil.uploadFile(picFile, "ZZ",csvPathout);
//                    String csvPathe=csvPathout+csvFileName;
//
//                    DataInputStream in = new DataInputStream(new FileInputStream(new File(csvPathe)));
//                    BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));
//                    //第一行信息，为标题信息，不用,如果需要，注释掉
//                    reader.readLine();
//                    String line;
//
//                    List<DeviceInfoReq> listNewDevice=new ArrayList<DeviceInfoReq>();
//
//                    while((line=reader.readLine())!=null){
//                        //CSV格式文件为逗号分隔符文件，这里根据逗号切分
//                        String item[] = line.split(",");
//                        DeviceInfoReq deviceInfoReqN=new DeviceInfoReq();
//                        deviceInfoReqN.setTitle(item[0]);
//                        deviceInfoReqN.setDevdesc(item[1]);
//                        deviceInfoReqN.setAuthInfo(item[2]);
//                        listNewDevice.add(deviceInfoReqN);
//                    }
//                    for (int i=0;i<listNewDevice.size();i++){
//                        AjaxResult r=registNewDevice(listNewDevice.get(i));
//                    }
//
//                    if (result) {
//                        return AjaxResult.success();
//                    } else {
//                        return AjaxResult.failed("失败");
//                    }
//
//                } catch (Exception e) {
//                    logger.error("BannerController.saveBanner异常", e);
//                    return AjaxResult.failed("服务器处理异常");
//                }
//
//            }
//
//            /**
//             * 注册新设备
//             *
//             * @param deviceInfoReq
//             * @return
//             */
//            public AjaxResult registNewDevice(DeviceInfoReq deviceInfoReq) {
//
//                try{
//
//                    String sAuthInfo=deviceInfoReq.getAuthInfo();
//                    DeviceInfo deviceInfoVO=deviceInfoService.findByAutoInfo(sAuthInfo);
//
//                    if(deviceInfoVO!=null){
//                        return AjaxResult.failed("鉴权号已经注册，请检查鉴权号");
//                    }
//
//                    JSONObject jsonObject=new JSONObject();
//                    jsonObject.put("title", deviceInfoReq.getTitle());
//                    jsonObject.put("desc", deviceInfoReq.getDevdesc());
//                    jsonObject.put("private", "true");
//                    jsonObject.put("auth_info", deviceInfoReq.getAuthInfo());
//                    CmdSend cResult= JSON.parseObject((HttpSendCenter.post(SystemConst.ONENET_APIKET, "http://api.heclouds.com/devices", jsonObject).toString()),CmdSend.class);
//                    if (!"0".equals(cResult.getErrno())){
//                        return AjaxResult.failed("OneNet注册失败");
//                    }
//
//                    deviceInfoReq.setDevId(cResult.getData().getDevice_id()) ;
//
//                    //生成唯一二维码
//                    String qrUrl=QRCodeUtil.generateQRCode(cResult.getData().getDevice_id(),env.getProperty("qrcode.filePath"));
//
//                    logger.info("qrUrl================================="+qrUrl);
//
//                    deviceInfoReq.setQrurl(qrUrl);
//                    Boolean result=deviceInfoService.saveDeviceInfo(deviceInfoReq);
//
//
//                    if (result){
//                        return  AjaxResult.success();
//                    }else{
//                        return AjaxResult.failed("保存失败");
//                    }
//
//                }
//                catch (Exception e){
//                    logger.error("DeviceInfoController.saveDeviceInfo", e);
//                    return AjaxResult.failed("服务器处理异常");
//                }
//
//            }
//        }
//        catch (Exception e){
//            logger.error("DeviceInfoController.saveDeviceInfo", e);
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }

}
