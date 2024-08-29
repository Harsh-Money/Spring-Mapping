package com.app.bo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SectionBo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String sectionName;
	private String sectionOrder;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseBo courseBo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sectionBo")
	private List<LectureBo> lectureBo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<LectureBo> getLectureBo() {
		return lectureBo;
	}
	public void setLectureBo(List<LectureBo> lectureBo) {
		this.lectureBo = lectureBo;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSectionOrder() {
		return sectionOrder;
	}
	public void setSectionOrder(String sectionOrder) {
		this.sectionOrder = sectionOrder;
	}
	
	

}
