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

public class StudentServiceImpl implements IStudentService{

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	private PreparedStatement preparedStatement;

	
	@Override
	public Student searchStudentDetailsToVerify(Student student) throws DatabaseErrorException {
	
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_STUDENT_SEARCH_FOR_LOGIN);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, student.getsId());
								
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				Student std = new Student();
				log.trace("student found");
				
				std.setsId(rs.getString("sID"));
				std.setSecured_password(rs.getString("password"));
				std.setSalt(rs.getString("salt"));
				
				return std;
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
		
		return null;
	
		
	}


	@Override
	public AdministrativeStaff searchAdministrativeStaffDetailsToVerify(AdministrativeStaff adstf) throws DatabaseErrorException {

		
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ADMINISTRATIVE_STAFF_SEARCH_FOR_LOGIN);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, adstf.getStfID());
								
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				AdministrativeStaff adstaff = new AdministrativeStaff();
				log.trace("administrative staff member found");
				
				adstaff.setStfID(rs.getString("stfID"));
				adstaff.setSecured_password(rs.getString("password"));
				adstaff.setSalt(rs.getString("salt"));
			
				return adstaff;
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
		
		return null;
	
		
	
	}


	@Override
	public AcademicStaff searchAcademicStaffDetailsToVerify(AcademicStaff acdstf) throws DatabaseErrorException {
		
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ACADEMIC_STAFF_SEARCH_FOR_LOGIN);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, acdstf.getStfID());
								
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				AcademicStaff acdstaff = new AcademicStaff();
				log.trace("academic staff member found");
				
				acdstaff.setStfID(rs.getString("stfID"));
				acdstaff.setSecured_password(rs.getString("password"));
				acdstaff.setSalt(rs.getString("salt"));
			
				return acdstaff;
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
		
		return null;
	
	}


	@Override
	public Admin searchAdminDetailsToVerify(Admin admin) throws DatabaseErrorException {

		
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ADMIN_SEARCH_FOR_LOGIN);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, admin.getaID());
								
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				Admin adm = new Admin();
				log.trace("admin found");
				
				adm.setaID(rs.getString("aID"));
				adm.setSecured_password(rs.getString("password"));
				adm.setSalt(rs.getString("salt"));
			
				return adm;
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
		
		return null;
	
	
	}


	@Override
	public Parent searchParentDetailsToVerify(Parent prn) throws DatabaseErrorException {
	
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_PARENT_SEARCH_FOR_LOGIN);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, prn.getPid());
								
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				Parent pr = new Parent();
				log.trace("parent found");
				
				pr.setPid(rs.getString("pID"));
				pr.setSecured_password(rs.getString("password"));
				pr.setSalt(rs.getString("salt"));
			
				return pr;
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
		
		return null;
	}


	@Override
	public OBMember searchOBMemberDetailsToVerify(OBMember obm) throws DatabaseErrorException {
		
		System.out.println("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_OBMEMBER_SEARCH_FOR_LOGIN);
			System.out.println("Executing query:"+query);
			
			preparedStatement = connection.prepareStatement(query);
								
			preparedStatement.setString(1, obm.getObID());
								
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				OBMember ob = new OBMember();
				log.trace("OBMember found");
				
				ob.setObID(rs.getString("obID"));
				ob.setSecured_password(rs.getString("password"));
				ob.setSalt(rs.getString("salt"));
			
				return ob;
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
		
		return null;
	
		
	}

}
