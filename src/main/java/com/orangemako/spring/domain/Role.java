package com.orangemako.spring.domain;

/**
 * Describes user roles.
 *
 * @author Kevin Leong
 */
public enum Role {

    ADMIN(1000), USER(1);

    int accessLevel = 0;

    Role(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
