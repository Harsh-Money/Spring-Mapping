package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.bo.ResourseBo;

public interface ResourseRepo extends CrudRepository<ResourseBo, Integer> {

}
