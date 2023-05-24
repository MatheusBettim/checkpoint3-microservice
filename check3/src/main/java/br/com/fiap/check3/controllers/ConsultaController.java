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

import br.com.fiap.check3.models.Animal;
import br.com.fiap.check3.models.Consulta;
import br.com.fiap.check3.models.Dia;
import br.com.fiap.check3.models.Veterinario;
import br.com.fiap.check3.repositories.AnimalRepository;
import br.com.fiap.check3.repositories.ConsultaRepository;
import br.com.fiap.check3.repositories.DiaRepository;
import br.com.fiap.check3.repositories.VeterinarioRepository;

@RequestMapping("/consulta")
@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository consultaRepository; 
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private DiaRepository diaRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@GetMapping("")
	public ModelAndView Get() {

		ModelAndView model = new ModelAndView("consulta/index");
		List<Consulta> listConsulta = consultaRepository.findAll();
		model.addObject("consultas", listConsulta);
		return model;
	}

	@GetMapping("/create")
	public ModelAndView Create() {
		ModelAndView model = new ModelAndView("consulta/create");
		List<Dia> dias = diaRepository.findAll();
		List<Veterinario> veterinarios = veterinarioRepository.findAll();
		List<Animal> animais = animalRepository.findAll();
		model.addObject("veterinarios", veterinarios);
		model.addObject("animais", animais);
		model.addObject("dias", dias);
		return model;
	}

	@PostMapping("/create")
	public String Create(@ModelAttribute("consulta") Consulta objConsulta) {
		consultaRepository.save(objConsulta);
		return "redirect:/consulta";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("consulta/edit");
		Consulta consulta = consultaRepository.getReferenceById(id);
		List<Dia> dias = diaRepository.findAll();
		List<Veterinario> veterinarios = veterinarioRepository.findAll();
		List<Animal> animais = animalRepository.findAll();
		model.addObject("animais", animais);
		model.addObject("dias", dias);
		model.addObject("veterinarios", veterinarios);
		model.addObject("consultas", consulta);
		return model;
	}

	@PostMapping("/edit")
	public String edit(Consulta consulta) {
		consultaRepository.save(consulta);
		return "redirect:/consulta";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		consultaRepository.deleteById(id);
		return "redirect:/consulta";
		
	}

}

