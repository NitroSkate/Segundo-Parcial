package com.parcial.parcial.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.parcial.parcial.service.CategoriaService;
import com.parcial.parcial.service.LibroService;
import com.parcial.parcial.domain.Categoria;
import com.parcial.parcial.domain.Libro;

@Controller 
public class MainController {
	
	@Autowired
	private LibroService lService;
	
	@Autowired
	private CategoriaService cService;
	
	@RequestMapping("/index")
	public ModelAndView Inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "");
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping("/icategoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Categoria());
		mav.setViewName("categoria");
		return mav;
	}
	
	@RequestMapping("/ilibro")
	public ModelAndView libro() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> cat = null;
		try {
			cat = cService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "No hay categorias");
		}

		mav.addObject("libro", new Libro());
		mav.addObject("categoria", cat);
		mav.setViewName("libro");
		return mav;
	}
	
	@RequestMapping("/elibro")
	public ModelAndView elib(@Valid @ModelAttribute Libro lib, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> cat = null;
			try {
				cat = cService.findAll();
			} catch(Exception e) {
				e.printStackTrace();
				mav.addObject("msg", "No hay categorias");
			}

			//mav.addObject("libro", new Libro());
			mav.addObject("categoria", cat);
			mav.addObject("libro", lib);
			mav.setViewName("libro");
		} else {
			long millis = System.currentTimeMillis();
			java.sql.Date dat = new java.sql.Date(millis);
			String fecha = dat.toString();
			Date date = new Date();
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha);
			} catch(ParseException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(date);
				lib.setF_ingreso(date);;
				if(lib.getB_estado()==null) {
					lib.setB_estado(false);
				}
				lService.insert(lib);
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("msg", "Libro guardado con exito!");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/ecategoria")
	public ModelAndView ecat(@Valid @ModelAttribute Categoria cat, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("categoria", cat);
			mav.setViewName("categoria");
		}else {
			try {
			cService.insert(cat);
			} catch (Exception e){
				e.printStackTrace();
			}
			mav.addObject("msg", "Categoria guardada con exito!");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> lib = null;
		try {
			//cService.insert(con);
			lib = lService.findAll();
			//System.out.print(contribuyentes.get(6).getImportancia().getS_importancia());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("listado", lib);
		mav.setViewName("listado");
		return mav;
	}
	

}
