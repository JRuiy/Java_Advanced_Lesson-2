package ua.lgs.lviv;

public class Publication {

	private int id;
	private String name;

	public Publication(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Publication(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", name=" + name + "]";
	}

}
