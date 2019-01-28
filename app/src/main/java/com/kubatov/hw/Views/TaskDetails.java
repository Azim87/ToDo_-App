package com.kubatov.hw.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kubatov.hw.R;

public class TaskDetails extends AppCompatActivity {
    TextView tvTitle;
    TextView tvDescription;
    TextView tvCreationDate;
    TextView tvEndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        initViews();

    }

    void initViews(){
        tvTitle = findViewById(R.id.task_Title);
        tvDescription = findViewById(R.id.task_Description);
        tvCreationDate = findViewById(R.id.creation_date);
        tvEndDate = findViewById(R.id.end_date);
    }
}
