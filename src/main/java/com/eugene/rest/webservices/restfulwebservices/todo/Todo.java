package com.eugene.rest.webservices.restfulwebservices.todo;

import java.util.Date;
import java.util.Objects;

public class Todo {
    private long id;
    private String userName;
    private String description;
    private Date targetDate;
    private boolean isCompleted;

    protected Todo(){}

    public Todo(long id, String userName, String description, Date targetDate, boolean isCompleted) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.isCompleted = isCompleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
