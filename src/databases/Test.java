package databases;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("hello");


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "");
            // System.out.println( DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",""));

        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from payment");

//getting the record of 3rd row
        rs.absolute(3);
        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
con.close();
        //PreparedStatement stmt1=con.prepareStatement("update employees set name=? where id=?");
            // stmt1.setString(1,"Sonoo");
            // stmt1.setInt(2,101);
            // int i=stmt1.executeUpdate();
            //  ResultSet rs=stmt.executeQuery("select * from employees");
            /// stmt.executeUpdate("insert into employees values(5,'george',45)");
            // int result = stmt.executeUpdate("delete from employees where id =5");
            //System.out.println(result +" records affected");
            //  rs.updateRow();
           /* DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("UserName: " + dbmd.getUserName());
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());*/


    }
}

           /* while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));

           // System.out.println(rs.getString("name"));
            rs.absolute(3);
            System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
/*
class RS{
public static void main(String args[])throws Exception{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

PreparedStatement ps=con.prepareStatement("insert into emp130 values(?,?,?)");

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
 */