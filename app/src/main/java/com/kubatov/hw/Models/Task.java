package com.kubatov.hw.Models;

import java.util.Date;

public class Task {

    public String title;
    public String description;
    public Boolean isDone;
    public Date creationData;
    public Date endData;

    public Task(String title, String description){
        this.title = title;
        this.description = description;
    }

}
