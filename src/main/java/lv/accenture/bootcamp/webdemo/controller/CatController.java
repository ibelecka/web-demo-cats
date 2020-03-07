package lv.accenture.bootcamp.webdemo.controller;
import lv.accenture.bootcamp.webdemo.repository.CatsRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatsRepository;;


@Controller
public class CatController {
	
	@Autowired
	private CatsRepository catsRepository;

	
	@GetMapping("/cats") 
	public String catIndex(Model model) {
		List<Cat>cats = catsRepository.findAll();
		model.addAttribute("cats", cats);
		return "cats-index";
	}
	
	@GetMapping("/cats/add") 
	public String addCatPage(Model model) {
		model.addAttribute("cat", new Cat());
		
		return "add-cat";
	}
	
	@PostMapping("/cats/add-cat") 
	public String addCat(Cat catToAdd) {
		catsRepository.add(catToAdd);
		return "redirect:/cats";
	}
	
	@GetMapping("/cats/edit/{id}")
	public String editCatPage(@PathVariable Long id, Model model) {
		Cat catToEdit = catsRepository.findById(id);
		
		model.addAttribute("cat", catToEdit);
		return "edit-cat";
	}
	
	@PostMapping("/cats/edit-cat/{id}") 
	public String edit(Cat catToEdit) {
		System.out.println(catToEdit.getNickname());
		System.out.println(catToEdit.getId());
		catsRepository.update(catToEdit);
		return "redirect:/cats";
	}
	
	
}
