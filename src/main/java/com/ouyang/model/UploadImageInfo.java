package com.ouyang.model;

import java.util.Date;

public class UploadImageInfo {
    /**   id **/
    private Integer id;

    /** 图片地址  url **/
    private String url;

    /**   create_date **/
    private Date createDate;

    /**   user_info_id **/
    private String userInfoId;

    /** 查询结果  result **/
    private String result;

    /**     id   **/
    public Integer getId() {
        return id;
    }

    /**     id   **/
    public void setId(Integer id) {
        this.id = id;
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

    /**     user_info_id   **/
    public String getUserInfoId() {
        return userInfoId;
    }

    /**     user_info_id   **/
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
    }

    /**   查询结果  result   **/
    public String getResult() {
        return result;
    }

    /**   查询结果  result   **/
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}