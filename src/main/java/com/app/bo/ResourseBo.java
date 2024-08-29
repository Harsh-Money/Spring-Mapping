package com.app.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ResourseBo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String resourseName;
	private Double resourseSize;
	private String resourseUrl;
	@OneToOne
	@JoinColumn(name = "lecture_id")
	private LectureBo lectureBo;
	
	public String getResourseName() {
		return resourseName;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public Double getResourseSize() {
		return resourseSize;
	}
	public void setResourseSize(Double resourseSize) {
		this.resourseSize = resourseSize;
	}
	public String getResourseUrl() {
		return resourseUrl;
	}
	public void setResourseUrl(String resourseUrl) {
		this.resourseUrl = resourseUrl;
	}

}
