package com.hibernate.annotation.midtable.mtom.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="table_master")
public class TableMaster{
	public TableMaster() {
		super();
	}
	public TableMaster(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name="m_id")
	private String id;
	
	@Column(name="m_name")
	private String name;
	
	@ManyToMany(targetEntity=TableCat.class,cascade={CascadeType.ALL},mappedBy="master")
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
