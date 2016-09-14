package com.tcz.api.model.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

public class Member implements Serializable{
    private Long id;

    private Date createDate;

    private Date modifyDate;

    private String address;

    private BigDecimal amount;

    private BigDecimal balance;

    private BigDecimal commission;

    private Date birth;

    private String email;

    private Integer gender;

    private Integer isEnabled;

    private Integer isLocked;

    private Date lockedDate;

    private Date loginDate;

    private Integer loginFailureCount;

    private String loginIp;

    private String mobilePhone;

    private String name;

    private String userPhoto;

    private String password;

    private String fixedPhone;

    private Long point;

    private String registerIp;

    private Long areaId;

    private Long memberRankId;

    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone == null ? null : fixedPhone.trim();
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp == null ? null : registerIp.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getMemberRankId() {
        return memberRankId;
    }

    public void setMemberRankId(Long memberRankId) {
        this.memberRankId = memberRankId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Member(){
    	super();
    }
	public Member(Long id, Date createDate, Date modifyDate, String address,
			BigDecimal amount, BigDecimal balance, BigDecimal commission,
			Date birth, String email, Integer gender, Integer isEnabled,
			Integer isLocked, Date lockedDate, Date loginDate,
			Integer loginFailureCount, String loginIp, String mobilePhone,
			String name, String userPhoto, String password, String fixedPhone,
			Long point, String registerIp, Long areaId, Long memberRankId,
			Integer isDeleted) {
		this.id = id;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.address = address;
		this.amount = amount;
		this.balance = balance;
		this.commission = commission;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.isEnabled = isEnabled;
		this.isLocked = isLocked;
		this.lockedDate = lockedDate;
		this.loginDate = loginDate;
		this.loginFailureCount = loginFailureCount;
		this.loginIp = loginIp;
		this.mobilePhone = mobilePhone;
		this.name = name;
		this.userPhoto = userPhoto;
		this.password = password;
		this.fixedPhone = fixedPhone;
		this.point = point;
		this.registerIp = registerIp;
		this.areaId = areaId;
		this.memberRankId = memberRankId;
		this.isDeleted = isDeleted;
	}
    
    
}