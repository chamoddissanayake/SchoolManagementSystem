package com.itp.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.itp.exception.DatabaseErrorException;
import com.itp.exception.QueryLoadingException;
import com.itp.model.AcademicStaff;
import com.itp.model.Admin;
import com.itp.model.AdministrativeStaff;
import com.itp.model.OBMember;
import com.itp.model.Parent;
import com.itp.model.Student;
import com.itp.util.CommonConstants;
import com.itp.util.DBConnectionUtil;
import com.itp.util.QueryUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginTrackService  {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	private PreparedStatement preparedStatement;

	public void trackStudentLoginDetails(Student student) throws DatabaseErrorException {
		
		System.out.println("Adding to database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_LOGIN_TRACK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			preparedStatement.setString(1, "student");
			preparedStatement.setString(2, student.getsId()+" logged on "+dateFormat.format(date));
								
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while adding",e);
			throw new DatabaseErrorException("Error while adding to the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}
	
		
	}

	
	public void trackAdministrativeStaffLoginDetails(AdministrativeStaff obj) throws DatabaseErrorException{
		
		System.out.println("Adding to database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_LOGIN_TRACK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			preparedStatement.setString(1, "administrative_staff");
			preparedStatement.setString(2, obj.getStfID()+" logged on "+dateFormat.format(date));
								
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while adding",e);
			throw new DatabaseErrorException("Error while adding to the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}	
	}


	public void trackAcademicStaffLoginDetails(AcademicStaff obj) throws DatabaseErrorException {
		
		System.out.println("Adding to database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_LOGIN_TRACK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			preparedStatement.setString(1, "academic_staff");
			preparedStatement.setString(2, obj.getStfID()+" logged on "+dateFormat.format(date));
								
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while adding",e);
			throw new DatabaseErrorException("Error while adding to the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}	
	
	}


	public void trackAdminLoginDetails(Admin obj) throws DatabaseErrorException{

		System.out.println("Adding to database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_LOGIN_TRACK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			preparedStatement.setString(1, "admin");
			preparedStatement.setString(2, obj.getaID()+" logged on "+dateFormat.format(date));
								
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while adding",e);
			throw new DatabaseErrorException("Error while adding to the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}	
	}




	public void trackParentLoginDetails(Parent obj) throws DatabaseErrorException{
		
		System.out.println("Adding to database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_LOGIN_TRACK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			preparedStatement.setString(1, "parent");
			preparedStatement.setString(2, obj.getPid()+" logged on "+dateFormat.format(date));
								
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while adding",e);
			throw new DatabaseErrorException("Error while adding to the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}	
	}

	public void trackOBMemberLoginDetails(OBMember obj) throws DatabaseErrorException {
		
		System.out.println("Adding to database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_LOGIN_TRACK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			preparedStatement.setString(1, "ob_member");
			preparedStatement.setString(2, obj.getObID()+" logged on "+dateFormat.format(date));
								
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while adding",e);
			throw new DatabaseErrorException("Error while adding to the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}	
	
	
		
	}


	
	
}
