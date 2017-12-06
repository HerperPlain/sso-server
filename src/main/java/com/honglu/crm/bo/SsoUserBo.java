package com.honglu.crm.bo;

import com.honglu.crm.common.baseEntityBo.BaseBo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 后台用户表实体类
 * @author xiajiyun
 *
 */
@Entity
@Table(name = "sc_user")
public class SsoUserBo extends BaseBo implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "state")
    private Integer state;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "create_man")
    private String createMan;

    @Column(name = "modify_time")
    private String modifyTime;

    @Column(name = "modify_man")
    private String modifyMan;

    @Column(name = "remark")
    private String remark;

    /**
     * 用户头像
     */
    @Column(name = "user_pic")
    private String userPic;
    /**
     * ip地址
     */
    @Column(name = "ip")
    private String ip;
    /**
     * 最后登录时间
      */
    @Column(name = "last_login_time")
    private String lastLoginTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyMan() {
        return modifyMan;
    }

    public void setModifyMan(String modifyMan) {
        this.modifyMan = modifyMan;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.substring(0, 19);
    }

    public SsoUserBo(Integer id, String userName, String nickName, String password, String mobile, Integer state, String createTime, String createMan, String modifyTime, String modifyMan, String remark, String userPic, String ip, String lastLoginTime) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.mobile = mobile;
        this.state = state;
        this.createTime = createTime;
        this.createMan = createMan;
        this.modifyTime = modifyTime;
        this.modifyMan = modifyMan;
        this.remark = remark;
        this.userPic = userPic;
        this.ip = ip;
        this.lastLoginTime = lastLoginTime;
    }

    public SsoUserBo() {
    }

    @Override
    public String toString() {
        return "SsoUserBo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", state=" + state +
                ", createTime='" + createTime + '\'' +
                ", createMan='" + createMan + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", modifyMan='" + modifyMan + '\'' +
                ", remark='" + remark + '\'' +
                ", userPic='" + userPic + '\'' +
                ", ip='" + ip + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }
}