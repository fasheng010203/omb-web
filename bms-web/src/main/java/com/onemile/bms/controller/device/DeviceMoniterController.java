package com.onemile.bms.controller.device;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.entity.device.SbLoc;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.pojo.dto.device.DeviceInfoDTO;
import com.onemile.bms.service.device.DeviceInfoService;
import com.onemile.bms.service.device.SbEventService;
import com.onemile.bms.service.device.SbLocService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
public class DeviceMoniterController extends BaseController {
    @Autowired
    private SbLocService sbLocService;
    @Autowired
    private SbEventService sbEventService;
    @Autowired
    private DeviceInfoService deviceInfoService;



    @RequestMapping(value = "/locshow")

    public String locMgr(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>();

        List<SbLoc> locList=sbLocService.getDeviceLocShowList();

//        Long dCnt=deviceInfoService.getDeviceCount();
//        Long dFixCnt=deviceInfoService.getDeviceFixCount();


        //logger.info(fixPersent+"||||"+dCnt+"||||||"+dFixCnt);




        List<DeviceInfoDTO> listDeviceInfo=deviceInfoService.listDeviceInfo();

        List<SbEvent> listDeviceEvt =sbEventService.listDeviceEvt();


        Long dFixCnt=0L;
        Long dNoWorkCnt=0L;
        Long dNeedChargeCnt=0L;
        Long dLowBatCnt=0L;

        //计算不工作增氧泵
        for( int i = 0 ; i < listDeviceEvt.size() ; i++) {

            if("OxbALocalStop".equals(listDeviceEvt.get(i).getEvt())  || "OxbBLocalStop".equals(listDeviceEvt.get(i).getEvt())
                    || "OxbARemoteStop".equals(listDeviceEvt.get(i).getEvt())  || "OxbBRemoteStop".equals(listDeviceEvt.get(i).getEvt())){
                dNoWorkCnt=dNoWorkCnt+1;
            }

            logger.info("yyyyyyyyyyyyyyyyyyyyyyyy"+listDeviceEvt.get(i).getEvt());
        }


        for( int i = 0 ; i < listDeviceInfo.size() ; i++) {

            //内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            if("1".equals(listDeviceInfo.get(i).getIsfix())){
                dFixCnt=dFixCnt+1;
            }

            logger.info(String.valueOf(listDeviceInfo.get(i).getMbat())+"yyyyyyyyyyyyyyyyyyyyyyyy");


            if (listDeviceInfo.get(i).getMbat() != null && !listDeviceInfo.get(i).getMbat().equals("")) {
                //do something
                if(listDeviceInfo.get(i).getMbat()<=3400){
                    dNeedChargeCnt=dNeedChargeCnt+1;
                }else if(listDeviceInfo.get(i).getMbat()>3400 && listDeviceInfo.get(i).getMbat()<3660){
                    dLowBatCnt=dLowBatCnt+1;
                }else {

                }
            }

        }

        Long dCnt=Long.parseLong(String.valueOf(listDeviceInfo.size()));

        //待维修占比
        String fixPersent=String.format("%.2f", ((dFixCnt.doubleValue() / dCnt.doubleValue()) * 100)) + "%";

        //超低电量占比
        String lowBatPersent=String.format("%.2f", ((dLowBatCnt.doubleValue() / dCnt.doubleValue()) * 100)) + "%";

        //增氧泵不工作占比
        String bNoWorkPersent=String.format("%.2f", ((dNoWorkCnt.doubleValue() / dCnt.doubleValue()/2) * 100)) + "%";
        //待充电占比
        String bNeedChargePersent=String.format("%.2f", ((dNeedChargeCnt.doubleValue() / dCnt.doubleValue()) * 100)) + "%";


         String.format("%.2f", ((dNeedChargeCnt.doubleValue() / dCnt.doubleValue()) * 100));


         double  dNormalWorkPersent = 100- ((dNeedChargeCnt.doubleValue() / dCnt.doubleValue()) * 100)
                 -((dFixCnt.doubleValue() / dCnt.doubleValue()) * 100);




        //正常工作占比
        String bNormalWorkPersent=String.format("%.2f",
                dNormalWorkPersent)+ "%";

        model.addAttribute("sbloclist",locList);
        model.addAttribute("fixPersent",fixPersent);
        model.addAttribute("bNoWorkPersent",bNoWorkPersent);
        model.addAttribute("bNeedChargePersent",bNeedChargePersent);
        model.addAttribute("bNormalWorkPersent",bNormalWorkPersent);
        model.addAttribute("lowBatPersent",lowBatPersent);



        return  "device/devicelocshow";

    }

    @ResponseBody
    @RequestMapping(value = "/getDeviceLocShowList")
    public List<SbLoc>  getDeviceLocShowList( ){
        try{
            Map<String, Object> map = new HashMap<>();
            List<SbLoc> locList=sbLocService.getDeviceLocShowList();

            return  locList;
        }catch (Exception e){
            logger.error("DeviceLocController.getDeviceLocList", e);
            return null;
        }
    }



}
