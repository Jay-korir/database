package databases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
   /* public static void main(String[] args) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        String today = LocalDate.now().format(myFormatObj);

        Date date = new Date();
        System.out.println(date);
        System.out.println(today);
    }
}*/
   public static void main(String args[])throws Exception{
       Class.forName("com.mysql.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");

       PreparedStatement ps=con.prepareStatement("insert into payment values(?,?,?)");

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

       do{
           System.out.println("enter id:");
           int id=Integer.parseInt(br.readLine());
           System.out.println("enter name:");
           String name=br.readLine();
           System.out.println("enter salary:");
           float salary=Float.parseFloat(br.readLine());

           ps.setInt(1,id);
           ps.setString(2,name);
           ps.setFloat(3,salary);
           int i=ps.executeUpdate();
           System.out.println(i+" records affected");

           System.out.println("Do you want to continue: y/n");
           String s=br.readLine();
           if(s.startsWith("n")){
               break;
           }
       }while(true);

       con.close();
   }}
