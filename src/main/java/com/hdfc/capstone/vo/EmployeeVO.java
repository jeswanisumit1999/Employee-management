package com.hdfc.capstone.vo;
import java.sql.*;
import java.time.LocalDate;
import com.hdfc.capstone.utils.EncryptionUtil;
/**
 * 
 * @author Bharath Kumar
 *
 * @CreatedDate 22-Apr-2023
 */
public class EmployeeVO {
	
	private long employeeId;
	private String employeeName;
	private Date dateOfBirth;
	


	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = EncryptionUtil.encrypt(dateOfBirth.toString());
		this.dateOfBirth=dateOfBirth;
	}
	
	public EmployeeVO getEmployeeById(long employeeId) {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		long id=employeeId;
        String name;
       Date birthdate;
       EmployeeVO obj= new EmployeeVO();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?user=root&password=volkswagen");
			pst = con.prepareStatement("select * from employee where employee_id=?;");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				name = rs.getString("employee_name");
				birthdate = rs.getDate("date_of_birth");
				
				obj.setEmployeeId(employeeId);
				obj.setEmployeeName(name);
				obj.setDateOfBirth(birthdate);
				
//				System.out.println(employeeId);
//				System.out.println(name);
//				System.out.println(birthdate);
//				
				
			}
			
		} 
		
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		return obj;
	}
	

}