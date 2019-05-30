package com.office.user.entity;

import java.util.Date;

public class OfficeUser {
    private Integer id;

    private String account;

    private String mobile;

    private String email;

    private String password;

    private String salt;

    private String alipay;

    private String wechat;

    private String relaname;

    private Byte sex;

    private Byte age;

    private String invitation;

    private String idcare;

    private String address;

    private String residence;

    private Date birthday;

    private Byte marital;

    private String nationa;

    private String avatar;

    private Date createTime;

    private Date updateTime;

    private String createName;

    private String updateName;

    private Byte isDelete;

    private String token;

    public OfficeUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getRelaname() {
        return relaname;
    }

    public void setRelaname(String relaname) {
        this.relaname = relaname == null ? null : relaname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation == null ? null : invitation.trim();
    }

    public String getIdcare() {
        return idcare;
    }

    public void setIdcare(String idcare) {
        this.idcare = idcare == null ? null : idcare.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence == null ? null : residence.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte getMarital() {
        return marital;
    }

    public void setMarital(Byte marital) {
        this.marital = marital;
    }

    public String getNationa() {
        return nationa;
    }

    public void setNationa(String nationa) {
        this.nationa = nationa == null ? null : nationa.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    @Override
    public String toString() {
        return "OfficeUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", alipay='" + alipay + '\'' +
                ", wechat='" + wechat + '\'' +
                ", relaname='" + relaname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", invitation='" + invitation + '\'' +
                ", idcare='" + idcare + '\'' +
                ", address='" + address + '\'' +
                ", residence='" + residence + '\'' +
                ", birthday=" + birthday +
                ", marital=" + marital +
                ", nationa='" + nationa + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createName='" + createName + '\'' +
                ", updateName='" + updateName + '\'' +
                ", isDelete=" + isDelete +
                ", token='" + token + '\'' +
                '}';
    }

    public OfficeUser(Integer id, String account, String mobile, String email, String password, String salt, String alipay, String wechat, String relaname, Byte sex, Byte age, String invitation, String idcare, String address, String residence, Date birthday, Byte marital, String nationa, String avatar, Date createTime, Date updateTime, String createName, String updateName, Byte isDelete, String token) {
        this.id = id;
        this.account = account;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.alipay = alipay;
        this.wechat = wechat;
        this.relaname = relaname;
        this.sex = sex;
        this.age = age;
        this.invitation = invitation;
        this.idcare = idcare;
        this.address = address;
        this.residence = residence;
        this.birthday = birthday;
        this.marital = marital;
        this.nationa = nationa;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createName = createName;
        this.updateName = updateName;
        this.isDelete = isDelete;
        this.token = token;
    }
}