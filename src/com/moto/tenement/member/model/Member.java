package com.moto.tenement.member.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member", catalog = "tenement")

public class Member implements java.io.Serializable {

	// Fields

	private String id;
	private String name; //����
	private int sex; //�Ա�
	private String py; //ƴ��
	private String phone;	//�ֻ�����
	private String birth;	//����
	private String hkPhone;	//����ֻ�
	private String email;	//����
	private String channelid;	//��Դ����id
	private String school;	//����ԺУ
	private String major;	//����רҵ
	private String creatorid;	//������id
	private String createdate;	//����ʱ��
	
	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String id) {
		this.id = id;
	}

	/** full constructor */
	public Member(String id, String name, int sex, String py, String phone, String birth, String hkPhone,
			String email, String channelid, String school, String major, String creatorid, String createdate) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.py = py;
		this.phone = phone;
		this.birth = birth;
		this.hkPhone = hkPhone;
		this.email = email;
		this.channelid = channelid;
		this.school = school;
		this.major = major;
		this.creatorid = creatorid;
		this.createdate = createdate;
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

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex")

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Column(name = "py")

	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	@Column(name = "phone")

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "birth")

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Column(name = "hk_phone")

	public String getHkPhone() {
		return this.hkPhone;
	}

	public void setHkPhone(String hkPhone) {
		this.hkPhone = hkPhone;
	}

	@Column(name = "email")

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "channelid")

	public String getChannelid() {
		return this.channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	@Column(name = "school")

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "major")

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "creatorid")

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	@Column(name = "createdate")

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}