package com.example.mybackend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Subjects {
    List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
