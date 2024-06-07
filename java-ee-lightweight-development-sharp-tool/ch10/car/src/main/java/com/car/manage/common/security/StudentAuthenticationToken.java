package com.car.manage.common.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * token.
 */
public class StudentAuthenticationToken extends UsernamePasswordToken {

    private String studentNumber;

    /**
     * student token.
     *
     * @param username      username
     * @param password      password
     * @param studentNumber studentNumber
     */
    public StudentAuthenticationToken(String username, String password, String studentNumber) {
        super(username, password);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}
