package com.app.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bo.AuthorBo;
import com.app.bo.CourseBo;
import com.app.bo.SectionBo;
import com.app.dto.CourseDto;
import com.app.dto.SectionDto;
import com.app.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public boolean saveDetails(CourseDto courseDto) throws Exception {
		CourseBo courseBo = new CourseBo();
		courseBo.setCourseDescription(courseDto.getCourseDescription());
		courseBo.setCourseTitle(courseDto.getCourseTitle());
		List<SectionBo> sectionBos = courseDto.getSectionDto()
				.stream()
				.map(value -> {
					SectionBo sectionBo = new SectionBo();
					sectionBo.setSectionName(value.getSectionName());
					sectionBo.setSectionOrder(value.getSectionOrder());
					return sectionBo;
				}).collect(Collectors.toList());
		courseBo.setSectionBo(sectionBos);
		courseRepo.save(courseBo);
		Thread.sleep(1000);
		if(courseRepo.findById(courseBo.getId()) != null)
			return true;
		return false;
	}

	@Override
	public boolean alterDetails(Integer courseId, CourseDto courseDto) throws Exception {
		courseRepo.findById(courseId)
		.orElseThrow(() -> new RuntimeException("Auther with this id donot exist."));
		CourseBo courseBo = courseRepo.findById(courseId).get();
		courseBo.setCourseDescription(courseDto.getCourseDescription());
		courseBo.setCourseTitle(courseDto.getCourseTitle());
		Thread.sleep(1000);
		if(courseRepo.findById(courseBo.getId()) != null)
			return true;
		return false;
	}

	@Override
	public boolean deleteById(Integer courseId) throws Exception {
		if(courseRepo.existsById(courseId)) {
			CourseBo courseBo = courseRepo.findById(courseId)
					.orElseThrow(() -> new Exception("Course Not Found"));
			
//			Break the relationship between Author and Course
			courseBo
			.getAuthorBo()
			.stream()
			.forEach(value ->{
				value.getCourseBo().remove(courseBo);
			});
			courseBo.getAuthorBo().clear();
			
//			Delete the Course
			courseRepo.deleteById(courseId);
			Thread.sleep(1000);
			return !courseRepo.existsById(courseId);
		}
		return false;
	}

}
