package br.com.fiap.check3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.check3.models.Dia;
import br.com.fiap.check3.models.Especialidade;
import br.com.fiap.check3.models.Veterinario;
import br.com.fiap.check3.repositories.DiaRepository;
import br.com.fiap.check3.repositories.EspecialidadeRepository;
import br.com.fiap.check3.repositories.VeterinarioRepository;

@RequestMapping("/veterinario")
@Controller
public class VeterinarioController {
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private DiaRepository diaRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping("")
	public ModelAndView Get() {

		ModelAndView model = new ModelAndView("veterinario/index");
		List<Veterinario> listVeterinario = veterinarioRepository.findAll();
		model.addObject("veterinarios", listVeterinario);
		return model;
	}

	@GetMapping("/create")
	public ModelAndView Create() {
		ModelAndView model = new ModelAndView("veterinario/create");
		List<Dia> dias = diaRepository.findAll();
		List<Especialidade> especialidades = especialidadeRepository.findAll();
		model.addObject("especialidades", especialidades);
		model.addObject("dias", dias);
		return model;
	}

	@PostMapping("/create")
	public String Create(@ModelAttribute("veterinario") Veterinario objVeterinario) {
		veterinarioRepository.save(objVeterinario);
		return "redirect:/veterinario";
	}
	@GetMapping("/dia/{id}")
	@ResponseBody
	public List<Veterinario> getVeterinarioByDia(@PathVariable("id") Long idDia) {
		List<Veterinario> veterinarios = veterinarioRepository.findByIdDia(idDia);
		return veterinarios;	 	
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("veterinario/edit");
		Veterinario veterinario = veterinarioRepository.getReferenceById(id);
		List<Dia> dias = diaRepository.findAll();
		List<Especialidade> especialidades = especialidadeRepository.findAll();
		model.addObject("especialidades", especialidades);
		model.addObject("dias", dias);
		model.addObject("veterinario", veterinario);
		return model;
	}

	@PostMapping("/edit")
	public String edit(Veterinario veterinario) {
		veterinarioRepository.save(veterinario);
		return "redirect:/veterinario";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		veterinarioRepository.deleteById(id);
		return "redirect:/veterinario";
		
	}

}
