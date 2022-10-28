package com.example.mybackend;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private ArrayList<Subject> subjects;
    private SubjectAdapter     adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjects = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listSubjectView);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Snackbar.make(parentView, subjects.get(position).getName() + " => " + subjects.get(position).getFacultyName(), Snackbar.LENGTH_LONG).show();
//            }
//        });

        Toast toast =
                Toast.makeText(getApplicationContext(), R.string.string_click_to_load, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ProgressDialog dialog;
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle(getString(R.string.string_getting_json_title));
            dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();

            //Creating an object of our api interface
            SubjectsApi api = SubjectsApp.getSubjectsApi();

            Call<Subjects> call = api.getSubjects();

            call.enqueue(new Callback<Subjects>() {
                @Override
                public void onResponse(Call<Subjects> call, Response<Subjects> response) {
//                    Dismiss Dialog
                    dialog.dismiss();

                    if (response.isSuccessful()) {

                        subjects = (ArrayList<Subject>) response.body().getSubjects();
                        adapter = new SubjectAdapter(MainActivity.this, subjects);
                        listView.setAdapter(adapter);

                    } else {
                        Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Subjects> call, Throwable t) {
                    dialog.dismiss();
                }
            });

        } else {
            Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();
        }

    }
}