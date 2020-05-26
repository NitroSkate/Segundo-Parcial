package com.parcial.parcial.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {

	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_libro;
	
	@Column(name="s_titulo")
	@Size(max=500, message="No se puede exceder de 500 caracteres")
	@NotEmpty(message="Este campo no debe ir vacio")
	private String s_titulo;
	
	@Column(name="s_autor")
	@Size(max=150, message="No se puede exceder de 150 caracteres")
	@NotEmpty(message="Este campo no debe ir vacio")
	private String s_autor;
	
	@Column(name="s_isbn")
	@Size(max=10, message="No se puede exceder de 10 caracteres")
	@NotEmpty(message="Este campo no debe ir vacio")
	private String s_isbn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	@Column(name = "f_ingreso")
	private Date f_ingreso;
	
	@Column(name = "b_estado")
	private Boolean b_estado;
	
	public Libro() {
		super();
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getF_ingreso() throws ParseException {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
		Date fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(String.valueOf(f_ingreso));
		return dt.format(fecha);
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}
	
	public String getEstadoDelegate() {
		if(this.b_estado == null)return "";
		else {
			return b_estado == true ? "Disponible":"No Disponible";
		}
	} 
	
	
	
	
}
