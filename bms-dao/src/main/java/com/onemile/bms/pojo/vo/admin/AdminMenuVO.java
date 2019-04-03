package com.onemile.bms.pojo.vo.admin;

import java.util.List;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/24
 */
public class AdminMenuVO {

    private Long id;
    private Long pid;
    private String text;
    private String icon;
    private String url;
    private List<AdminMenuVO> menus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AdminMenuVO> getMenus() {
        return menus;
    }

    public void setMenus(List<AdminMenuVO> menus) {
        this.menus = menus;
    }


}
