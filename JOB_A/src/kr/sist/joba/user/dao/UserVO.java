package kr.sist.joba.user.dao;

import data.DTO;

public class UserVO extends DTO {
	/**회원 ID*/
	private String userId;
	/**회원 PW*/
	private String userPw;
	/**회원 이름*/
	private String userName;
	/**회원 권한*/
	private String userAuthority;
	/**조 번호*/
	private String teamNum;
	/**회원 이메일*/
	private String userEmail;
	/**회원 휴대폰 번호*/
	private String userCellPhone;
	/**회원 주소(시/도/구)*/
	private String userArea;
	/**회원 상세주소*/
	private String userAddress;
	/**회원 마일리지*/
	private String userPoint;
	/**회원 등록일*/
	private String userRegistration;
	/**회원 등록자 ID*/
	private String userRegistId;
	
	public UserVO() {
	}

	/**
	 * @param userId
	 * @param userPw
	 * @param userName
	 * @param userAuthority
	 * @param teamNum
	 * @param userEmail
	 * @param userCellPhone
	 * @param userAddress
	 * @param userDetailAddress
	 * @param userPoint
	 * @param userRegistration
	 * @param userRegistId
	 */
	public UserVO(String userId, String userPw, String userName, String userAuthority, String teamNum, String userEmail,
			String userCellPhone, String userArea, String userAddress, String userPoint,
			String userRegistration, String userRegistId) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAuthority = userAuthority;
		this.teamNum = teamNum;
		this.userEmail = userEmail;
		this.userCellPhone = userCellPhone;
		this.userArea = userArea;
		this.userAddress = userAddress;
		this.userPoint = userPoint;
		this.userRegistration = userRegistration;
		this.userRegistId = userRegistId;
	}
	
	//ID 중복 확인용
	public UserVO(String userId) {
		super();
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userPw
	 */
	public String getUserPw() {
		return userPw;
	}

	/**
	 * @param userPw the userPw to set
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userAuthority
	 */
	public String getUserAuthority() {
		return userAuthority;
	}

	/**
	 * @param userAuthority the userAuthority to set
	 */
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	/**
	 * @return the teamNum
	 */
	public String getTeamNum() {
		return teamNum;
	}

	/**
	 * @param teamNum the teamNum to set
	 */
	public void setTeamNum(String teamNum) {
		this.teamNum = teamNum;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userCellPhone
	 */
	public String getUserCellPhone() {
		return userCellPhone;
	}

	/**
	 * @param userCellPhone the userCellPhone to set
	 */
	public void setUserCellPhone(String userCellPhone) {
		this.userCellPhone = userCellPhone;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserArea() {
		return userArea;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	/**
	 * @return the userDetailAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userDetailAddress the userDetailAddress to set
	 */
	public void setUserDetailAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the userPoint
	 */
	public String getUserPoint() {
		return userPoint;
	}

	/**
	 * @param userPoint the userPoint to set
	 */
	public void setUserPoint(String userPoint) {
		this.userPoint = userPoint;
	}

	/**
	 * @return the userRegistration
	 */
	public String getUserRegistration() {
		return userRegistration;
	}

	/**
	 * @param userRegistration the userRegistration to set
	 */
	public void setUserRegistration(String userRegistration) {
		this.userRegistration = userRegistration;
	}

	/**
	 * @return the userRegistId
	 */
	public String getUserRegistId() {
		return userRegistId;
	}

	/**
	 * @param userRegistId the userRegistId to set
	 */
	public void setUserRegistId(String userRegistId) {
		this.userRegistId = userRegistId;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userAuthority="
				+ userAuthority + ", teamNum=" + teamNum + ", userEmail=" + userEmail + ", userCellPhone="
				+ userCellPhone + ", userArea=" + userArea + ", userAddress=" + userAddress
				+ ", userPoint=" + userPoint + ", userRegistration=" + userRegistration + ", userRegistId="
				+ userRegistId + ", toString()=" + super.toString() + "]";
	}
	
}
	