package com.ouyang.model;

import java.util.Date;

public class UploadImageInfo {
    /**   id **/
    private String id;

    /** 图片地址  url **/
    private String url;

    /**   create_date **/
    private Date createDate;

    /**     id   **/
    public String getId() {
        return id;
    }

    /**     id   **/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**   图片地址  url   **/
    public String getUrl() {
        return url;
    }

    /**   图片地址  url   **/
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**     create_date   **/
    public Date getCreateDate() {
        return createDate;
    }

    /**     create_date   **/
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}