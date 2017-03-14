package com.moto.tenement.dictionary.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DictionaryItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dictionary_item", catalog = "tenement")
public class DictionaryItem implements java.io.Serializable {

	// Fields

	private String id;
	private Integer sort;
	private String text;
	private Integer value;
	private String typeId;
	// Constructors

	/** default constructor */
	public DictionaryItem() {
	}

	/** minimal constructor */
	public DictionaryItem(String id) {
		this.id = id;
	}

	/** full constructor */
	public DictionaryItem(String id, Integer sort, String text, Integer value,
			String typeId) {
		this.id = id;
		this.sort = sort;
		this.text = text;
		this.value = value;
		this.typeId = typeId;
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

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "value")
	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name = "type_id")
	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	

}