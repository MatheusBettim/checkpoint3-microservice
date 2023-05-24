package br.com.fiap.check3.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.check3.models.Dia;
import br.com.fiap.check3.repositories.DiaRepository;

@Controller
@RequestMapping("/dia")
public class DiaController {

	@Autowired
	private DiaRepository diaRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("dia/index");
		List<Dia> listaDias = new ArrayList<Dia>();

		Dia diaUm = new Dia();
		diaUm.setDia("Domingo");
		diaUm.setId((long) 1);
		Dia diaDois = new Dia();
		diaDois.setDia("Segunda");
		diaDois.setId((long) 2);
		Dia diaTres = new Dia();
		diaTres.setDia("Terça");
		diaTres.setId((long) 3);
		Dia diaQuatro = new Dia();
		diaQuatro.setDia("Quarta");
		diaQuatro.setId((long) 4);
		Dia diaCinco = new Dia();
		diaCinco.setDia("Quinta");
		diaCinco.setId((long) 5);
		Dia diaSeis = new Dia();
		diaSeis.setDia("Sexta");
		diaSeis.setId((long) 6);
		Dia diaSete = new Dia();
		diaSete.setDia("Sábado");
		diaSete.setId((long) 7);
		listaDias.add(diaUm);
		listaDias.add(diaDois);
		listaDias.add(diaTres);
		listaDias.add(diaQuatro);
		listaDias.add(diaCinco);
		listaDias.add(diaSeis);
		listaDias.add(diaSete);
		diaRepository.saveAll(listaDias);

		model.addObject("dias", listaDias);
		return model;
	}
}
