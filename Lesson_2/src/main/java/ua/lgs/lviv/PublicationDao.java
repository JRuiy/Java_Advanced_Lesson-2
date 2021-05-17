package ua.lgs.lviv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicationDao {

	private static String READ_ALL = "select * from publication";
	private static String CREATE = "insert into publication(`name`) values (?)";
	private static String READ_BY_ID = "select * from publication where id =?";
	private static String UPDATE_BY_ID = "update publication set name=? where id = ?";
	private static String DELETE_BY_ID = "delete from publication where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public PublicationDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Publication publication) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, publication.getName());
		preparedStatement.executeUpdate();
	}
	
	public Publication read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AllMapper.mapPublication(result);
	}
	
	public void update(Publication publication) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, publication.getName());
		preparedStatement.setInt(2, publication.getId());
		preparedStatement.executeUpdate();
	}
	
	public void delete (int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Publication> readAll() throws SQLException{
		List<Publication> listOfPublication = new ArrayList<Publication>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfPublication.add(AllMapper.mapPublication(result));
		}
		return listOfPublication;
	}
	
}
