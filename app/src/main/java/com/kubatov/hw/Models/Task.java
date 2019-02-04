package com.kubatov.hw.Models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {

    public int id;
    public String title;
    public String description;
    public Boolean isDone;
    public Date creationDate;
    public Date endDate;

    public Task(Date creationDate, int id, String title, String description, Date endDate, boolean isDone) {
        this.creationDate = creationDate;
        this.id = id;
        this.title = title;
        this.description = description;
        this.endDate = endDate;
        this.isDone = isDone;
    }

    public String strCreationDate() {
        return dateToString(creationDate);
    }

    public String strEndDate() {
        return dateToString(endDate);
    }

    private String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }
}
