package com.arobs.internship.library.model_jdbc;

import com.arobs.internship.library.entity.helper.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(Employee.class);

    private int id;
    private String name;
    private RoleType role;
    private String password;
    private String email;

    public Employee() {
    }

    public Employee(String name, RoleType role, String password, String email) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public String getRole() {
        if (role == RoleType.ADMIN) {
            return "ADMIN";
        } else return "REGULAR";
    }

    public void setRole(String role) {
        if (role.equals("ADMIN")) {
            this.role = RoleType.ADMIN;
        } else this.role = RoleType.REGULAR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
