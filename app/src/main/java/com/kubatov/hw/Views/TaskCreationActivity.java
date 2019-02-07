package com.kubatov.hw.Views;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import com.kubatov.hw.Models.Task;
import com.kubatov.hw.R;
import java.util.Calendar;
import java.util.Date;


public class TaskCreationActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etDescription;
    CheckBox cBisDone;
    Button bendDate;
    Button done;

    String title;
    String description;
    Boolean isDone;
    Date endDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        initTitle();
        initDescription();
        initIsDone();
        initEndDate();
        initDone();

        etTitle.getText();
    }

    void initTitle(){
        etTitle = findViewById(R.id.edit_title);

        etTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("fjfjfj", "--------------------------");
                title = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void initDescription(){
        etDescription = findViewById(R.id.edit_description);

        etDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                description = s.toString();
                Log.d("ololo", "des");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void initIsDone(){
            cBisDone = findViewById(R.id.edit_isDone);
            cBisDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    isDone = isChecked;
                }
            });
    }

    void initEndDate(){
            bendDate = findViewById(R.id.edit_end_date);

            bendDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            TaskCreationActivity.this, R.style.AppTheme,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view,
                                                      int year,
                                                      int month,
                                                      int dayOfMonth) {
                                    Log.d("hehehe", "date: " +
                                            year + " " +
                                            month + " " +
                                            dayOfMonth);

                                }

                            },
                            year,
                            month,
                            day

                    );
                 datePickerDialog.show();
                }
            });
    }

    void initDone(){
        done = findViewById(R.id.edit_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task(new Date(),100, title, description, endDate, false);
                Intent intent = new Intent();
                intent.putExtra("task", task);
                Log.d("lololo", "this");

                TaskCreationActivity.this.setResult(RESULT_OK, intent);
                TaskCreationActivity.this.finish();

            }
        });
    }



}
