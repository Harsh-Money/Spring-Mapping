package com.app.service;

import com.app.dto.AuthorDto;

public interface AuthorService {
	
	public boolean saveAuthorDetails(AuthorDto authorDto)throws Exception;
	public boolean alterAuthorDetails(Integer autherId, AuthorDto authorDto)throws Exception;
	public boolean deleteAuthorById(Integer authorId)throws Exception;

}
