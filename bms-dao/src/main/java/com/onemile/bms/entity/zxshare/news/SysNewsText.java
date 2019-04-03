package com.onemile.bms.entity.zxshare.news;

import java.io.Serializable;

public class SysNewsText implements Serializable {
    private Long id;
    /**
     * 新闻id
     */
    private Long newsId;

    /**
     * 新闻内容
     */
    private String newsContent;

    /**
     * 新闻id
     * @return news_id 新闻id
     */
    public Long getNewsId() {
        return newsId;
    }

    /**
     * 新闻id
     * @param newsId 新闻id
     */
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    /**
     * 新闻内容
     * @return news_content 新闻内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 新闻内容
     * @param newsContent 新闻内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}