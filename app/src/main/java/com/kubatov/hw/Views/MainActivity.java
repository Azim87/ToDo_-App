package com.kubatov.hw.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kubatov.hw.Adapters.TasksAdapter;
import com.kubatov.hw.Models.Task;
import com.kubatov.hw.R;
import com.kubatov.hw.interfaces.IOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnClickListener {

    RecyclerView mainRecycker;
    TasksAdapter tasksAdapter;

    List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTasks();
        initRecycler();

    }
    void initTasks(){
        tasks = new ArrayList<>();
        tasks.add(new Task("01-01-2019",0,"task1", "very important task","02-01-2019"));
        tasks.add(new Task("02-02-2020",1,"task2", "not very important task","03-02-2020"));
        tasks.add(new Task("03-01-2021",2,"task3", "very very important task","04-01-2021"));

    }

    void initRecycler(){
        mainRecycker = findViewById(R.id.main_recycler);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        tasksAdapter = new TasksAdapter(tasks, this);

        mainRecycker.setLayoutManager(LayoutManager);
        mainRecycker.setAdapter(tasksAdapter);
    }

    @Override
    public void onClick(int taskId) {

        Task task = null;

        for (int i=0; i<tasks.size(); i++){
            if (tasks.get(i).id == taskId){
                task = tasks.get(i);
                break;
            }else {
                Log.d("blya", "not found");

            }


        }
        if (task ==null){
            return;
        }
        Intent intent = new Intent(this, TaskDetails.class);

        intent.putExtra("task_title", task.title);
        intent.putExtra("task_description", task.description);
        intent.putExtra("create_data", task.creationDate);
        intent.putExtra("end_data", task.endDate);


        startActivity(intent);
    }
}
