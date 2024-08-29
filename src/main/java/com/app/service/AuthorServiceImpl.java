package com.app.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bo.AuthorBo;
import com.app.bo.CourseBo;
import com.app.dto.AuthorDto;
import com.app.repository.AuthorRepo;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepo;
	
	@Override
	public boolean saveAuthorDetails(AuthorDto authorDto) throws Exception {
		AuthorBo authorBo = new AuthorBo();
		authorBo.setAutorFirstName(authorDto.getAutorFirstName());
		authorBo.setAuthorSecondName(authorDto.getAuthorSecondName());
		authorBo.setAuthorEmail(authorDto.getAuthorEmail());
		Set<CourseBo> courseSetBo = authorDto
										.getCourseDto()
										.stream()
										.map(authorDtos -> {
											CourseBo courseBo = new CourseBo();
											courseBo.setCourseTitle(authorDtos.getCourseTitle());
											courseBo.setCourseDescription(authorDtos.getCourseDescription());
											return courseBo;
										}).collect(Collectors.toSet());
		authorBo.setCourseBo(courseSetBo);
		authorBo
		.getCourseBo()
		.stream()
		.forEach(value -> {
			value.getAuthorBo().remove(courseSetBo);
		});
//		courseSetBo.forEach(course -> course.getAuthorBo().add(authorBo));
		authorRepo.save(authorBo);
		Thread.sleep(1000);
		if(authorRepo.findById(authorBo.getId()) != null)
			return true;
		return false;
	}

	@Override
	public boolean alterAuthorDetails(Integer autherId, AuthorDto authorDto) throws Exception {
		authorRepo.findById(autherId)
				.orElseThrow(() -> new RuntimeException("Auther with this id donot exist."));
		AuthorBo authorBo = authorRepo.findById(autherId).get();
		authorBo.setAutorFirstName(authorDto.getAutorFirstName());
		authorBo.setAuthorSecondName(authorDto.getAuthorSecondName());
		authorBo.setAuthorEmail(authorDto.getAuthorEmail());
		Thread.sleep(1000);
		if(authorRepo.findById(authorBo.getId()) != null)
			return true;
		return false;
	}

	@Override
	public boolean deleteAuthorById(Integer authorId) throws Exception {
		if(authorRepo.existsById(authorId)) {
			AuthorBo authorBo = authorRepo.findById(authorId)
					.orElseThrow();
			
//			Break the relationship between Author and Course
			authorBo
			.getCourseBo()
			.stream()
			.forEach(value -> {
				value.getAuthorBo().remove(authorBo);
			});
			authorBo.getCourseBo().clear();
			
//			Delete the Author
			authorRepo.deleteById(authorId);
			Thread.sleep(1000);
			return !authorRepo.existsById(authorId);
		}
		return false;
	}

}
