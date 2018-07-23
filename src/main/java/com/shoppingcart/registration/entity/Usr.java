package com.shoppingcart.registration.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Usr")
@SequenceGenerator(name = "USER_REC_SEQ", allocationSize = 1, sequenceName = "USER_REC_SEQ")
public class Usr implements Serializable  {

	private static final long serialVersionUID = -5125650764786784257L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_REC_SEQ")
	@Column(name = "USR_IK")
	private long usrIk;
	
	@Column(name= "USR_NM")
	private String userName;
	
	@Column(name="FRST_NM")
	private String firstName;
	
	@Column(name="MDL_NM")
	private String middleName;
	
	@Column(name="LST_NM")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DOB")
	private Date dob;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRTE_TS")
	private Date crteTs;

	@Column(name = "CRTE_USR_NM")
	private String crteUsrNm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LST_UPDT_TS")
	private Date lstUpdtTs;

	@Column(name = "LST_UPDT_USR_NM")
	private String lstUpdtUsrNm;
	
	public Usr() {
		//Default constructor
	}

	public long getUsrIk() {
		return usrIk;
	}
	

	public void setUsrIk(long usrIk) {
		this.usrIk = usrIk;
	}
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getCrteTs() {
		return crteTs;
	}

	public void setCrteTs(Date crteTs) {
		this.crteTs = crteTs;
	}

	public String getCrteUsrNm() {
		return crteUsrNm;
	}

	public void setCrteUsrNm(String crteUsrNm) {
		this.crteUsrNm = crteUsrNm;
	}

	public Date getLstUpdtTs() {
		return lstUpdtTs;
	}

	public void setLstUpdtTs(Date lstUpdtTs) {
		this.lstUpdtTs = lstUpdtTs;
	}

	public String getLstUpdtUsrNm() {
		return lstUpdtUsrNm;
	}

	public void setLstUpdtUsrNm(String lstUpdtUsrNm) {
		this.lstUpdtUsrNm = lstUpdtUsrNm;
	}
}
