package lv.accenture.bootcamp.webdemo.model;

import java.io.Serializable;

public class Cat implements Serializable {
	


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private Long id;
	private String nickname;
	private int age;
	private String photo;
	
	public Cat() {
		
	}

	public Cat(Long id, String nickname, int age, String photo) {
		this.id = id;
		this.nickname = nickname;
		this.age = age;
		this.photo = photo;
	}
	
	
	
	
	public Cat(Long id, String nickname) {
		super();
		this.id = id;
		this.nickname = nickname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
