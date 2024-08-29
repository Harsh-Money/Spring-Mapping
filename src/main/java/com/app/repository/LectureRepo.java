package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.bo.LectureBo;

public interface LectureRepo extends CrudRepository<LectureBo, Integer> {

}
