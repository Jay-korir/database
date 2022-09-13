package databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Execute {
    static Scanner scanner = new Scanner(System.in);
    static IStudentDB iStudentDB;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         // register();
        iStudentDB = new MysqlEmployee();
       // displayEmployees();
        //displayEmployee(5);
        //updateRecord();
        deleteRecord(90);

    }
    public static void register() throws SQLException, ClassNotFoundException {
         //Scanner scanner = new Scanner(System.in);
        EmployeeRecord e1 = new EmployeeRecord();

        System.out.print("enter id : ");
         e1.setId(scanner.nextInt());
          Scanner scanner1 = new Scanner(System.in);
        System.out.print("enter your name :");
        e1.setName(scanner1.nextLine());

       System.out.print("enter age: ");
       e1.setAge(scanner.nextInt());

        MysqlEmployee msqlEmployee = new MysqlEmployee();
        String query = msqlEmployee.createInsertQuery(e1);
        //msqlEmployee.createInsertQuery(e1);
        msqlEmployee.executeQuery(query);
    }
    public static  void displayEmployees() throws SQLException, ClassNotFoundException {
        List<EmployeeRecord> employeeRecordList = iStudentDB.getEmployees();
        for (EmployeeRecord employeeRecord : employeeRecordList)
            System.out.println(employeeRecord);

    }
    public static void displayEmployee(int id) throws SQLException {
        System.out.println(iStudentDB.getEmployee(id));

    }
    public  static  void deleteRecord(int id) throws SQLException {

        System.out.println(iStudentDB.deleteEmployee(id));
       // System.out.println(query);
       // iStudentDB.executeQuery(query);
       // System.out.println("successfully deleted");
    }
    public static void updateRecord(){

        try {
            System.out.print("enter ID of employees to update : ");
            EmployeeRecord employeeRecord = iStudentDB.getEmployee(scanner.nextInt());

           scanner = new Scanner(System.in);
            System.out.print("Enter the name : ");
            employeeRecord.setName(scanner.nextLine());
            System.out.print("Enter age : ");
            employeeRecord.setAge(scanner.nextInt());

            //System.out.println(employeeRecord);
            String query = iStudentDB.updateQuery(employeeRecord);
           // System.out.println(query);
            iStudentDB.executeQuery(query);

        } catch (SQLException e) {
            System.out.println("not updated");
            throw new RuntimeException(e);

        }
    }
}
