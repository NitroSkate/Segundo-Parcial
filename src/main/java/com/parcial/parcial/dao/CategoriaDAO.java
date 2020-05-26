package com.parcial.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.parcial.parcial.domain.Categoria;
import com.parcial.parcial.domain.Libro;

public interface CategoriaDAO {
	
	public List<Categoria>findAll() throws DataAccessException;
	public void insert(Categoria cat) throws DataAccessException;

}
