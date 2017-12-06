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
    private Integer Id;

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

//    private String[] ids;// 多选框用

    @Column(name = "user_pic")
    private String userPic;// 用户头像
    @Column(name = "ip")
    private String ip;// ip地址
    @Column(name = "last_login_time")
    private String lastLoginTime;// 最后登录时间


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


    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

//	public String[] getIds() {
//		return ids;
//	}
//
//	public void setIds(String[] ids) {
//		this.ids = ids;
//	}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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
        this.createTime = createTime  == null ? null : createTime.substring(0, 19);// 固定格式yyyy-MM-dd HH:mm:ss
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan == null ? null : createMan.trim();
    }



    public String getModifyMan() {
        return modifyMan;
    }

    public void setModifyMan(String modifyMan) {
        this.modifyMan = modifyMan == null ? null : modifyMan.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}