package com.parcial.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.parcial.parcial.dao.CategoriaDAO;
import com.parcial.parcial.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaDAO cDao;
	
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return cDao.findAll();
	}


	@Override
	public void insert(Categoria cat) throws DataAccessException {
		// TODO Auto-generated method stub
		cDao.insert(cat);
	}

}
