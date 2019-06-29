package com.itp.service;

import java.io.IOException;
import java.sql.PreparedStatement;
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

public class UpdatePasswordService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(UpdatePasswordService.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	private PreparedStatement preparedStatement;

	public void updateStudentPassword(Student std) throws DatabaseErrorException {
		System.out.println("Updating in database");
		
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_STUDENT_PASSWORD_UPDATE);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, std.getSecured_password());
			preparedStatement.setString(2, std.getSalt());
			preparedStatement.setString(3, std.getsId());				
			
			preparedStatement.execute();
			//connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while updating",e);
			throw new DatabaseErrorException("Error while updating the db",e);
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

	public void updateAdministrativeStaffPassword(AdministrativeStaff adstf) throws DatabaseErrorException{
		
		System.out.println("Updating in database");
		
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ADMINISTRATIVE_STAFF_PASSWORD_UPDATE);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, adstf.getSecured_password());
			preparedStatement.setString(2, adstf.getSalt());
			preparedStatement.setString(3, adstf.getStfID());				
			
			preparedStatement.execute();
			//connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while updating",e);
			throw new DatabaseErrorException("Error while updating the db",e);
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

	public void updateAcademicStaffPassword(AcademicStaff acds) throws DatabaseErrorException {

		
		System.out.println("Updating in database");
		
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ACADEMIC_STAFF_PASSWORD_UPDATE);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, acds.getSecured_password());
			preparedStatement.setString(2, acds.getSalt());
			preparedStatement.setString(3, acds.getStfID());				
			
			preparedStatement.execute();
			//connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while updating",e);
			throw new DatabaseErrorException("Error while updating the db",e);
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

	public void updateAdminPassword(Admin admin) throws DatabaseErrorException {

		System.out.println("Updating in database");
		
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ADMIN_PASSWORD_UPDATE);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, admin.getSecured_password());
			preparedStatement.setString(2, admin.getSalt());
			preparedStatement.setString(3, admin.getaID());				
			
			preparedStatement.execute();
			//connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while updating",e);
			throw new DatabaseErrorException("Error while updating the db",e);
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

	public void updateParentPassword(Parent prn) throws DatabaseErrorException{


		System.out.println("Updating in database");
		
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_PARENT_PASSWORD_UPDATE);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, prn.getSecured_password());
			preparedStatement.setString(2, prn.getSalt());
			preparedStatement.setString(3, prn.getPid());				
			
			preparedStatement.execute();
			//connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while updating",e);
			throw new DatabaseErrorException("Error while updating the db",e);
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

	public void updateOBMemberPassword(OBMember obm) throws DatabaseErrorException{
		
		System.out.println("Updating in database");
		
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_OBMEMBER_PASSWORD_UPDATE);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, obm.getSecured_password());
			preparedStatement.setString(2, obm.getSalt());
			preparedStatement.setString(3, obm.getObID());				
			
			preparedStatement.execute();
			//connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error( "Error while updating",e);
			throw new DatabaseErrorException("Error while updating the db",e);
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
