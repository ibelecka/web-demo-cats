package lv.accenture.bootcamp.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {

	
	@GetMapping("/cats") 
	public String catIndex(Model model) {
		model.addAttribute("test", "it works!");
		return "cats-index";
	}
}
