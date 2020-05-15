package edu.unoesc.dao;

import java.util.List;

import edu.unoesc.model.Pessoa;

public interface PessoaDAO {

	Pessoa getPessoaById (int id);
	List<Pessoa> getPessoas();
	boolean deletePessoa(int id);
	boolean insertPessoa(Pessoa p);
	boolean updatePessoa(Pessoa p);
	
}
