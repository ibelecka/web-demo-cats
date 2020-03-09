package lv.accenture.bootcamp.webdemo.controller;
import lv.accenture.bootcamp.webdemo.repository.CatsRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatsRepository;;


@Controller
public class CatController {
	
	@Autowired
	private CatsRepository catsRepository;

	
	@GetMapping("/cats") 
	public String catIndex(Model model) {
		Iterable<Cat>cats = catsRepository.findAll();
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
		catsRepository.save(catToAdd);
		return "redirect:/cats";
	}
	
	@GetMapping("/cats/edit/{id}")
	public String editCatPage(@PathVariable Long id, Model model) {
		Optional<Cat> catToEdit = catsRepository.findById(id);
		model.addAttribute("cat", catToEdit.get());
		return "edit-cat";
	}
	
	@PostMapping("/cats/edit-cat/{id}") 
	public String edit(Cat catToEdit) {
		catsRepository.save(catToEdit);
		return "redirect:/cats";
	}
	
	@GetMapping("/cats/delete/{id}")
	public String deleteCatPage(@PathVariable Long id) {
		catsRepository.deleteById(id);
		return "redirect:/cats";
	}
	
	
	@GetMapping("/cats/search")
	public String searchCats(@RequestParam String catName, Model model) {
		List<Cat> matchedCats = catsRepository.findByNickname(catName);
		model.addAttribute("cats", matchedCats);		
		return "cats-index";
	}
	
	
}
