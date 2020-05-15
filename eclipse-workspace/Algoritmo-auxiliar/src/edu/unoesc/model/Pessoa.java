package edu.unoesc.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "idade")
	private int idade;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dataNasc")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNasc;
	
	@OneToMany
	private List<Microondas> microondas;
	
	@ManyToMany(mappedBy = "pessoas")
	private Set<Carro> carros;

	public Pessoa() {
		
	}
		
	public Pessoa(int id, String nome, int idade, String email, Date dataNasc) {
		
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.dataNasc = dataNasc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getDataNasFormated() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.dataNasc == null)
			return format.format(new Date());
		
		return format.format(this.dataNasc);
	}
	
	public String getDataNasDateInput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (this.dataNasc == null)
			return format.format(new Date());
		
		return format.format(this.dataNasc);
	}

	public List<Microondas> getMicroondas() {
		return microondas;
	}

	public void setMicroondas(List<Microondas> microondas) {
		this.microondas = microondas;
	}

	public Set<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
