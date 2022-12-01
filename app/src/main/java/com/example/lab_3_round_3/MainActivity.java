package com.example.lab_3_round_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listSubjectView);

        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID()
                .enqueue(new Callback<ArrayList<Subject>>() {
                    @Override
                    public void onResponse(@NonNull Call<ArrayList<Subject>> call, @NonNull Response<ArrayList<Subject>> response) {
                        ArrayList<Subject> subjects = response.body();
                        System.out.println("------------------------");
                        System.out.println(response.body());
                        SubjectAdapter subjectAdapter = new SubjectAdapter(MainActivity.this, R.layout.layout_row_view, subjects);
                        listView.setAdapter(subjectAdapter);
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArrayList<Subject>> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
