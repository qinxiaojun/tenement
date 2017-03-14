package com.moto.tenement.dictionary.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DictionaryType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dictionary_type", catalog = "tenement")
public class DictionaryType implements java.io.Serializable {

	// Fields

	private String id;
	private Integer status;
	private String text;
	private String code;
	private Timestamp createdate;
	private String creator;
	private String creatorid;

	// Constructors

	/** default constructor */
	public DictionaryType() {
	}

	/** minimal constructor */
	public DictionaryType(String id) {
		this.id = id;
	}

	/** full constructor */
	public DictionaryType(String id, Integer status, String text, String code
			, Timestamp createdate, String creator,
			String creatorid) {
		
		this.id = id;
		this.status = status;
		this.text = text;
		this.code = code;
		this.createdate = createdate;
		this.creator = creator;
		this.creatorid = creatorid;
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

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "createdate", length = 19)
	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Column(name = "creator")
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "creatorid")
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
}