package ua.lgs.lviv;

public class Magazine {

	private int id;
	private String name_magazine;
	private int publication_id;
	private int genres_id;
	private String language;
	private int number_of_page;
	private int isbn;

	public Magazine(int id, String name_magazine, int publication_id, int genres_id, String language,
			int number_of_page, int isbn) {
		super();
		this.id = id;
		this.name_magazine = name_magazine;
		this.publication_id = publication_id;
		this.genres_id = genres_id;
		this.language = language;
		this.number_of_page = number_of_page;
		this.isbn = isbn;
	}

	public Magazine(String name_magazine, int publication_id, int genres_id, String language, int number_of_page,
			int isbn) {
		super();
		this.name_magazine = name_magazine;
		this.publication_id = publication_id;
		this.genres_id = genres_id;
		this.language = language;
		this.number_of_page = number_of_page;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_magazine() {
		return name_magazine;
	}

	public void setName_magazine(String name_magazine) {
		this.name_magazine = name_magazine;
	}

	public int getPublication_id() {
		return publication_id;
	}

	public void setPublication_id(int publication_id) {
		this.publication_id = publication_id;
	}

	public int getGenres_id() {
		return genres_id;
	}

	public void setGenres_id(int genres_id) {
		this.genres_id = genres_id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNumber_of_page() {
		return number_of_page;
	}

	public void setNumber_of_page(int number_of_page) {
		this.number_of_page = number_of_page;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", name_magazine=" + name_magazine + ", publication_id=" + publication_id
				+ ", genres_id=" + genres_id + ", language=" + language + ", number_of_page=" + number_of_page
				+ ", isbn=" + isbn + "]";
	}

}
