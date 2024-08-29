package com.app.bo;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class CourseBo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String courseTitle;
	private String courseDescription;
	
	@ManyToMany(mappedBy ="courseBo",fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE})
	@JsonBackReference
	private Set<AuthorBo> authorBo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "courseBo")
	private List<SectionBo> sectionBo;
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<AuthorBo> getAuthorBo() {
		return authorBo;
	}
	public void setAuthorBo(Set<AuthorBo> authorBo) {
		this.authorBo = authorBo;
	}
	public List<SectionBo> getSectionBo() {
		return sectionBo;
	}
	public void setSectionBo(List<SectionBo> sectionBo) {
		this.sectionBo = sectionBo;
	}
	
	
	
	
	

}
