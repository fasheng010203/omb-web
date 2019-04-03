package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.admin.AdminCity;
import com.onemile.bms.entity.easyuitree.EasyUITreeNew;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminCityReq;
import com.onemile.bms.pojo.dto.device.BaseCityQuery;
import com.onemile.bms.pojo.vo.zxshare.base.BaseCityVO;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.admin.AdminCityService;
import com.onemile.bms.service.device.BaseCityService;
import com.onemile.bms.utils.EasyuiUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Hardy on 2018-09-11.
 */
@Controller
@RequestMapping("/admin")
public class AdminCityController extends BaseController {

    @Autowired
    private BaseCityService baseCityService;

    @Autowired
    private AdminCityService adminCityService;


    @RequestMapping(value = "/admincity")
    @RequiresPermissions(PermResourceConst.GOODS_SPEC_MGR)
    public String admincity(Model model,String userId) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.GOODS_SPEC_ADD);
        permMap.put("update", PermResourceConst.GOODS_SPEC_UPDATE);
        permMap.put("del", PermResourceConst.GOODS_SPEC_DEL);
        model.addAttribute("userId", userId);
        model.addAllAttributes(permMap);
        return "admin/adminCity";
    }


    /**
     * 获取所有城市信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBaseCityStartList")
    public List<BaseCityVO> getBaseCityStartList() {
        try {
            return baseCityService.getBaseCityByType(2);
        } catch (Exception e) {
            logger.error("AdminCityController.getBaseCityList: 异常 ", e);
            return null;
        }
    }


    @RequestMapping("/getCityTree")
    @ResponseBody
    public List<EasyUITreeNew> getCityTree() {
        Map<String, Object> map = new HashMap<>();
        List<EasyUITreeNew> treeDataList = new ArrayList<EasyUITreeNew>();

        List<BaseCityVO> dataList = baseCityService.getBaseCityByType(1);

        for (BaseCityVO baseCityVO : dataList) {
            EasyUITreeNew tree = new EasyUITreeNew();
            if (baseCityVO.getParentId() == 0) {
                tree.setState("open");
            } else {
                tree.setState("closed");
            }
            tree.setId(baseCityVO.getId() + "");
            tree.setText(baseCityVO.getName());
            tree.setPid(baseCityVO.getParentId() + "");
            Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("nodeType", "0");
            tree.setAttributes(maps);
            treeDataList.add(tree);

        }


        List<EasyUITreeNew> treeList = EasyuiUtil.getfatherNode("0", treeDataList);

        return treeList;
    }


    @ResponseBody
    @RequestMapping(value = "/getBaseCityList")
    public PageInfoRsp<BaseCityVO> getBaseCityList(BaseCityQuery baseCityQuery) {
        try {
            PageInfoRsp<BaseCityVO> baseCityVOPageInfoRsp = baseCityService.getBaseCityList(baseCityQuery);

            return baseCityVOPageInfoRsp;
        } catch (Exception e) {
            logger.error("AdminCityController：getBaseCityList", e);
            e.printStackTrace();
            return null;
        }
    }
//
//
//    @RequestMapping("/updateGoodsSpecIsShow")
//    @ResponseBody
//    public AjaxResult updateGoodsSpecIsShow(GoodsSpecReq goodsSpecReq) {
//        try {
//            Assert.notNull(goodsSpecReq.getId(), "id不能为空！");
//        } catch (Exception e) {
//            return AjaxResult.failed(e.getMessage());
//        }
//        try {
//            GoodsSpec goodsSpec = new GoodsSpec();
//            goodsSpec.setId(goodsSpecReq.getId());
//            goodsSpec.setStatus(goodsSpecReq.getStatus());
//            goodsSpec.setGmtModified(new Date());
//            goodsSpecService.updateGoodsSpecIsShow(goodsSpec);
//            return AjaxResult.success();
//        } catch (Exception e) {
//            logger.error("GoodsSpecController.updateGoodsSpecIsShow", e);
//            e.printStackTrace();
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//
//    @RequestMapping("/updateGoodsSpec")
//    @ResponseBody
//    public AjaxResult updateGoodsSpec(GoodsSpecReq goodsSpecReq) {
//        try {
//            Assert.notNull(goodsSpecReq.getId(), "id不能为空！");
//        } catch (Exception e) {
//            return AjaxResult.failed(e.getMessage());
//        }
//        try {
//            GoodsSpec goodsSpec = new GoodsSpec();
//            goodsSpec.setId(goodsSpecReq.getId());
//            goodsSpec.setSpecName(goodsSpecReq.getSpecName());
//            goodsSpec.setAccountUnit(goodsSpecReq.getAccountUnit());
//            goodsSpec.setConvertUnit(goodsSpecReq.getConvertUnit());
//            goodsSpec.setCompensateUnit(goodsSpecReq.getCompensateUnit());
//            goodsSpec.setCovertRatio(goodsSpecReq.getCovertRatio());
//            goodsSpec.setCompensateRatio(goodsSpecReq.getCompensateRatio());
//            goodsSpec.setGmtModified(new Date());
//            goodsSpecService.updateGoodsSpecIsShow(goodsSpec);
//            return AjaxResult.success();
//        } catch (Exception e) {
//            logger.error("GoodsSpecController.updateGoodsSpecIsShow", e);
//            e.printStackTrace();
//            return AjaxResult.failed("服务器处理异常");
//        }
//
//    }
//
//
    @RequestMapping("/saveAdminCity")
    @ResponseBody
    public AjaxResult saveAdminCity(AdminCityReq aminCityReq) {

        try {

            AdminCity queryAdminCity=new AdminCity();
            queryAdminCity.setUsercity(aminCityReq.getUsercity());
            queryAdminCity.setUserid(aminCityReq.getUserid());

            AdminCity adminCity=adminCityService.findByUserId(queryAdminCity);
            AdminCity newAdminCity=new AdminCity();
            newAdminCity.setGmtCreate(new Date());
            newAdminCity.setGmtModified(new Date());
            newAdminCity.setUserid(aminCityReq.getUserid());
            newAdminCity.setUsercity(aminCityReq.getUsercity());


            if (adminCity == null) {
                adminCityService.insertSelective(newAdminCity);
            } else {
                adminCityService.updateSelective(newAdminCity);
            }

            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminCityController.saveAdminCity", e);
            e.printStackTrace();
            return AjaxResult.failed("服务器处理异常");
        }

    }


    @RequestMapping("/delAdminCity")
    @ResponseBody
    public AjaxResult delAdminCity(AdminCityReq aminCityReq) {

        try {

            AdminCity queryAdminCity=new AdminCity();
            queryAdminCity.setUsercity(aminCityReq.getUsercity());
            queryAdminCity.setUserid(aminCityReq.getUserid());

            adminCityService.deleteAdminCityByUserIdAndCity(queryAdminCity);

            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminCityController.delAdminCity", e);
            e.printStackTrace();
            return AjaxResult.failed("服务器处理异常");
        }

    }











}
