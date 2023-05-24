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

import br.com.fiap.check3.models.Tutor;
import br.com.fiap.check3.repositories.TutorRepository;

@RequestMapping("/tutor")
@Controller
public class TutorController {

	@Autowired
	private TutorRepository tutorRepository;
	
	@GetMapping("")
	public ModelAndView Get() {

		ModelAndView model = new ModelAndView("tutor/index");
		List<Tutor> listTutor = tutorRepository.findAll();
		model.addObject("tutores", listTutor);
		return model;
	}

	@GetMapping("/create")
	public ModelAndView Create() {
		ModelAndView model = new ModelAndView("tutor/create");
		return model;
	}

	@PostMapping("/create")
	public String Create(@ModelAttribute("tutor") Tutor objTutor) {
		tutorRepository.save(objTutor);
		return "redirect:/tutor";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("tutor/edit");
		Tutor tutor = tutorRepository.getReferenceById(id);
		model.addObject("tutor", tutor);
		return model;
	}

	@PostMapping("/edit")
	public String edit(Tutor tutor) {
		tutorRepository.save(tutor);
		return "redirect:/tutor";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		tutorRepository.deleteById(id);
		return "redirect:/tutor";
		
	}

}

