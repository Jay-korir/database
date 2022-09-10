package databases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    public static void main(String[] args) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        String today = LocalDate.now().format(myFormatObj);

        Date date = new Date();
        System.out.println(date);
        System.out.println(today);
    }
}
