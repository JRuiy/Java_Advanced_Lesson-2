package ua.lgs.lviv;

import java.sql.SQLException;

public class Aplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/****************************Users**************************/
		
		System.out.println("<--------------------Users------------------------>");
		
		UsersDao usersDao = new UsersDao(ConnectionUtils.openConnection());
		
		usersDao.insert(new Users("Hodor", "Vadim", 22, "vad@gmail.com"));
		usersDao.insert(new Users("Mazko", "Nazar", 25, "nazar@gmail.com"));
		
		System.out.println("*************************************");
		
		Users userFromBD = usersDao.read(2);
		System.out.println(userFromBD);
		
		System.out.println("*************************************");
		
		userFromBD.setLast_name(userFromBD.getLast_name() + "-Zubko");
		usersDao.update(userFromBD);
		
		usersDao.delete(1);
		
		System.out.println("*************************************");
		
		for (int i = 0; i<= usersDao.readAll().size()-1; i++) {
			System.out.println(usersDao.readAll().get(i));
		}
		
		/***************************Genres***************************/
		
		System.out.println("<--------------------Genres------------------------>");
		
		GenresDao genresDao = new GenresDao(ConnectionUtils.openConnection());
		
		genresDao.insert(new Genres("Fantasy"));
		genresDao.insert(new Genres("Comedy"));
		genresDao.insert(new Genres("Money"));
		
		System.out.println("*************************************");
		
		Genres genreFromBD = genresDao.read(3);
		System.out.println(genreFromBD);
		
		System.out.println("*************************************");
		
		genreFromBD.setName("Tragico-" + genreFromBD.getName());
		genresDao.update(genreFromBD);
		
		genresDao.delete(4);
		
		System.out.println("*************************************");
		
		for (int i = 0; i<= genresDao.readAll().size()-1; i++) {
			System.out.println(genresDao.readAll().get(i));
		}
		
		/***************************Publication***************************/
		
		System.out.println("<--------------------Publication------------------------>");
		
		PublicationDao publicationDao = new PublicationDao(ConnectionUtils.openConnection());
		
		publicationDao.insert(new Publication("Forbes"));
		publicationDao.insert(new Publication("De Agostini"));
		publicationDao.insert(new Publication("Hachette"));
		
		System.out.println("*************************************");
		
		Publication publicationFromBD = publicationDao.read(3);
		System.out.println(publicationFromBD);
		
		System.out.println("*************************************");
		
		publicationFromBD.setName("Tragico-" + publicationFromBD.getName());
		publicationDao.update(publicationFromBD);
		
		publicationDao.delete(3);
		
		System.out.println("*************************************");
		
		for (int i = 0; i<= publicationDao.readAll().size()-1; i++) {
			System.out.println(publicationDao.readAll().get(i));
		}
		
		/***************************Magazine***************************/
		
		System.out.println("<--------------------Magazine------------------------>");

		MagazineDao magazineDao = new MagazineDao(ConnectionUtils.openConnection());
		
		magazineDao.insert(new Magazine("Forbes Ukraine Magazin", 1, 3, "russian", 50, 124751));
		magazineDao.insert(new Magazine("Fachion history", 2, 2, "english", 40, 124736));
		magazineDao.insert(new Magazine("Tractors of the world", 2, 1, "english", 45, 124173));
		
		System.out.println("*************************************");
		
		Magazine magazineFromBD = magazineDao.read(2);
		System.out.println(magazineFromBD);
		
		System.out.println("*************************************");
		
		magazineFromBD.setName_magazine(". Issue 1" + magazineFromBD.getName_magazine());
		magazineDao.update(magazineFromBD);
		
		magazineDao.delete(3);
		
		System.out.println("*************************************");
		
		for (int i = 0; i<= magazineDao.readAll().size()-1; i++) {
			System.out.println(magazineDao.readAll().get(i));
		}
	}
	
}
