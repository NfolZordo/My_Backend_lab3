package com.example.lab_3_round_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SubjectAdapter  extends ArrayAdapter<Subject> {
    private LayoutInflater inflater;
    private int layout;
    private List<Subject> subjects;

    public SubjectAdapter(@NonNull Context context, int resource, List<Subject> subjects) {
        super(context, resource, subjects);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.subjects = subjects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewFacultyName = view.findViewById(R.id.textViewFacultyName);
        TextView textViewTeacherName = view.findViewById(R.id.textViewTeacherName);

        Subject subject = subjects.get(position);

        textViewName.setText(subject.getName());
        textViewFacultyName.setText(subject.getFacultyName());
        textViewTeacherName.setText(subject.getTeacherName());

        return view;
    }


}
