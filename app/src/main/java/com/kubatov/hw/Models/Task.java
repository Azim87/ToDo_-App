package com.kubatov.hw.Models;

import java.util.Date;

public class Task {

    public int id;
    public String title;
    public String description;
    public Boolean isDone;
    public String creationDate;
    public String endDate;

    public Task(String creationDate, int id, String title, String description, String endDate){
        this.creationDate = creationDate;
        this.id = id;
        this.title = title;
        this.description = description;
        this.endDate = endDate;
    }

}
