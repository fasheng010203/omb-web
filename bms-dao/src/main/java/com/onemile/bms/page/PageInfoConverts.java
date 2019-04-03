package com.onemile.bms.page;

import com.github.pagehelper.PageInfo;

/**
 * @author Eric
 * @Description:
 * @date 2018/6/19
 */
public class PageInfoConverts {

    /**
     * pagehelper.PageInfo 转换
     *
     * @param pageInfo
     * @return
     */
    public static PageInfoRsp convert(PageInfo pageInfo) {

        PageInfoRsp rsp = new PageInfoRsp();
        
        rsp.setRows(pageInfo.getList());
        rsp.setPage(pageInfo.getPageNum());
        rsp.setPageSize(pageInfo.getPageSize());
        rsp.setRecords(pageInfo.getTotal());
        rsp.setTotal(pageInfo.getPages());
        rsp.setFirstPage(pageInfo.isIsFirstPage());
        rsp.setLastPage(pageInfo.isIsLastPage());

        return rsp;
    }


}
