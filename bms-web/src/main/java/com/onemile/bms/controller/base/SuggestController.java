package com.onemile.bms.controller.base;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.zxshare.base.SuggestQuery;
import com.onemile.bms.pojo.dto.zxshare.base.SuggestReq;
import com.onemile.bms.pojo.vo.zxshare.base.SuggestVO;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.share.base.SuggestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @author chenhao
 * @Description:
 * @date 2018/9/19
 */
@Controller
@RequestMapping("/base")
public class SuggestController extends BaseController {
    @Autowired
    private SuggestService suggestService;


    @RequestMapping(value = "/suggest")
    @RequiresPermissions(PermResourceConst.COMPANY_SUGGESTIONS_MGR)
    public String companyInfo(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        model.addAllAttributes(permMap);

        return "zxshare/base/suggest";
    }


    @ResponseBody
    @RequestMapping(value = "/getSuggestList")
    public PageInfoRsp<SuggestVO> getSuggestList(SuggestQuery suggestQuery) {
        try {
            PageInfoRsp<SuggestVO> pageInfoRsp = suggestService.getSuggestList(suggestQuery);
            return pageInfoRsp;
        } catch (Exception e) {
            logger.error("SuggestController.getSuggestList异常", e);
            return null;
        }
    }


    @RequestMapping("/auditSuggest")
    @ResponseBody
    public AjaxResult auditSuggest(SuggestReq suggestReq) {
        try {
            Assert.notNull(suggestReq.getId(), "id不能为空！");
            Assert.notNull(suggestReq.getStatus(), "状态不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            SuggestVO suggestVO = suggestService.getBySuggestId(suggestReq.getId());

            if (suggestVO.getStatus() == 1) {
                return AjaxResult.failed("该反馈已处理");
            }
            Boolean result = suggestService.auditCompanyVerify(suggestReq);
            if (result) {
                return AjaxResult.success();
            } else {
                return AjaxResult.failed("处理失败");
            }

        } catch (Exception e) {
            logger.error("SuggestController.auditSuggest", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

}
