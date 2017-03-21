package com.moto.tenement.member.model;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Offer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "offer", catalog = "tenement")

public class Offer implements java.io.Serializable {

	// Fields

	private String id;
	private String schoolid;
	private String major;
	private String enrolid;

	// Constructors

	/** default constructor */
	public Offer() {
	}

	/** minimal constructor */
	public Offer(String id) {
		this.id = id;
	}

	/** full constructor */
	public Offer(String id, String schoolid, String major, String enrolid) {
		this.id = id;
		this.schoolid = schoolid;
		this.major = major;
		this.enrolid = enrolid;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "schoolid")

	public String getSchoolid() {
		return this.schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	@Column(name = "major")

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "enrolid")

	public String getEnrolid() {
		return this.enrolid;
	}

	public void setEnrolid(String enrolid) {
		this.enrolid = enrolid;
	}

}