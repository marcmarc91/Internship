package model;

import utils.RoleType;

public class User {
    private String name;
    private String password;
    private RoleType roleType;

    public User(String name, String password, RoleType roleType) {
        this.name = name;
        this.password = password;
        this.roleType = roleType;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
