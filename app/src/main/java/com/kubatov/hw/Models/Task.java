package com.kubatov.hw.Models;

import java.util.Date;

public class Task {

    public int id;
    public String title;
    public String description;
    public Boolean isDone;
    public Date creationDate;
    public Date endDate;

    public Task(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

}
