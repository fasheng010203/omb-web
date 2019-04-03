package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.admin.AdminDept;
import com.onemile.bms.entity.easyuitree.EasyUITreeNew;
import com.onemile.bms.pojo.dto.admin.AdminDeptReq;
import com.onemile.bms.pojo.vo.admin.AdminDeptTreeGridVO;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.admin.AdminDeptService;
import com.onemile.bms.service.admin.AdminUserService;
import com.onemile.bms.utils.EasyuiUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author Eric
 * @Description:
 * @date 2018/6/29
 */
@Controller
@RequestMapping("/admin")
public class AdminDeptController extends BaseController {

    @Autowired
    private AdminDeptService adminDeptService;

    @Autowired
    private AdminUserService adminUserService;


    @RequestMapping(value = "/dept")
    @RequiresPermissions(PermResourceConst.PERM_ORG_MGR)
    public String adminDept(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.PERM_ORG_ADD);
        permMap.put("update", PermResourceConst.PERM_ORG_UPDATE);
        permMap.put("del", PermResourceConst.PERM_ORG_DEL);
        model.addAllAttributes(permMap);

        return "admin/adminDept";
    }


    /**
     * 查询组织机构信息，返回jqgrid treegrid 数据
     *
     * @return
     */
    @RequestMapping("/getDeptList")
    @RequiresPermissions(PermResourceConst.PERM_ORG_MGR)
    @ResponseBody
    public Map<String, Object> getDeptList() {

        Map<String, Object> map = new HashMap<>();

        List<AdminDept> deptList = adminDeptService.listDept(getMchId(), null);

        if (deptList == null || deptList.size() <= 0) {
            map.put("rows", null);
            return map;
        }

        // 重组数据 jqgridtree 无法自动排序，必须组装成一个完整的树   ps: 组装3层
        List<AdminDeptTreeGridVO> adminDeptTreeGridVOList = new ArrayList<>();
        for (AdminDept adminDept : deptList) {
            if (adminDept.getParentId() == 0) {
                AdminDeptTreeGridVO adminDeptTreeGridVO = new AdminDeptTreeGridVO();
                adminDeptTreeGridVO.setExpanded(true);
                if (adminDept.getLeaf() == 1) {
                    adminDeptTreeGridVO.setLeaf(true);
                } else {
                    adminDeptTreeGridVO.setLeaf(false);
                }
                adminDeptTreeGridVO.setId(adminDept.getId());
                adminDeptTreeGridVO.setParentId(adminDept.getParentId());
                adminDeptTreeGridVO.setName(adminDept.getName());
                adminDeptTreeGridVO.setLayer(adminDept.getLayer());
                adminDeptTreeGridVO.setOrderNo(adminDept.getOrderNo());
                adminDeptTreeGridVO.setGmtCreate(adminDept.getGmtCreate());
                adminDeptTreeGridVO.setGmtModified(adminDept.getGmtModified());
                adminDeptTreeGridVOList.add(adminDeptTreeGridVO);
                for (AdminDept dept : deptList) {
                    if (adminDept.getId().equals(dept.getParentId())) {
                        AdminDeptTreeGridVO dtg = new AdminDeptTreeGridVO();
                        dtg.setExpanded(true);
                        if (dept.getLeaf() == 1) {
                            dtg.setLeaf(true);
                        } else {
                            dtg.setLeaf(false);
                        }
                        dtg.setId(dept.getId());
                        dtg.setParentId(dept.getParentId());
                        dtg.setName(dept.getName());
                        dtg.setLayer(dept.getLayer());
                        dtg.setOrderNo(dept.getOrderNo());
                        dtg.setGmtCreate(dept.getGmtCreate());
                        dtg.setGmtModified(dept.getGmtModified());
                        adminDeptTreeGridVOList.add(dtg);
                        for (AdminDept dt : deptList) {
                            if (dept.getId().equals(dt.getParentId())) {
                                AdminDeptTreeGridVO dtgf = new AdminDeptTreeGridVO();
                                dtgf.setLeaf(true);
                                if (dt.getLeaf() == 1) {
                                    dtgf.setLeaf(true);
                                } else {
                                    dtgf.setLeaf(false);
                                }
                                dtgf.setId(dt.getId());
                                dtgf.setParentId(dt.getParentId());
                                dtgf.setName(dt.getName());
                                dtgf.setLayer(dt.getLayer());
                                dtgf.setOrderNo(dt.getOrderNo());
                                dtgf.setGmtCreate(dt.getGmtCreate());
                                dtgf.setGmtModified(dt.getGmtModified());
                                adminDeptTreeGridVOList.add(dtgf);
                            }
                        }
                    }

                }
            }
        }

        map.put("rows", adminDeptTreeGridVOList);

        return map;


    }


    /**
     * 查询easyui tree格式的数据
     *
     * @return
     */
    @RequestMapping("/getDeptTreeList")
    @ResponseBody
    public List<EasyUITreeNew> getDeptTreeList() {
        List<EasyUITreeNew> treeDataList = new ArrayList<EasyUITreeNew>();
        List<AdminDept> dataList = adminDeptService.listDept(getMchId(), null);
        for (AdminDept adminDept : dataList) {
            EasyUITreeNew tree = new EasyUITreeNew();
            if (adminDept.getParentId() == 0) {
                tree.setState("open");
            } else {
                tree.setState("closed");
            }
            tree.setId(adminDept.getId() + "");
            tree.setText(adminDept.getName());
            tree.setPid(adminDept.getParentId() + "");
            Map<String, Object> maps = new HashMap<>(1);
            maps.put("nodeType", "0");
            tree.setAttributes(maps);
            treeDataList.add(tree);

        }
        List<EasyUITreeNew> treeList = EasyuiUtil.getfatherNode("0", treeDataList);

        return treeList;
    }


    /**
     * 保存组织机构信息
     *
     * @param adminDeptReq
     * @return
     */
    @RequestMapping("/saveDept")
    @RequiresPermissions(PermResourceConst.PERM_ORG_ADD)
    @ResponseBody
    public AjaxResult saveDept(AdminDeptReq adminDeptReq) {
        try {
            Assert.notNull(adminDeptReq.getOrderNo(), "显示排序不能为空！");
            Assert.notNull(adminDeptReq.getParentId(), "所属机构不能为空！");
            Assert.hasText(adminDeptReq.getName(), "机构名称不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }

        try {
            if (adminDeptService.checkDeptName(getMchId(), adminDeptReq.getName(), null)) {
                return AjaxResult.failed("组织机构名称重复");
            }
            Date now = new Date();
            AdminDept dept = new AdminDept();
            dept.setMchId(getMchId());
            dept.setName(adminDeptReq.getName());
            dept.setOrderNo(adminDeptReq.getOrderNo());
            dept.setParentId(adminDeptReq.getParentId());
            dept.setLayer(adminDeptReq.getLayer() + 1);
            dept.setLeaf(1);
            dept.setGmtCreate(now);
            dept.setGmtModified(now);
            adminDeptService.saveDept(dept);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminDeptController.saveDept异常", e);
            return AjaxResult.failed("服务器处理异常");
        }

    }

    @RequestMapping("/updateDept")
    @RequiresPermissions(PermResourceConst.PERM_ORG_UPDATE)
    @ResponseBody
    public AjaxResult updateDept(AdminDeptReq adminDeptReq) {
        try {
            Assert.notNull(adminDeptReq.getOrderNo(), "显示排序不能为空！");
            Assert.notNull(adminDeptReq.getParentId(), "所属机构不能为空！");
            Assert.hasText(adminDeptReq.getName(), "机构名称不能为空！");
            Assert.notNull(adminDeptReq.getDeptId(), "id不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            if (adminDeptService.checkDeptName(getMchId(), adminDeptReq.getName(), adminDeptReq.getDeptId())) {
                return AjaxResult.failed("组织机构名称重复");
            }
            AdminDept dept = new AdminDept();
            dept.setName(adminDeptReq.getName());
            dept.setOrderNo(adminDeptReq.getOrderNo());
            dept.setGmtModified(new Date());
            dept.setId(adminDeptReq.getDeptId());
            adminDeptService.updateSelective(dept);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminDeptController.updateDept 异常 ", e);
            return AjaxResult.failed("服务器处理异常");
        }

    }

    /**
     * 删除机构
     *
     * @param adminDeptReq
     * @return
     */
    @RequestMapping("/delDept")
    @RequiresPermissions(PermResourceConst.PERM_ORG_DEL)
    @ResponseBody
    public AjaxResult delDept(AdminDeptReq adminDeptReq) {
        try {
            Assert.notNull(adminDeptReq.getDeptId(), "id不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {

            // 判断该组织机构下是否有子机构
            List<AdminDept> depts = adminDeptService.listDept(null, adminDeptReq.getDeptId());
            if (depts != null && depts.size() > 0) {
                return AjaxResult.failed("含有子机构，不能删除");
            }
            // TODO 判断该组织机构下是否有用户
            Integer userCount = adminUserService.countByDept(adminDeptReq.getDeptId());
            if (userCount != null && userCount > 0) {
                return AjaxResult.failed("组织机构下含有用户，不能删除");
            }

            adminDeptService.deleteDept(adminDeptReq.getDeptId(), adminDeptReq.getParentId());

            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminDeptController.delDept异常 ", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

}
