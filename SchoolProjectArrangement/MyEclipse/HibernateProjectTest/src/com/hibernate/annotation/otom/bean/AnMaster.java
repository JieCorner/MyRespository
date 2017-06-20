package com.hibernate.annotation.otom.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="master")
public class AnMaster{
	public AnMaster() {
		super();
	}
	public AnMaster(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name="m_id",nullable = false,unique = true)
	private String id;
	
	@Column(name="m_name")
	private String name;
	
	@OneToMany(targetEntity=AnCat.class,cascade={CascadeType.ALL},mappedBy="master")
	private Set Cats;
	
	public Set getCats() {
		return Cats;
	}
	public void setCats(Set cats) {
		Cats = cats;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
