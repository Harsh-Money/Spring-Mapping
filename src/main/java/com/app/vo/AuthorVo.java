package com.app.vo;

import java.util.Set;

public class AuthorVo {
	
	private String autorFirstName;
	private String authorSecondName;
	private String authorEmail;
	private Set<CourseVo> courseVo;
	
	
	public Set<CourseVo> getCourseVo() {
		return courseVo;
	}
	public void setCourseVo(Set<CourseVo> courseVo) {
		this.courseVo = courseVo;
	}
	public String getAutorFirstName() {
		return autorFirstName;
	}
	public void setAutorFirstName(String autorFirstName) {
		this.autorFirstName = autorFirstName;
	}
	public String getAuthorSecondName() {
		return authorSecondName;
	}
	public void setAuthorSecondName(String authorSecondName) {
		this.authorSecondName = authorSecondName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

}
