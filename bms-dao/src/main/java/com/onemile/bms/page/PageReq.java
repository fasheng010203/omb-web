package com.onemile.bms.page;

/**
 * @author Eric
 * @Description:
 * @date 17/7/24
 */
public class PageReq {

    private static final int DEFAULT_ROWS = 10;
    /**
     * 当前页数
     */
    private Integer page;
    /**
     * 每页记录数
     */
    private Integer rows;
    /**
     * 排序字段名称
     */
    private String sidx;
    /**
     * 排序方式 asc  desc
     */
    private String sord;

    public Integer getPage() {
        if (page == null || page <= 0) {
            page = 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        if (rows == null || rows <= 0) {
            rows = DEFAULT_ROWS;
        }
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
