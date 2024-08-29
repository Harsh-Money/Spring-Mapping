package com.app.service;

import com.app.dto.AuthorDto;
import com.app.dto.CourseDto;

public interface CourseService {

	public boolean saveDetails(CourseDto courseDto)throws Exception;
	public boolean alterDetails(Integer courseId, CourseDto courseDto)throws Exception;
	public boolean deleteById(Integer courseId)throws Exception;
}
