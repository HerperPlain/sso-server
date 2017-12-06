package com.honglu.crm.config.shiro;


import org.apache.shiro.authc.UsernamePasswordToken;
/**
 * 
 * @author xiajiyun
 * 
 */
public class ShiroToken extends UsernamePasswordToken  implements java.io.Serializable{
	
	private static final long serialVersionUID = -6451794657814516274L;

	public ShiroToken(String username, String pswd) {
		super(username,pswd);
		this.pswd = pswd ;
	}

	public ShiroToken(String username, String pswd, String host) {
		super(username, pswd, host);
		this.username = username;
		this.pswd = pswd;
		this.host = host;
	}

	private String username;
	/** 登录密码[字符串类型] 因为父类是char[] ] **/
	private String pswd ;

	private String host ;


	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	public String getPswd() {
		return pswd;
	}


	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	@Override
	public String toString() {
		return "ShiroToken{" +
				"username='" +getUsername() + '\'' +
				",pswd='" + getPswd() + '\'' +
				",host='" + host + '\'' +
				'}';
	}
}
