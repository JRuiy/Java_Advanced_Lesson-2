package ua.lgs.lviv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	
	private static String READ_ALL = "select * from users";
	private static String CREATE = "insert into users(`last_name`, `first_name`, `age`, `mail`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from users where id =?";
	private static String UPDATE_BY_ID = "update users set last_name=?, first_name = ?, age = ?, mail = ? where id = ?";
	private static String DELETE_BY_ID = "delete from users where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public UsersDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Users users) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, users.getLast_name());
		preparedStatement.setString(2, users.getFirst_name());
		preparedStatement.setInt(3, users.getAge());
		preparedStatement.setString(4, users.getMail());
		preparedStatement.executeUpdate();
	}
	
	public Users read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AllMapper.mapUser(result);
	}
	
	public void update(Users users) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, users.getLast_name());
		preparedStatement.setString(2, users.getFirst_name());
		preparedStatement.setInt(3, users.getAge());
		preparedStatement.setString(4, users.getMail());
		preparedStatement.setInt(5, users.getId());
		preparedStatement.executeUpdate();
	}
	
	public void delete (int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Users> readAll() throws SQLException{
		List<Users> listOfUsers = new ArrayList<Users>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfUsers.add(AllMapper.mapUser(result));
		}
		return listOfUsers;
	}
	
}
