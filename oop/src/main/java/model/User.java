package model;

import java.time.LocalDate;

public abstract class User {

    private String name;
    private LocalDate birthday;
    private Role role;

    public User(String name, LocalDate birthday, Role role) {
        this.name = name;
        this.birthday = birthday;
        this.role = role;
    }

    public enum Role {
        PUPIL,
        TEACHER,
        PARENT,
        ADMINISTRATOR
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Role getRole() {
        return role;
    }
}
