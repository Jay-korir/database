package databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Execute {
    static Scanner scanner = new Scanner(System.in);
    static IStudentDB iStudentDB;
    static EmployeeRecord emp;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        emp = new EmployeeRecord();

        iStudentDB = new MysqlEmployee<EmployeeRecord>();
        iStudentDB = new MysqlEmployee<EmployeeAccount>();
        register();
        //System.out.println("successfully added a new employee");
       // registerAcc();
       // System.out.println("successfully added records of payment");
       // displayEmployees();
       // displayAccounts();
        //displayEmployee(5);
        //updateRecord();
       // deleteRecord(8);

    }
    public static void register() throws SQLException, ClassNotFoundException {

        EmployeeRecord e1 = new EmployeeRecord();

        System.out.print("enter id : ");
         e1.setId(scanner.nextInt());
             scanner.nextLine();
          //Scanner scanner1 = new Scanner(System.in);
        System.out.print("enter your name :");
        e1.setName(scanner.nextLine());

       System.out.print("enter age: ");
       e1.setAge(scanner.nextInt());

       MysqlEmployee<IEntity> msqlEmployee = new MysqlEmployee<>();

       e1.getTargetColumns().add(e1.getId());
       e1.getTargetColumns().add(e1.getName());
       e1.getTargetColumns().add(e1.getAge());
        String query = msqlEmployee.createInsertQuery(e1);
        System.out.println(query);
        msqlEmployee.executeQuery(query);
    }
    public static void registerAcc() throws SQLException, ClassNotFoundException {

        EmployeeAccount emp = new EmployeeAccount();

        System.out.print("enter id : ");
        emp.setId(scanner.nextInt());
        scanner.nextLine();
        //Scanner scanner1 = new Scanner(System.in);
        System.out.print("enter your name :");
        emp.setName(scanner.nextLine());

        System.out.print("enter salary: ");
        emp.setSalary(scanner.nextInt());

        MysqlEmployee<IEntity> msqlEmployee = new MysqlEmployee<>();

        emp.getTargetColumns().add(emp.getId());
        emp.getTargetColumns().add(emp.getName());
        emp.getTargetColumns().add(emp.getSalary());
        String query = msqlEmployee.createInsertQuery(emp);
        System.out.println(query);
        msqlEmployee.executeQuery(query);

    }
   public static  void displayEmployees() throws SQLException, ClassNotFoundException {

      ResultSet resultSet=  iStudentDB.getData(emp);


       while (resultSet.next()){
           EmployeeRecord e1 = new EmployeeRecord();
      e1.setId(resultSet.getInt("id"));
e1.setName(resultSet.getString("name"));
e1.setAge(resultSet.getInt("age"));

       System.out.println(e1);
       }
            }
    public  static  void displayAccounts() throws SQLException {
       EmployeeAccount  employeeAccounts = new EmployeeAccount();
       ResultSet rs = iStudentDB.getData(employeeAccounts);

         while (rs.next()){
             EmployeeAccount e2 = new EmployeeAccount();
             e2.setId(rs.getInt("id"));
             e2.setName(rs.getString("name"));
             e2.setSalary(rs.getInt("salary"));
             System.out.println(e2);
         }
    }
    /*
    public static void displayEmployee(int id) throws SQLException {
        System.out.println(iStudentDB.getEmployee(id));

    }

     */


    public  static  void deleteRecord(int id) throws SQLException {

        System.out.println(iStudentDB.deleteEmployee(id));

       System.out.println("successfully deleted");
    }
    /*
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

     */
    }

