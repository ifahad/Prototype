package com.example.prototype.Model;

/**
 * Created by LEnovo on 05/05/17.
 */

public class GetNewRq4AD {
    private String Student_ID;
    private String C_code;
    private  String Operation_Type;
    private String Reason;
    private String Section;
    private String Number;


    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

//    public String getGPA() {
//        return GPA;
//    }
//
//    public void setGPA(String GPA) {
//        this.GPA = GPA;
//    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getC_code() {
        return C_code;
    }

    public void setC_code(String c_code) {
        C_code = c_code;
    }

    public String getOperation_Type() {
        return Operation_Type;
    }

    public void setOperation_Type(String operation_Type) {
        Operation_Type = operation_Type;
    }
}
