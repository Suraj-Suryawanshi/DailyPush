package com.surya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.surya.model.User;
import com.surya.util.DButil;

public class UserDaoImpl implements UserDao {
	   @Override
	   public boolean addUser(User user) {
	        
		   String query = "INSERT INTO \"I1292\"users ( userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	       System.out.println("user add----"); 
	        try (Connection connection = DButil.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	        	preparedStatement.setString(1, user.getUserName());
	        	preparedStatement.setString(2, user.getUserPassword());
	        	preparedStatement.setString(3, user.getUserEmail());
	            preparedStatement.setString(4, user.getUserDob());
	            preparedStatement.setString(5, user.getUserRole());
	            preparedStatement.setString(6, user.getUserJoiningDate());
	            preparedStatement.setInt(7, user.getUserSalary());
	            preparedStatement.setString(8, user.getUserAddress());

	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println(rowsAffected);
	            return rowsAffected > 0;
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	   
	    public List<User> selectAllUsers() {
	    	
	    	String query= "select * from \"I1292\"users";
	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < User > users = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = DButil.getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String userName = rs.getString("userName");
	                String userPassword = rs.getString("userPassword");
	                String userEmail = rs.getString("userEmail");
	                String userDob =rs.getString("userDob");
	                String userRole = rs.getString("userRole");
	                String userJoiningDate =rs.getString("userJoiningDate");
	                int userSalary = rs.getInt("userSalary");
 	                String userAddress = rs.getString("userAddress");
	                users.add(new User(id, userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress));
	            }
	        } catch (SQLException e) {
//	            printSQLException(e);
	        	e.printStackTrace();
	        }
	        return users;
	    }
	    
	    public boolean updateUser(User user) throws SQLException {
	        boolean rowUpdated;
	        String query = "update \"I1292\".users set userName = ?, userPassword=?, userEmail= ?, userDob=?, userRole=?, userJoiningDate=?, userSalary=?, userAddress=? where id = ?;";
	        try (Connection connection = DButil.getConnection(); PreparedStatement statement = connection.prepareStatement(query);) {
	            statement.setString(1, user.getUserName());
	            statement.setString(2, user.getUserPassword());
	            statement.setString(3, user.getUserEmail());
	            statement.setString(4, user.getUserDob());
	            statement.setString(5, user.getUserRole());
	            statement.setString(6, user.getUserJoiningDate());
	            statement.setInt(7, user.getUserSalary());
	            statement.setString(8, user.getUserAddress());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	    
	    public boolean deleteUser(int id) throws SQLException {
	        boolean rowDeleted;
	        String query = "delete from \"I1292\".users where userId=?";
	        try (Connection connection = DButil.getConnection(); 
	        	PreparedStatement statement = connection.prepareStatement(query);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    
	   @Override
	    public boolean isValidUser(String userRole, String userEmail, String userPassword) {
		   System.out.println("servlet valid----");
		   String query = "SELECT * FROM \"I1292\".users WHERE  userEmail =? AND userRole=? AND userPassword = ? ";
	    	try (Connection connection = DButil.getConnection();
	    		PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    		 System.out.println("servlet valid succes----"); 

	            preparedStatement.setString(1, userEmail);
	            preparedStatement.setString(2, userRole);
	            preparedStatement.setString(3, userPassword);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            System.out.println(resultSet);
	            System.out.println(resultSet.next());
	            return resultSet.next();
	        } 
	    	catch (SQLException e) {
	        	System.out.println("servlet exception----");
	            e.printStackTrace();
	            return false;
	        }
	    }
	}