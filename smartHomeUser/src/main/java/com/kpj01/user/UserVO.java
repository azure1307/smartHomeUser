package com.kpj01.user;

public class UserVO {

	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddSi;
	private String userAddGu;
	private String userAddDong;
	private String userAddDetail;
	private String userBirth;
	private int userAge;
	private String userNick;
	
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddSi() {
		return userAddSi;
	}
	public void setUserAddSi(String userAddSi) {
		this.userAddSi = userAddSi;
	}
	public String getUserAddGu() {
		return userAddGu;
	}
	public void setUserAddGu(String userAddGu) {
		this.userAddGu = userAddGu;
	}
	public String getUserAddDong() {
		return userAddDong;
	}
	public void setUserAddDong(String userAddDong) {
		this.userAddDong = userAddDong;
	}
	public String getUserAddDetail() {
		return userAddDetail;
	}
	public void setUserAddDetail(String userAddDetail) {
		this.userAddDetail = userAddDetail;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	@Override
	public String toString() {
		return "UserVO [userNum=" + userNum + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", userAddSi=" + userAddSi + ", userAddGu=" + userAddGu
				+ ", userAddDong=" + userAddDong + ", userAddDetail=" + userAddDetail + ", userBirth=" + userBirth
				+ ", userAge=" + userAge + ", userNick=" + userNick + "]";
	}
	
	
	
	
	
	
	
}
