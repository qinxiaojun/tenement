package com.moto.tenement.member.model;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Enrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "enrol", catalog = "tenement")

public class Enrol implements java.io.Serializable {

	// Fields

	private String id;
	private String schoolid;
	private String major;
	private String enrolYear;
	private String educateSchoolId;

	// Constructors

	/** default constructor */
	public Enrol() {
	}

	/** minimal constructor */
	public Enrol(String id) {
		this.id = id;
	}

	/** full constructor */
	public Enrol(String id, String schoolid, String major, String enrolYear, String educateSchoolId) {
		this.id = id;
		this.schoolid = schoolid;
		this.major = major;
		this.enrolYear = enrolYear;
		this.educateSchoolId = educateSchoolId;
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

	@Column(name = "enrol_year", length = 50)

	public String getEnrolYear() {
		return this.enrolYear;
	}

	public void setEnrolYear(String enrolYear) {
		this.enrolYear = enrolYear;
	}

	@Column(name = "educate_school_id")

	public String getEducateSchoolId() {
		return this.educateSchoolId;
	}

	public void setEducateSchoolId(String educateSchoolId) {
		this.educateSchoolId = educateSchoolId;
	}

}