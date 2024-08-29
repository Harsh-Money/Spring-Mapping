package com.app.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bo.AuthorBo;
import com.app.bo.CourseBo;
import com.app.dto.AuthorDto;
import com.app.dto.CourseDto;
import com.app.dto.SectionDto;
import com.app.repository.CourseRepo;
import com.app.service.CourseService;
import com.app.vo.AuthorVo;
import com.app.vo.CourseVo;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course")
	@ResponseBody
	public List<CourseBo> getDetail(){
		return (List<CourseBo>) courseRepo.findAll();
	}
	
	@PostMapping("/course")
	public ResponseEntity<String> saveDetails(@RequestBody CourseVo courseVo){
		boolean checkInterrupted = false;
		String interruptMessage = "";
		try {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseTitle(courseVo.getCourseTitle());
		courseDto.setCourseDescription(courseVo.getCourseDescription());
		List<SectionDto> sectionDtos = courseVo.getSectionVo()
				.stream()
				.map(value -> {
					SectionDto sectionDto = new SectionDto();
					sectionDto.setSectionName(value.getSectionName());
					sectionDto.setSectionOrder(value.getSectionOrder());
					return sectionDto;
				}).collect(Collectors.toList());
		courseDto.setSectionDto(sectionDtos);
		checkInterrupted = courseService.saveDetails(courseDto);
		} catch (Exception e) {
			checkInterrupted = false;
			interruptMessage = e.getMessage();
		} finally {
			if(checkInterrupted == false) {
				return new ResponseEntity<String>(interruptMessage, HttpStatus.EXPECTATION_FAILED);
			} 
		}
		return new ResponseEntity<String>("Data saved", HttpStatus.OK);
	}
	
	@PutMapping("/course/{id}")
	public ResponseEntity<String> alterDetails(@RequestBody CourseVo courseVo, @PathVariable(name = "id") Integer courseId){
		boolean checkInterrupted = false;
		String interruptMessage = "";
		CourseDto courseDto = new CourseDto();
		if(courseVo.getCourseDescription() != null) {
			courseDto.setCourseDescription(courseVo.getCourseDescription());
		}
		if(courseVo.getCourseTitle() != null) {
			courseDto.setCourseTitle(courseVo.getCourseTitle());
		}
		try {
			checkInterrupted =  courseService.alterDetails(courseId, courseDto);
		} catch (Exception e) {
			checkInterrupted = false;
			interruptMessage = e.getMessage();
		} finally {
			if(checkInterrupted == false) {
				return new ResponseEntity<String>(interruptMessage, HttpStatus.EXPECTATION_FAILED);
			} 
		}
			return new ResponseEntity<String>("Changes Executed...", HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{id}")
	public String deleteById(@PathVariable(name = "id") Integer courseId){
		boolean checkInterrupted = false;
		String interruptMessage = "";
		try {
		if(courseService.deleteById(courseId)) {
			checkInterrupted = true;
		}
		} catch (Exception e) {
			interruptMessage = e.getMessage();
		}
		finally {
			if(!checkInterrupted) {
				return interruptMessage;
			}
		}
			return "Course with given Id deleted...";
		
		
		
	}

}

