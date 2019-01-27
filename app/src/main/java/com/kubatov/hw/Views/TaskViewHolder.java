package com.kubatov.hw.Views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kubatov.hw.Models.Task;
import com.kubatov.hw.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    TextView tvDescription;

    public TaskViewHolder(View v){
        super(v);
        tvTitle = v.findViewById(R.id.vh_task_title);
        tvDescription = v.findViewById(R.id.vh_tast_desc);
    }

    public void onBind(Task task){
        tvTitle.setText(task.title);
        tvDescription.setText(task.description);
    }

}