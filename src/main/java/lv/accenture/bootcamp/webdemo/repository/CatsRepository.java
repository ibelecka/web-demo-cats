package lv.accenture.bootcamp.webdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.accenture.bootcamp.webdemo.model.Cat;

@Component
public class CatsRepository {

	private List<Cat> cats = new ArrayList<>();

	public CatsRepository() {
		cats.add(new Cat(1L, "Muris"));
		cats.add(new Cat(2L, "Pucinsh"));
	}

	public List<Cat> findAll() {
		return cats;
	}
	
	public void add (Cat cat) {
		Long id = 0L;
		for (int i = 0; i<cats.size(); i++) {
			if (cats.get(i).getId() >= id) {
				id = cats.get(i).getId() + 1;
			}
		}
		cat.setId(id);
		cats.add(cat);
	}

}
