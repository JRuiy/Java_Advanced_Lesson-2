package ua.lgs.lviv;

public class Users {

	private int id;
	private String last_name;
	private String first_name;
	private int age;
	private String mail;

	public Users(int id, String last_name, String first_name, int age, String mail) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.age = age;
		this.mail = mail;
	}

	
	public Users(String last_name, String first_name, int age, String mail) {
		super();
		this.last_name = last_name;
		this.first_name = first_name;
		this.age = age;
		this.mail = mail;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", age=" + age
				+ ", mail=" + mail + "]";
	}

}
