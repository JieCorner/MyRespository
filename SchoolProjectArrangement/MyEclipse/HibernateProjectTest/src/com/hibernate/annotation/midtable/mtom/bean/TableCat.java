package com.hibernate.annotation.midtable.mtom.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="table_cat")
public class TableCat {
	
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name="c_id")
	private String id;
	
	@Column(name="c_name")
	private String name;
	
	@ManyToMany(targetEntity=TableMaster.class,cascade={CascadeType.ALL})
	private Set master;
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
	public Set getMaster() {
		return master;
	}
	public void setMaster(Set master) {
		this.master = master;
	}
	public TableCat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TableCat(String id, String name, Set master) {
		super();
		this.id = id;
		this.name = name;
		this.master = master;
	}
	
}
