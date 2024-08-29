package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bo.SectionBo;
import com.app.repository.SectionRepo;
import com.app.vo.SectionVo;

//@RestController
//public class SectionController {
//	
//	@Autowired
//	private SectionRepo sectionRepo;
	
//	@RequestMapping("/section")
//	public List<SectionBo> getSection(){
//		return (List<SectionBo>) sectionRepo.findAll();
//	}
//	
//	@RequestMapping("/section")
//	public ResponseEntity<String> saveDetails(@RequestBody SectionVo vo){
//		return null;
//		
//	}
	

//}
