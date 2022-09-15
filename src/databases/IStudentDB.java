package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IStudentDB<T extends IEntity> {
    String createInsertQuery(T t);

    List<T>  getData(T t) throws SQLException;
   // List<EmployeeRecord> getEmployees() throws SQLException;
  //  EmployeeRecord getEmployee(int id) throws SQLException;
    boolean executeQuery(String query) throws SQLException;
    ResultSet executeReadQuery(String query) throws SQLException;

    String updateQuery(EmployeeRecord employeeRecord) throws  SQLException;

    boolean deleteEmployee(int id) throws SQLException;


}

