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
import br.com.fiap.check3.models.Tutor;
import br.com.fiap.check3.repositories.AnimalRepository;
import br.com.fiap.check3.repositories.TutorRepository;

@RequestMapping("/animal")
@Controller
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@GetMapping("")
	public ModelAndView Get() {

		ModelAndView model = new ModelAndView("animal/index");
		List<Animal> listAnimal = animalRepository.findAll();
		model.addObject("animais", listAnimal);
		return model;
	}

	@GetMapping("/create")
	public ModelAndView Create() {
		ModelAndView model = new ModelAndView("animal/create");
		List<Tutor> tutores = tutorRepository.findAll();

		model.addObject("tutores", tutores);
		return model;
	}

	@PostMapping("/create")
	public String Create(@ModelAttribute("animal") Animal objAnimal) {
		animalRepository.save(objAnimal);
		return "redirect:/animal";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView getById(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("animal/edit");
		Animal animal = animalRepository.getReferenceById(id);

		List<Tutor> tutores = tutorRepository.findAll();

		model.addObject("tutores", tutores);
		model.addObject("animal", animal);
		return model;
	}

	@PostMapping("/edit")
	public String edit(Animal animal) {
		animalRepository.save(animal);
		return "redirect:/animal";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		animalRepository.deleteById(id);
		return "redirect:/animal";

	}

}