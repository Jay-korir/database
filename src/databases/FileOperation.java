package databases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileOperation {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");

            PreparedStatement ps = con.prepareStatement("insert into fileTable values(?,?)");

            File f = new File("E:\\originalwargame.txt");
            FileReader fr = new FileReader(f);

            ps.setInt(1,101);
            ps.setCharacterStream(2,fr,(int)f.length());

            int i = ps.executeUpdate();
            System.out.println(i + "records affected");
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
