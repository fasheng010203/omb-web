package com.onemile.bms.pojo.vo.zxshare.news;

import java.io.Serializable;
import java.util.Date;

public class SysNewsVO implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 类型  1-数据库文体型  2- url外链型
     */
    private Integer newsType;

    /**
     * 新闻标签
     */
    private String newsTag;

    /**
     * 资讯类别  1-热点  2-资讯  3-行情 
     */
    private Integer newsCategory;
    /**
     * 新闻模板id
     */
    private Integer newsTemplateId;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻简短描述
     */
    private String newsShortDes;

    /**
     * 外链url
     */
    private String newsUrl;

    /**
     * 标题配图，多个用逗号隔开。七牛完整链接
     */
    private String newsPic;

    /**
     * 作者
     */
    private String newsAuthor;

    /**
     * 资讯发布时间
     */
    private Date newsGmtCreate;

    /**
     * 是否置顶  0-否 1-是
     */
    private Integer isTop;

    /**
     * 阅读次数
     */
    private Integer readTimes;

    /**
     * 状态 0-初始化  1-正常
     */
    private Integer status;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 修改人id
     */
    private Integer updateUserId;

    /**
     * 修改人名称
     */
    private String updateUserName;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 新闻内容
     */
    private String newsContent;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 类型  1-数据库文体型  2- url外链型
     * @return news_type 类型  1-数据库文体型  2- url外链型
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * 类型  1-数据库文体型  2- url外链型
     * @param newsType 类型  1-数据库文体型  2- url外链型
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    /**
     * 新闻标签
     * @return news_tag 新闻标签
     */
    public String getNewsTag() {
        return newsTag;
    }

    /**
     * 新闻标签
     * @param newsTag 新闻标签
     */
    public void setNewsTag(String newsTag) {
        this.newsTag = newsTag == null ? null : newsTag.trim();
    }

    /**
     * 资讯类别  1-热点  2-资讯  3-行情 
     * @return news_category 资讯类别  1-热点  2-资讯  3-行情 
     */
    public Integer getNewsCategory() {
        return newsCategory;
    }

    /**
     * 资讯类别  1-热点  2-资讯  3-行情 
     * @param newsCategory 资讯类别  1-热点  2-资讯  3-行情 
     */
    public void setNewsCategory(Integer newsCategory) {
        this.newsCategory = newsCategory;
    }
    /**
     * 新闻模板id
     * @return news_template_id 新闻模板id
     */
    public Integer getNewsTemplateId() {
        return newsTemplateId;
    }

    /**
     * 新闻模板id
     * @param newsTemplateId 新闻模板id
     */
    public void setNewsTemplateId(Integer newsTemplateId) {
        this.newsTemplateId = newsTemplateId;
    }

    /**
     * 新闻标题
     * @return news_title 新闻标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 新闻标题
     * @param newsTitle 新闻标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * 新闻简短描述
     * @return news_short_des 新闻简短描述
     */
    public String getNewsShortDes() {
        return newsShortDes;
    }

    /**
     * 新闻简短描述
     * @param newsShortDes 新闻简短描述
     */
    public void setNewsShortDes(String newsShortDes) {
        this.newsShortDes = newsShortDes == null ? null : newsShortDes.trim();
    }

    /**
     * 外链url
     * @return news_url 外链url
     */
    public String getNewsUrl() {
        return newsUrl;
    }

    /**
     * 外链url
     * @param newsUrl 外链url
     */
    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }

    /**
     * 标题配图，多个用逗号隔开。七牛完整链接
     * @return news_pic 标题配图，多个用逗号隔开。七牛完整链接
     */
    public String getNewsPic() {
        return newsPic;
    }

    /**
     * 标题配图，多个用逗号隔开。七牛完整链接
     * @param newsPic 标题配图，多个用逗号隔开。七牛完整链接
     */
    public void setNewsPic(String newsPic) {
        this.newsPic = newsPic == null ? null : newsPic.trim();
    }

    /**
     * 作者
     * @return news_author 作者
     */
    public String getNewsAuthor() {
        return newsAuthor;
    }

    /**
     * 作者
     * @param newsAuthor 作者
     */
    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    /**
     * 资讯发布时间
     * @return news_gmt_create 资讯发布时间
     */
    public Date getNewsGmtCreate() {
        return newsGmtCreate;
    }

    /**
     * 资讯发布时间
     * @param newsGmtCreate 资讯发布时间
     */
    public void setNewsGmtCreate(Date newsGmtCreate) {
        this.newsGmtCreate = newsGmtCreate;
    }

    /**
     * 是否置顶  0-否 1-是
     * @return is_top 是否置顶  0-否 1-是
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
     * 是否置顶  0-否 1-是
     * @param isTop 是否置顶  0-否 1-是
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    /**
     * 阅读次数
     * @return read_times 阅读次数
     */
    public Integer getReadTimes() {
        return readTimes;
    }

    /**
     * 阅读次数
     * @param readTimes 阅读次数
     */
    public void setReadTimes(Integer readTimes) {
        this.readTimes = readTimes;
    }

    /**
     * 状态 0-初始化  1-正常
     * @return status 状态 0-初始化  1-正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0-初始化  1-正常
     * @param status 状态 0-初始化  1-正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建人id
     * @return create_user_id 创建人id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人id
     * @param createUserId 创建人id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 创建人名称
     * @return create_user_name 创建人名称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人名称
     * @param createUserName 创建人名称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 修改人id
     * @return update_user_id 修改人id
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 修改人id
     * @param updateUserId 修改人id
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 修改人名称
     * @return update_user_name 修改人名称
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 修改人名称
     * @param updateUserName 修改人名称
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    /**
     * 创建时间
     * @return gmt_create 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}