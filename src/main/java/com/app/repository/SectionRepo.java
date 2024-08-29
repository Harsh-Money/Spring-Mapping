package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.bo.SectionBo;

public interface SectionRepo extends CrudRepository<SectionBo, Integer> {

}
