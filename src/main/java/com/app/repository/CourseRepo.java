package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.bo.CourseBo;

public interface CourseRepo extends CrudRepository<CourseBo, Integer> {

}
