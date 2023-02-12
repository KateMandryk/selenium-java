package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String numberOfUser;
    private String name;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public User() {
    }

}