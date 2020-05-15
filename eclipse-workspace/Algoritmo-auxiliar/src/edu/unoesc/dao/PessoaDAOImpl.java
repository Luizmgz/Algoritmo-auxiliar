package edu.unoesc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unoesc.model.Pessoa;

@Repository
public class PessoaDAOImpl implements PessoaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Pessoa getPessoaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pessoa p = (Pessoa) session.get(Pessoa.class, new Integer(id));
		
		//System.out.println("nome: " + p.getNome());
		
		return p;
	}

	@Override
	@Transactional
	public List<Pessoa> getPessoas() {
		
		return this.sessionFactory.getCurrentSession().createQuery("from Pessoa").list();
	}

	@Override
	@Transactional
	public boolean deletePessoa(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pessoa p = (Pessoa) session.load(Pessoa.class, new Integer(id));
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertPessoa(Pessoa p) {
		
		this.sessionFactory.getCurrentSession().save(p);
		
		return false;
	}

	@Override
	@Transactional
	public boolean updatePessoa(Pessoa p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}
