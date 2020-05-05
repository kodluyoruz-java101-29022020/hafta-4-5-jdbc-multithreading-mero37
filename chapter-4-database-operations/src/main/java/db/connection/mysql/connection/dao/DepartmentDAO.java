package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;
import db.connection.mysql.connection.model.Employee;


public class DepartmentDAO {

	private static final Logger logger = Logger.getLogger(DepartmentDAO.class);

	
	public List<Department> getAll() {
		
		List<Department> departments = new ArrayList<Department>();
		
		// Tüm departman listesini çeken SQL komutunu aşağıdaki satıra yazınız.
		ResultSet resultSet = DbSQLQuery.select("Select * from departments");
		
		try {
			if(resultSet == null) {
				return departments;
			}
			
			while(resultSet.next()) {
				departments.add(createDepartment(resultSet));
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return departments;
	}
	
	private Department createDepartment(ResultSet resultSet) throws SQLException {
		
		Department department = new Department();
		department.setDeptNo("dept_no");
		department.setName("dept_name");
		return department;
	
	}
	
}
