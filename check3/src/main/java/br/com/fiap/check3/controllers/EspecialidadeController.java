package br.com.fiap.check3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.check3.models.Especialidade;
import br.com.fiap.check3.repositories.EspecialidadeRepository;

@RequestMapping("/especialidade")
@Controller

public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("")
	public ModelAndView Get() {

		ModelAndView model = new ModelAndView("especialidade/index");
		List<Especialidade> listEspecialidade = especialidadeRepository.findAll();
		model.addObject("especialidades", listEspecialidade);
		return model;
	}

	@GetMapping("/create")
	public ModelAndView Create() {
		ModelAndView model = new ModelAndView("especialidade/create");
		return model;
	}

	@PostMapping("/create")
	public String Create(@ModelAttribute("especialidade") Especialidade objEspecialidade) {
		especialidadeRepository.save(objEspecialidade);
		return "redirect:/veterinario/create";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("especialidade/edit");
		Especialidade especialidade = especialidadeRepository.getReferenceById(id);
		model.addObject("especialidade", especialidade);
		return model;
	}

	@PostMapping("/edit")
	public String edit(Especialidade especialidade) {
		especialidadeRepository.save(especialidade);
		return "redirect:/especialidade";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		especialidadeRepository.deleteById(id);
		return "redirect:/especialidade";

	}

}
