package com.kubatov.hw.Views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kubatov.hw.Models.Task;
import com.kubatov.hw.R;
import com.kubatov.hw.interfaces.IOnClickListener;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    TextView tvDescription;
    IOnClickListener listener;

    public TaskViewHolder(View v, final IOnClickListener listener){
        super(v);
        this.listener = listener;
        tvTitle = v.findViewById(R.id.vh_task_title);
        tvDescription = v.findViewById(R.id.vh_task_description);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });

    }

    public void onBind(Task task){
        tvTitle.setText(task.title);
        tvDescription.setText(task.description);
    }

}