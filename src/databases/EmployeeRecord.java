package databases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeRecord extends IEntity {
    private  int id;
    private  String name;

    private    int age;

    static   String tableName = "employees";

  static   String[] column = {"id", "name","age"};

  static    List<String> columns = new ArrayList<>(Arrays.asList(column));;


    public EmployeeRecord() {
        super(columns,tableName);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
