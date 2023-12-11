package ua.edu.ucu.apps.singleton;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private int age;

    public void save() {
        DBConnection dbConnection = DBConnection.getInstance();
        String query = String.format("insert into user (email, name, age) values ('%s', '%s', %d);",
                email, name, age);
        dbConnection.executeQuery(query);
    }
}
