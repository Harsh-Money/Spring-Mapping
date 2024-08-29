package com.app.vo;

import java.util.List;
import java.util.Set;

public class CourseVo {
	
	private String courseTitle;
	private String courseDescription;
	private Set<AuthorVo> authorVo;
	private List<SectionVo> sectionVo;
	
	
	public Set<AuthorVo> getAuthorVo() {
		return authorVo;
	}
	public void setAuthorVo(Set<AuthorVo> authorVo) {
		this.authorVo = authorVo;
	}
	public List<SectionVo> getSectionVo() {
		return sectionVo;
	}
	public void setSectionVo(List<SectionVo> sectionVo) {
		this.sectionVo = sectionVo;
	}
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
	
	
	
	
	

}
