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
import jakarta.persistence.OneToOne;

@Entity
public class LectureBo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String lectureName;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private SectionBo sectionBo;
	
	@OneToOne
	@JoinColumn(name = "resourse_id")
	private ResourseBo resourseBo;
	

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	
}
