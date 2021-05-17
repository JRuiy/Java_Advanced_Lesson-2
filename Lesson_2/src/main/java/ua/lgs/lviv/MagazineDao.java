package ua.lgs.lviv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {

	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`name_magazine`, `publication_id`, `genres_id`, `language`, `number_of_pages`, `isbn`) values (?,?,?,?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id =?";
	private static String UPDATE_BY_ID = "update magazine set name_magazine=?, publication_id = ?, genres_id = ?, language = ?, number_of_pages = ?, isbn = ? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MagazineDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, magazine.getName_magazine());
		preparedStatement.setInt(2, magazine.getPublication_id());
		preparedStatement.setInt(3, magazine.getGenres_id());
		preparedStatement.setString(4, magazine.getLanguage());
		preparedStatement.setInt(5, magazine.getNumber_of_page());
		preparedStatement.setInt(6, magazine.getIsbn());
		preparedStatement.executeUpdate();
	}

	public Magazine read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AllMapper.mapMagazine(result);
	}

	public void update(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, magazine.getName_magazine());
		preparedStatement.setInt(2, magazine.getPublication_id());
		preparedStatement.setInt(3, magazine.getGenres_id());
		preparedStatement.setString(4, magazine.getLanguage());
		preparedStatement.setInt(5, magazine.getNumber_of_page());
		preparedStatement.setInt(6, magazine.getIsbn());
		preparedStatement.setInt(7, magazine.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Magazine> readAll() throws SQLException {
		List<Magazine> listOfMagazine = new ArrayList<Magazine>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfMagazine.add(AllMapper.mapMagazine(result));
		}
		return listOfMagazine;
	}

}
