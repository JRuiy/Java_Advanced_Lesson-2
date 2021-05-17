package ua.lgs.lviv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllMapper {

	public static Users mapUser(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String lastName = result.getString("last_name");
		String firstName = result.getString("first_name");
		int age = result.getInt("age");
		String mail = result.getString("mail");

		return new Users(id, lastName, firstName, age, mail);
	}

	public static Genres mapGenre(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String name = result.getString("name");

		return new Genres(id, name);
	}
	
	public static Publication mapPublication(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String name = result.getString("name");

		return new Publication(id, name);
	}

	public static Magazine mapMagazine(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String name_magazine = result.getString("name_magazine");
		int publication_id = result.getInt("publication_id");
		int genres_id = result.getInt("genres_id");
		String language = result.getString("language");
		int number_of_page = result.getInt("number_of_pages");
		int isbn = result.getInt("isbn");

		return new Magazine(id, name_magazine, publication_id, genres_id, language, number_of_page, isbn);
	}
}
