package com.onemile.bms.page;

import java.util.List;

/**
 * @author Eric
 * @Description: 适用用jqgrid 获取数据
 * @date
 */
public class PageInfoRsp<T> {

    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private Integer total;
    /**
     * 总记录数
     */
    private Long records;
    /**
     * 数据列表
     */
    private List<T> rows;
    /**
     * 是否为第一页
     */
    private boolean isFirstPage = false;
    /**
     * 是否为最后一页
     */
    private boolean isLastPage = false;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}
