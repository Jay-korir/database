package databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlEmployee<T extends IEntity> implements IStudentDB<T>{

    Statement statement;
   // private ResultSet resultSet;
    public MysqlEmployee () throws SQLException, ClassNotFoundException {
        this.openConnection();
    }
    private Connection connection;
    private   boolean openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "");
        System.out.println("success");
        return true;
    }

   // public String createInsertQuery(EmployeeRecord emp) {
        // String test = ("insert into employees(id,name,age) values(" + emp.getId() + ", '"+ emp.getName() +"', '"+ emp.getAge()+"')';";
     //   String test = ("insert into employees(id,name,age) values(\""+ emp.getId() +"\" ,\""+ emp.getName() +"\" , \"" + emp.getAge()+ "\" )");
        // System.out.println(test);
      //  return test;

    static    boolean isFirstColumn = true;

    @Override
    public String createInsertQuery(T t) {
        StringBuilder stringBuilder = new StringBuilder("INSERT into ");
        stringBuilder.append(t.getTableName());
        stringBuilder.append("(");
/*
        List<String> targetColumns = new ArrayList<>();
        for (String column : t.getColumns()){
            if (!isFirstColumn)
                stringBuilder.append(",");
            stringBuilder.append("'").append(column).append("'");
           targetColumns.add(column);
            isFirstColumn = false;

        }*/
        stringBuilder.append(")").append("  values").append("(");



            for (Object object : t.getTargetColumns()){
                if (!isFirstColumn)
                    stringBuilder.append(",");
                stringBuilder.append("'").append(object).append("'");
                isFirstColumn = false;
            }

        stringBuilder.append(")");
       // System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    static  ResultSet rs;
    @Override
    public ResultSet getData(T t) throws SQLException {


        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(t.getTableName());
        System.out.println("table =="+t.getTableName());
        System.out.println("query =="+stringBuilder);
        rs = executeReadQuery(stringBuilder.toString());

        return rs;
    }
/*
   @Override
    public  List<?> getEmployees() throws SQLException {

        ArrayList<EmployeeRecord> employees = new ArrayList<>();
        String query = "select * from employees";
         resultSet = executeReadQuery(query);

        while (resultSet.next()){
            EmployeeRecord  employeeRecord = new EmployeeRecord();
            employeeRecord.setId(resultSet.getInt("id"));
            employeeRecord.setName(resultSet.getString("name"));
            employeeRecord.setAge(resultSet.getInt("age"));
        employees.add(employeeRecord);
        }
        return employees;
    }


    @Override
    public EmployeeRecord getEmployee(int id) throws SQLException {
        String query = "SELECT * from employees WHERE id = " + id +";";
resultSet = executeReadQuery(query);
EmployeeRecord emp = new EmployeeRecord();
while (resultSet.next()){
    emp.setId(resultSet.getInt("id"));
    emp.setName(resultSet.getString("name"));
    emp.setAge(resultSet.getInt("age"));
}
        return emp;
    }*/

    @Override
    public boolean executeQuery(String query) throws SQLException {
        try {

             statement = connection.createStatement();
            statement.execute(query);
            System.out.println("successfully");
            return  true;
        }catch (SQLException e){
            System.out.println("an error failed");
            return false;
        }
    }



    @Override
    public ResultSet executeReadQuery(String query) throws SQLException {

         statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;

    }

    @Override
    public String updateQuery(EmployeeRecord emp) throws SQLException {
       // String query =("UPDATE `employees` SET `ID`='[value-1]',`NAME`='[value-2]',`AGE`='[value-3]' WHERE 1");
        return "UPDATE  employees SET name = \""+ emp.getName() +"\" ,age = \"" + emp.getAge()+ "\"   WHERE id  = \"" + emp.getId() +"\"  ";
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
     String query ="DELETE From employees WHERE id =" +  id;
     executeQuery(query);
     return  true;


    }
}

