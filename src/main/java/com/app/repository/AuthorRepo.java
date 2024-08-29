package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.bo.AuthorBo;

public interface AuthorRepo extends CrudRepository<AuthorBo, Integer> {

}
