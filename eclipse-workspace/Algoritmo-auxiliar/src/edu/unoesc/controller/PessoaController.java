package edu.unoesc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Pessoa;

@Controller
public class PessoaController {

	@Autowired
	private PessoaDAO pessoaDao;

	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public String pessoasList(Model m) {

		ArrayList<Pessoa> pessoas = new ArrayList(pessoaDao.getPessoas());

		m.addAttribute("listPessoas", pessoas);
		m.addAttribute("pessoa", new Pessoa());

		return "Pessoas";
	}

	@RequestMapping(value = "/pessoaSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("pessoa") Pessoa pessoa) {

		this.pessoaDao.insertPessoa(pessoa);

		return "redirect:/pessoas";
	}

	@RequestMapping(value = "/pessoaDetail/{id}")
	public String pessoa(@PathVariable int id, Model model) {

		Pessoa user = this.pessoaDao.getPessoaById(id);

		model.addAttribute("pessoa", user);

		return "PessoaDetail";

	}

	@RequestMapping(value = "/pessoaUpdate", method = RequestMethod.POST)
	public String pessoaEdit(@ModelAttribute("pessoa") Pessoa pessoa) {

		this.pessoaDao.updatePessoa(pessoa);

		return "redirect:/pessoas";
	}

}
