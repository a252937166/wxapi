package com.ouyang.model;

import java.util.Date;

public class VisitUserInfo {
    /**   id **/
    private Integer id;

    /**   avatar_url **/
    private String avatarUrl;

    /**   city **/
    private String city;

    /**   country **/
    private String country;

    /**   gender **/
    private Integer gender;

    /**   language **/
    private String language;

    /**   nick_name **/
    private String nickName;

    /**   openid **/
    private String openid;

    /**   province **/
    private String province;

    /**   image_info_id **/
    private String imageInfoId;

    /**   create_date **/
    private Date createDate;

    /**     id   **/
    public Integer getId() {
        return id;
    }

    /**     id   **/
    public void setId(Integer id) {
        this.id = id;
    }

    /**     avatar_url   **/
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**     avatar_url   **/
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**     city   **/
    public String getCity() {
        return city;
    }

    /**     city   **/
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**     country   **/
    public String getCountry() {
        return country;
    }

    /**     country   **/
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**     gender   **/
    public Integer getGender() {
        return gender;
    }

    /**     gender   **/
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**     language   **/
    public String getLanguage() {
        return language;
    }

    /**     language   **/
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**     nick_name   **/
    public String getNickName() {
        return nickName;
    }

    /**     nick_name   **/
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**     openid   **/
    public String getOpenid() {
        return openid;
    }

    /**     openid   **/
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**     province   **/
    public String getProvince() {
        return province;
    }

    /**     province   **/
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**     image_info_id   **/
    public String getImageInfoId() {
        return imageInfoId;
    }

    /**     image_info_id   **/
    public void setImageInfoId(String imageInfoId) {
        this.imageInfoId = imageInfoId == null ? null : imageInfoId.trim();
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