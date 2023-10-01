package com.spring.boot.security.management.common;

public class MyConstantScreen {
    
    // common message
    public static final String REDIRECT		= "redirect:/";
    public static final String SUCCESS		= "common/success";
    public static final String ERROR		= "common/error";
    
    // Employee screen
    public static String EMPLOYEE_LIST		= "pages/users/employee/index";
    public static String EMPLOYEE_ADD		= "pages/users/employee/add";
    public static String EMPLOYEE_EDIT		= "pages/users/employee/edit";
    
    public static String LOGIN			= "pages/security/login";


    // error area
    public static String ER_403         = "error/403";

    //admin area
    public  static  String AD_HOME          = "pages/admin/index";

    // manager area
    public  static  String MN_HOME          = "pages/manager/index";


    // General admin-manager
    public static String INS_INDEX           = "pages/general-admin-manager/instructor/index";
    public static String INS_ADD             = "pages/general-admin-manager/instructor/add";

    public static String COURSE_INDEX        = "pages/general-admin-manager/course/index";
    public static String COURSE_ADD            = "pages/general-admin-manager/course/add";

}
