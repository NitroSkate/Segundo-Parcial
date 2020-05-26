package com.parcial.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.parcial.parcial.domain.Categoria;

public interface CategoriaService {

	public List<Categoria>findAll() throws DataAccessException;
	public void insert(Categoria cat) throws DataAccessException;
	
}
