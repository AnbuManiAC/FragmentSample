package com.example.recyclerview;

public class Todo {
    private String title;
    private boolean isChecked;

    public Todo(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
