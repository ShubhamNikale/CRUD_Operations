package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Integer sId;
	@Column(name = "s_name")
	private String sName;
	@Column(name = "s_dept")
	private String sDept;
	@Column(name = "s_marks")
	private String smarks;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsDept() {
		return sDept;
	}

	public void setsDept(String sDept) {
		this.sDept = sDept;
	}

	public String getsmarks() {
		return smarks;
	}

	public void setsmarks(String smarks) {
		this.smarks = smarks;
	}

	
}
