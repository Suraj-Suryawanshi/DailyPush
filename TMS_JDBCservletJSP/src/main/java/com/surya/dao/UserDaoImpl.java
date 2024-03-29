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

	   User user=new User();
		
//	   @Override
	   public List<User> UsersByMonthYear(String startDate, String endDate){

		    System.out.println("UserByMonthYear::Call----------"+startDate+"-------"+endDate);
	    	String query= "SELECT * FROM \"I1292\".users WHERE userjoiningdate  BETWEEN ? AND ? ";
//	    	String query= "SELECT * FROM \"I1292\".users WHERE userjoiningdate  BETWEEN '2023-01-01' AND '2023-03-12";
	    	System.out.println("selectAllUser::Call----------"+user);
	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < User > users = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = DButil.getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            preparedStatement.setString(1, startDate);
	            preparedStatement.setString (2, endDate);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            System.out.println("selectAllUsers::--------"+users);
	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("userId");
	                String userName = rs.getString("userName");
	                String userPassword = rs.getString("userPassword");
	                String userEmail = rs.getString("userEmail");
	                String userDob =rs.getString("userDob");
	                String userRole = rs.getString("userRole");
	                String userJoiningDate =rs.getString("userJoiningDate");
	                int userSalary = rs.getInt("userSalary");
 	                String userAddress = rs.getString("userAddress");
	                users.add(new User(id, userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress));
	                System.out.println("\nselectAll::userDaoImpl-------"+user);
	            }
	        } catch (SQLException e) {
//	            printSQLException(e);
	        	e.printStackTrace();
	        }
	        return users;
	   }
	   
	   
		
	   @Override
	   public boolean addUser(User user) {

		   String query = "INSERT INTO \"I1292\".users ( userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
	            System.out.println("addUser-----------"+rowsAffected);
	            return rowsAffected > 0;
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }

	    }
	@Override
	public User getUserById(int userId) {
		    User user = null;
		    String query = "SELECT * FROM \"I1292\".users WHERE userId=?";

		    try (Connection connection = DButil.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		        System.out.println("UserId-------"+userId);
		        preparedStatement.setInt(1, userId);
		        ResultSet rs = preparedStatement.executeQuery();
		        System.out.println("ResultSEt-----"+rs.toString());
		        if (rs.next()) {
		            int id = rs.getInt("userId");
		            String userName = rs.getString("userName");
		            String userPassword = rs.getString("userPassword");
		            String userEmail = rs.getString("userEmail");
		            String userDob = rs.getString("userDob");
		            String userRole = rs.getString("userRole");
		            String userJoiningDate = rs.getString("userJoiningDate");
		            int userSalary = rs.getInt("userSalary");
		            String userAddress = rs.getString("userAddress");

		            user = new User(id, userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress);
		            System.out.println("insideUserGet------"+user);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Handle exception
		    }
		    System.out.println("-----------"+user);
		    return user;
		}

//	   @Override
//	public User getUserById(int userId) {
//		   System.out.println("daoUserId-----------"+userId);
//	        User user = null;
//	        String query = "select * from \"I1292\".users where id=?";
//	        // Step 1: Establishing a Connection
//	        try (Connection connection = DButil.getConnection();
//	            // Step 2:Create a statement using connection object
//	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
//	            preparedStatement.setInt(1, userId);
//	            System.out.println(preparedStatement);
//	            // Step 3: Execute the query or update query
//	            ResultSet rs = preparedStatement.executeQuery();
//	            System.out.println("ResultSet :: getUserById"+rs);
//	            // Step 4: Process the ResultSet object.
//
//	            	  while (rs.next()) {
//	  	                int id = rs.getInt("userId");
//	  	                String userName = rs.getString("userName");
//	  	                String userPassword = rs.getString("userPassword");
//	  	                String userEmail = rs.getString("userEmail");
//	  	                String userDob =rs.getString("userDob");
//	  	                String userRole = rs.getString("userRole");
//	  	                String userJoiningDate =rs.getString("userJoiningDate");
//	  	                int userSalary = rs.getInt("userSalary");
//	   	                String userAddress = rs.getString("userAddress");
//
//	                user = new User(id, userName, userPassword,userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress );
//
//	       }
//	            } catch (SQLException e) {
//	            	e.printStackTrace();
//	        }
//	        return user;
//	    }

//	   	public User getUserById(int userId) {
//	   	 String query = "select * from \"I1292\".users where id=?";
//	   	 User user=new User();
//	   	try (Connection connection = DButil.getConnection();
//
//	            // Step 2:Create a statement using connection object
//	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
//	            System.out.println(preparedStatement);
//	            // Step 3: Execute the query or update query
//	            ResultSet rs = preparedStatement.executeQuery();
//	            preparedStatement.setInt(1, userId);
//	            // Step 4: Process the ResultSet object.
////	            while (rs.next()) {
//	            	user.setUserId(rs.getInt("userId"));
//
//	                user.setUserName(rs.getString("userName"));
//	                user.setUserAddress(rs.getString("userPassword"));
//	                user.setUserEmail(rs.getString("userEmail"));
//	                user.setUserDob(rs.getString("userDob"));
//	                user.setUserRole(rs.getString("userRole"));
//	                user.setUserJoiningDate(rs.getString("userJoiningDate"));
//	                user.setUserSalary(rs.getInt("userSalary"));
// 	                user.setUserAddress(rs.getString("userAddress"));
////	                user.add(new User(id, userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress));
//	                System.out.println("getById------"+user);
////	            }
//	        } catch (SQLException e) {
////	            printSQLException(e);
//	        	System.out.println("id-----------");
//	        	e.printStackTrace();
//	        }
//	        return user;
//
//	   	}

	   @Override
	    public List<User> selectAllUsers() {
		   System.out.println("selectAllUser::Call----------"+user);
	    	String query= "select * from \"I1292\".users";
	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < User > users = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = DButil.getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            System.out.println("selectAllUsers::--------"+users);
	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("userId");
	                String userName = rs.getString("userName");
	                String userPassword = rs.getString("userPassword");
	                String userEmail = rs.getString("userEmail");
	                String userDob =rs.getString("userDob");
	                String userRole = rs.getString("userRole");
	                String userJoiningDate =rs.getString("userJoiningDate");
	                int userSalary = rs.getInt("userSalary");
 	                String userAddress = rs.getString("userAddress");
	                users.add(new User(id, userName, userPassword, userEmail, userDob, userRole, userJoiningDate, userSalary, userAddress));
	                System.out.println("\nselectAll::userDaoImpl-------"+user);
	            }
	        } catch (SQLException e) {
//	            printSQLException(e);
	        	e.printStackTrace();
	        }
	        return users;
	    }

	   @Override
	   public List<User> employeeUserList(){
		   String query = "select userName,userEmail from \"I1292\".users where userRole=?";
		   List<User> empList = new ArrayList<>();
		   try(Connection connection = DButil.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);  ){
			   	 preparedStatement.setString(1, "Employee");
			   	 ResultSet rs = preparedStatement.executeQuery();

			   	 while(rs.next()) {
//			   		 int userId=rs.getInt("userId");
			   		 String userName = rs.getString("userName");
			   		 String userEmail = rs.getString("userEmail");
			   		 empList.add(new User( userName, userEmail));
			   	 }
			   	 System.out.println("empList::userDaoImpl"+empList);
		   }
		   catch(SQLException e){
			   e.printStackTrace();
		   }
		   return empList;
	   }

	   @Override
	   public List<User> managerUserList(){
		   String query="Select userName,userEmail from \"I1292\".users where userRole=?";
		   List<User> categoryList = new ArrayList<>();
		   try(Connection connection = DButil.getConnection();
				   PreparedStatement preparedStatement=connection.prepareStatement(query)){
			   preparedStatement.setString(1, "Manager");
			   ResultSet rs = preparedStatement.executeQuery();

			   while(rs.next()) {
//				   int userId = rs.getInt("userId");
				   String userName = rs.getString("userName");
				   String userEmail = rs.getString("userEmail");
				   categoryList.add(new User(userName, userEmail));
			   }
			   System.out.println("\n listCategoryUser::userDaoImpl----"+categoryList);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;

	   }
	   @Override
	    public boolean updateUser(User user) throws SQLException {
	        boolean rowUpdated;
//	        int userId=user.getUserId();
	        String query = "update \"I1292\".users set userName = ?, userEmail= ?, userDob=?, userRole=?, userJoiningDate=?, userSalary=?, userAddress=? , userPassword=? where userId = ?;";
	        try (Connection connection = DButil.getConnection(); PreparedStatement statement = connection.prepareStatement(query);) {
	            statement.setString(1, user.getUserName());
	            statement.setString(2, user.getUserEmail());
	            statement.setString(3, user.getUserDob());
	            statement.setString(4, user.getUserRole());
	            statement.setString(5, user.getUserJoiningDate());
	            statement.setInt(6, user.getUserSalary());
	            statement.setString(7, user.getUserAddress());
	            statement.setString(8, user.getUserPassword());
	            statement.setInt(9, user.getUserId());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }

	   @Override
	    public boolean deleteUser(int userId) throws SQLException {
	        boolean rowDeleted;
	        String query = "delete from \"I1292\".users where userId=?";
	        try (Connection connection = DButil.getConnection();
	        	PreparedStatement statement = connection.prepareStatement(query);) {
	            statement.setInt(1, userId);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }




	   @Override
	    public boolean isValidUser(String userEmail,String userRole,  String userPassword) {
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
	            return resultSet.next();
	        }
	    	catch (SQLException e) {
	        	System.out.println("servlet exception----");
	            e.printStackTrace();
	            return false;
	        }
	    }
	}