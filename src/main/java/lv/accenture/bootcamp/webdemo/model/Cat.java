package lv.accenture.bootcamp.webdemo.model;

public class Cat {
	
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

	private Long id;
	private String nickname;
	
	public Cat() {
		
	}

	public Cat(Long id, String nickname) {
		this.id = id;
		this.nickname = nickname;
	}
	
	
	
	

}