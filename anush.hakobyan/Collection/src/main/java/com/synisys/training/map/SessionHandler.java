package com.synisys.training.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.WeakHashMap;

/**
 * Stores WeakHashMap between user and the live session.
 */
public class SessionHandler {
	
	WeakHashMap<User, String> userSessions = new WeakHashMap<User, String>();
	
	/**
	 * Adds newly logged in user in WeakHashMap
	 * @param resultSet 
	 * @param sessionId
	 * @return true, if user has been added, false otherwise
	 */
	public boolean registerSignedUserSessions(ResultSet resultSet, String sessionId) {
		try{
			User user = this.createUser(resultSet);
			userSessions.put(user, sessionId);
		} catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQlException while reading resultSet"); 
			return false;
		}
		return true;
	}
	
	/**
	 * Creates User from the given resultSet
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private User createUser(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("Name");
		String username = resultSet.getString("UserName");
		Integer userId = resultSet.getInt("UserId");
		User newUser = new User(userId, username, name);
		return newUser;
	}
	
	/**
	 * Checks whether user have been deleted form the WeakHashMap after logging out.
	 * @param user which should be logged out.
	 * @return true if user is logged out, false otherwise.
	 */
	public boolean isUserLoggedOut(User user) {
		return userSessions.get(user) == null;
	}
		
}
