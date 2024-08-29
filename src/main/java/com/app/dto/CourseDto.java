package com.app.dto;

import java.util.List;
import java.util.Set;

public class CourseDto {
	
	private String courseTitle;
	private String courseDescription;
	private AuthorDto authorDto;
	private List<SectionDto> sectionDto;
	
	
	public AuthorDto getAuthorDto() {
		return authorDto;
	}
	public void setAuthorDto(AuthorDto authorDto) {
		this.authorDto = authorDto;
	}
	public List<SectionDto> getSectionDto() {
		return sectionDto;
	}
	public void setSectionDto(List<SectionDto> sectionDto) {
		this.sectionDto = sectionDto;
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
