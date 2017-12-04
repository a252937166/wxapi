package com.ouyang.model;

import java.util.Date;

public class VisitUserInfo {
    /**   id **/
    private String id;

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

    /**   create_date **/
    private Date createDate;

    /**   code **/
    private String code;

    /**   session_key **/
    private String sessionKey;

    /**     id   **/
    public String getId() {
        return id;
    }

    /**     id   **/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    /**     create_date   **/
    public Date getCreateDate() {
        return createDate;
    }

    /**     create_date   **/
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**     code   **/
    public String getCode() {
        return code;
    }

    /**     code   **/
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**     session_key   **/
    public String getSessionKey() {
        return sessionKey;
    }

    /**     session_key   **/
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }
}