package br.com.alura.livraria.modelo;

import java.time.LocalDate;

public class Autor {
	
	public String nome;
	public String email;
	public LocalDate data;
	public String curriculo;
	
	public Autor() {}
	
	public Autor(String nome, String email, LocalDate data, String curriculo) {
		this.nome = nome;
		this.email = email;
		this.data = data;
		this.curriculo = curriculo;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getCurriculo() {
		return curriculo;
	}
	
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

}
