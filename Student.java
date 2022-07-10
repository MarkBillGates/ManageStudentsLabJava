/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.managestudent;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
class Student implements Serializable{
     private String code;
    //Name
    private String name;
    //Age
    private String date;
    //Place of residence
    private float point;

    public Student() {
    }

    public Student(String code, String name, String date, float point) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.point = point;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
}
