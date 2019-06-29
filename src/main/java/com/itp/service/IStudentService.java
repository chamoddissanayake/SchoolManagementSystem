package com.itp.service;

import com.itp.exception.DatabaseErrorException;
import com.itp.model.AcademicStaff;
import com.itp.model.Admin;
import com.itp.model.AdministrativeStaff;
import com.itp.model.OBMember;
import com.itp.model.Parent;
import com.itp.model.Student;


public interface IStudentService {
	Student searchStudentDetailsToVerify(Student student) throws DatabaseErrorException;

	AdministrativeStaff searchAdministrativeStaffDetailsToVerify(AdministrativeStaff adstf)throws DatabaseErrorException;

	AcademicStaff searchAcademicStaffDetailsToVerify(AcademicStaff acdstf) throws DatabaseErrorException;

	Admin searchAdminDetailsToVerify(Admin admin) throws DatabaseErrorException;

	Parent searchParentDetailsToVerify(Parent prn) throws DatabaseErrorException;

	OBMember searchOBMemberDetailsToVerify(OBMember obm) throws DatabaseErrorException;
}
