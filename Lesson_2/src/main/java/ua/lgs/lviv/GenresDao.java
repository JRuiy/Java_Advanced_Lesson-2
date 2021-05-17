package ua.lgs.lviv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenresDao {

	private static String READ_ALL = "select * from genres";
	private static String CREATE = "insert into genres(`name`) values (?)";
	private static String READ_BY_ID = "select * from genres where id =?";
	private static String UPDATE_BY_ID = "update genres set name=? where id = ?";
	private static String DELETE_BY_ID = "delete from genres where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public GenresDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Genres genres) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, genres.getName());
		preparedStatement.executeUpdate();
	}
	
	public Genres read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AllMapper.mapGenre(result);
	}
	
	public void update(Genres genres) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, genres.getName());
		preparedStatement.setInt(2, genres.getId());
		preparedStatement.executeUpdate();
	}
	
	public void delete (int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Genres> readAll() throws SQLException{
		List<Genres> listOfGenres = new ArrayList<Genres>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfGenres.add(AllMapper.mapGenre(result));
		}
		return listOfGenres;
	}
	
}
