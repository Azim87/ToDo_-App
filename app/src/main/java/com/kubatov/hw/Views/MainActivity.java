package com.kubatov.hw.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kubatov.hw.Adapters.TasksAdapter;
import com.kubatov.hw.Models.Task;
import com.kubatov.hw.R;
import com.kubatov.hw.interfaces.IOnClickListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnClickListener {

    RecyclerView mainRecycker;
    TasksAdapter tasksAdapter;
    Button addNewTaskBtn;

    List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTasks();
        initRecycler();
        initButton();


    }
    void initTasks() {
        tasks = new ArrayList<>();

            tasks.add(new Task(new Date(),
                    0, "task1", "very important task",new Date(2019, 02,13), false ));
            tasks.add(new Task(new Date(),
                    1,"task2", "not very important task", new Date(2019, 03,13), false));
            tasks.add(new Task(new Date(),
                    2,"task3", "very very important task", new Date(2019,04,13), false));

    }

    void initRecycler(){
        mainRecycker = findViewById(R.id.main_recycler);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        tasksAdapter = new TasksAdapter(tasks, this);

        mainRecycker.setLayoutManager(LayoutManager);
        mainRecycker.setAdapter(tasksAdapter);
    }

    void initButton(){
        addNewTaskBtn = findViewById(R.id.add_new_task);
        addNewTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskCreationActivity.class);
                startActivityForResult(intent, 1);
            }
        });
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
        intent.putExtra("task", task);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                Task task = (Task) data.getSerializableExtra("task");
                tasks.add(task);
                tasksAdapter.notifyDataSetChanged();
            }

        }

    }
}
