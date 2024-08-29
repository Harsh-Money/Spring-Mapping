package com.app.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.app.repository.AuthorRepo;
import com.app.service.AuthorService;
import com.app.vo.AuthorVo;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/author")
	@ResponseBody
	public List<AuthorBo> getAuthorDetail(){
		return (List<AuthorBo>) authorRepo.findAll();
	}
	
	@PostMapping("/author")
	public ResponseEntity<String> saveAuthorDetails(@RequestBody AuthorVo authorVo){
		boolean checkInterrupted = false;
		String interruptMessage = "";
		try {
		AuthorBo authorBo = new AuthorBo();
		authorBo.setAutorFirstName(authorVo.getAutorFirstName());
		authorBo.setAuthorSecondName(authorVo.getAuthorSecondName());
		authorBo.setAuthorEmail(authorVo.getAuthorEmail());
		Set<CourseBo> courseSetBo = authorVo
										.getCourseVo()
										.stream()
										.map(value -> {
											CourseBo courseBo = new CourseBo();
											courseBo.setCourseTitle(value.getCourseTitle());
											courseBo.setCourseDescription(value.getCourseDescription());
											return courseBo;
										}).collect(Collectors.toSet());
		
		authorBo.setCourseBo(courseSetBo);
		AuthorBo authorBo2 = authorRepo.save(authorBo);
		if(authorBo2 != null) {
			checkInterrupted = true;
		}
//		checkInterrupted = authorService.saveAuthorDetails(authorDto);
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
	
	@PutMapping("/author/{id}")
	public ResponseEntity<String> alterAutherDetails(@RequestBody AuthorVo authorVo, @PathVariable(name = "id") Integer autherId){
		boolean checkInterrupted = false;
		String interruptMessage = "";
		AuthorDto authorDto = new AuthorDto();
		if(authorVo.getAutorFirstName() != null)
		authorDto.setAutorFirstName(authorVo.getAutorFirstName());
		if(authorVo.getAuthorSecondName() != null)
		authorDto.setAuthorSecondName(authorVo.getAuthorSecondName());
		if(authorVo.getAuthorEmail() != null)
		authorDto.setAuthorEmail(authorVo.getAuthorEmail());
		try {
			checkInterrupted =  authorService.alterAuthorDetails(autherId, authorDto);
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
	
	@DeleteMapping("/author/{id}")
	public String deleteById(@PathVariable(name = "id") Integer authorId){
		boolean checkInterrupted = false;
		String interruptMessage = "";
		try {
		if(authorService.deleteAuthorById(authorId)) {
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
			return "Author with given Id deleted...";
		
		
		
	}

}
