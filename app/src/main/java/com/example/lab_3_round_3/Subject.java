package com.example.lab_3_round_3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("facultyName")
    @Expose
    private String facultyName;
    @SerializedName("teacherName")
    @Expose
    private String teacherName;

    public String getName() {
        return name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}