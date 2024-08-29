package com.app.dto;

import java.util.Set;

public class AuthorDto {
	
	private String autorFirstName;
	private String authorSecondName;
	private String authorEmail;
	private Set<CourseDto> courseDto;
	
	public Set<CourseDto> getCourseDto() {
		return courseDto;
	}
	public void setCourseDto(Set<CourseDto> courseDto) {
		this.courseDto = courseDto;
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
	@Override
	public String toString() {
		return "AuthorDto [courseDto=" + courseDto + "]";
	}

}
