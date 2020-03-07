package lv.accenture.bootcamp.webdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.accenture.bootcamp.webdemo.model.Cat;

@Component
public class CatsRepository {

	private List<Cat> cats = new ArrayList<>();

	public CatsRepository() {
		String url1 = "https://previews.123rf.com/images/evdoha/evdoha1304/evdoha130405453/19338637-red-with-gray-fluffy-cat.jpg";
		String url2 = "https://www.catbreedslist.com/uploads/allimg/cat-pictures/Persian-Cat-1.jpg";
		cats.add(new Cat(1L, "Muris", 5, url1));
		cats.add(new Cat(2L, "Pucinsh", 7, url2));
	}

	public List<Cat> findAll() {
		return cats;
	}

	public void add(Cat cat) {
		Long id = 0L;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getId() >= id) {
				id = cats.get(i).getId() + 1;
			}
		}
		cat.setId(id);

		cats.add(cat);
	}

	public Cat findById(Long id) {

		for (Cat c : cats) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		throw new IllegalArgumentException("Cat by id: " + id + " not found!");
	}

	public void update(Cat cat) {
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getId().equals(cat.getId())) {
				cats.set(i, cat);
				return;
			}
		}
		throw new IllegalArgumentException("Cat by id: " + cat.getId() + " not found!");

	}

	public void deleteCat(Long id) {
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getId().equals(id)) {
				cats.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("Cat by id: " + id + " not found!");
	}

}
