package com.kubatov.hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kubatov.hw.Adapters.TasksAdapter;
import com.kubatov.hw.Models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        tasks.add(new Task("task1", "very important task"));
        tasks.add(new Task("task2", "not very important task"));
        tasks.add(new Task("task3", "very very important task"));


    }

    void initRecycler(){
        mainRecycker = findViewById(R.id.main_recycler);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        tasksAdapter = new TasksAdapter(tasks);

        mainRecycker.setLayoutManager(LayoutManager);
        mainRecycker.setAdapter(tasksAdapter);
    }
}
