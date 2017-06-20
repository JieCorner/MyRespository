package com.hibernate.annotation.otom.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cat")
public class AnCat {
	
	public AnCat(String id, String name, AnMaster master) {
		super();
		this.id = id;
		this.name = name;
		this.master = master;
	}
	public AnCat() {
		super();
	}
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name="c_id",nullable = false,unique = true)
	private String id;
	@Column(name="c_name")
	private String name;
	@ManyToOne()
	@JoinColumn(name="m_id")         //定义外键关联
	private AnMaster master;
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
	public AnMaster getMaster() {
		return master;
	}
	public void setMaster(AnMaster master) {
		this.master = master;
	}
}
