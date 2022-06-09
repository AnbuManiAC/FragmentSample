package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Todo> todoList;
    RecyclerView recyclerView;
    Button addTodo;
    EditText newTodoTitle;

    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Notes App");
        todoList = new ArrayList<>();
        recyclerView = findViewById(R.id.todo);
        newTodoTitle = findViewById(R.id.etTodo);
        addTodo = findViewById(R.id.addTodo);

        initList();
        setAdapter();

        addTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = newTodoTitle.getText().toString();
                Todo newTodo = new Todo(title, false);
                todoList.add(newTodo);
            }
        });
    }

    private void setAdapter() {
        todoAdapter = new TodoAdapter(todoList);
        recyclerView.setAdapter(todoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void initList() {
        todoList.add(new Todo("Learn View", false));
        todoList.add(new Todo("Learn ViewGroup", false));
        todoList.add(new Todo("Learn Toolbar", false));
        todoList.add(new Todo("Learn NavBar", false));
        todoList.add(new Todo("Learn Layouts", false));
        todoList.add(new Todo("Learn AppBar", false));
        todoList.add(new Todo("Learn StatusBar", false));
        todoList.add(new Todo("Learn Menu", false));
        todoList.add(new Todo("Learn Fragment", false));
        todoList.add(new Todo("Learn ViewModel", false));
        todoList.add(new Todo("Learn SharedViewModel", false));
        todoList.add(new Todo("Learn CoordinatorLayout", false));
        todoList.add(new Todo("Learn Transition", false));
        todoList.add(new Todo("Learn Handler", false));
    }
}