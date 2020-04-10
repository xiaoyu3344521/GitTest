package com.ysd.entity;

import java.io.Serializable;

public class User implements Serializable{
private String id;
private String LoginName;
private String Password;
private String isLockout;
private String LastLoginTime;
private int PsdWrongTime;
private String LockTime;
private String ProtectEMail;
private String ProtectMTel;
private String CreateTime;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLoginName() {
	return LoginName;
}
public void setLoginName(String loginName) {
	LoginName = loginName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getIsLockout() {
	return isLockout;
}
public void setIsLockout(String isLockout) {
	this.isLockout = isLockout;
}
public String getLastLoginTime() {
	return LastLoginTime;
}
public void setLastLoginTime(String lastLoginTime) {
	LastLoginTime = lastLoginTime;
}
public int getPsdWrongTime() {
	return PsdWrongTime;
}
public void setPsdWrongTime(int psdWrongTime) {
	PsdWrongTime = psdWrongTime;
}
public String getLockTime() {
	return LockTime;
}
public void setLockTime(String lockTime) {
	LockTime = lockTime;
}
public String getProtectEMail() {
	return ProtectEMail;
}
public void setProtectEMail(String protectEMail) {
	ProtectEMail = protectEMail;
}
public String getProtectMTel() {
	return ProtectMTel;
}
public void setProtectMTel(String protectMTel) {
	ProtectMTel = protectMTel;
}
public String getCreateTime() {
	return CreateTime;
}
public void setCreateTime(String createTime) {
	CreateTime = createTime;
}
@Override
public String toString() {
	return "User [id=" + id + ", LoginName=" + LoginName + ", Password=" + Password + ", isLockout=" + isLockout
			+ ", LastLoginTime=" + LastLoginTime + ", PsdWrongTime=" + PsdWrongTime + ", LockTime=" + LockTime
			+ ", ProtectEMail=" + ProtectEMail + ", ProtectMTel=" + ProtectMTel + ", CreateTime=" + CreateTime + "]";
}
}
