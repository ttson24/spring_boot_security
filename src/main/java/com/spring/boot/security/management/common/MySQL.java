package com.spring.boot.security.management.common;

public class MySQL {
    public static String findUserWithUserId="SELECT user_id, pw, active FROM members WHERE user_id=?";
    public static String findRoleWithUsername="SELECT user_id, role FROM roles WHERE user_id=?";
}
