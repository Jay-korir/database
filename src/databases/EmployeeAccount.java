package databases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeAccount extends IEntity {

    private  int id;
    private String name;

    private  Integer salary;

    static String[]  col = {"id", "name","salary"};

    static String tableName = "payment";

    static List<String> columns = new ArrayList<>(Arrays.asList(col));

    public EmployeeAccount() {
        super(columns, tableName);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
