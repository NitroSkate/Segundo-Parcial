package com.parcial.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.parcial.parcial.domain.Libro;

public interface LibroDAO {

	public List<Libro>findAll() throws DataAccessException;
	public void insert(Libro libro) throws DataAccessException;
	
}
