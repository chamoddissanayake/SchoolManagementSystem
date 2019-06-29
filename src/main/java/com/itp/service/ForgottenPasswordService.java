package com.itp.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class ForgottenPasswordService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	private PreparedStatement preparedStatement;
	
	
	public boolean ValidateStudentIdAndEmail(Student stdObj) throws DatabaseErrorException{
		boolean found = false;
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_STUDENT_EMAIL_CHECK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, stdObj.getsId());
			preparedStatement.setString(2, stdObj.getEmail());
								
			ResultSet rs = preparedStatement.executeQuery();

			int count= 0;
			while (rs.next()) {
				count++;
			}
			if(count!=0) {
				found = true;
			}else {
				found = false;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error on login",e);
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return found;
	}


	public boolean ValidateAdministrativeStaffIdAndEmail(AdministrativeStaff adstf) throws DatabaseErrorException {
		

		boolean found = false;
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ADMINISTRATIVE_STAFF_EMAIL_CHECK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, adstf.getStfID());
			preparedStatement.setString(2, adstf.getEmail());
								
			ResultSet rs = preparedStatement.executeQuery();

			int count= 0;
			while (rs.next()) {
				count++;
			}
			if(count!=0) {
				found = true;
			}else {
				found = false;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error on login",e);
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return found;
	}


	public boolean ValidateAcademicStaffIdAndEmail(AcademicStaff acdstf) throws DatabaseErrorException {

		boolean found = false;
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ACADEMIC_STAFF_EMAIL_CHECK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, acdstf.getStfID());
			preparedStatement.setString(2, acdstf.getEmail());
								
			ResultSet rs = preparedStatement.executeQuery();

			int count= 0;
			while (rs.next()) {
				count++;
			}
			if(count!=0) {
				found = true;
			}else {
				found = false;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error on login",e);
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return found;
	
	}


	public boolean AdminIdAndEmail(Admin admin) throws DatabaseErrorException {


		boolean found = false;
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ADMIN_EMAIL_CHECK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, admin.getaID());
			preparedStatement.setString(2, admin.getEmail());
								
			ResultSet rs = preparedStatement.executeQuery();

			int count= 0;
			while (rs.next()) {
				count++;
			}
			if(count!=0) {
				found = true;
			}else {
				found = false;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error on login",e);
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return found;
	}


	public boolean ParentIdAndEmail(Parent prn) throws DatabaseErrorException {
		boolean found = false;
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_PARENT_EMAIL_CHECK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, prn.getPid());
			preparedStatement.setString(2, prn.getEmail());
								
			ResultSet rs = preparedStatement.executeQuery();

			int count= 0;
			while (rs.next()) {
				count++;
			}
			if(count!=0) {
				found = true;
			}else {
				found = false;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error on login",e);
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return found;
	}


	public boolean OBMemberIdAndEmail(OBMember obm) throws DatabaseErrorException {

		boolean found = false;
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_OBMEMBER_EMAIL_CHECK);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, obm.getObID());
			preparedStatement.setString(2, obm.getEmail());
								
			ResultSet rs = preparedStatement.executeQuery();

			int count= 0;
			while (rs.next()) {
				count++;
			}
			if(count!=0) {
				found = true;
			}else {
				found = false;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error on login",e);
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return found;
	}
	
}
