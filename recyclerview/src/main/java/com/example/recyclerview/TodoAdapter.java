package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private ArrayList<Todo> todoList;

    public TodoAdapter(ArrayList<Todo> todoList){
        this.todoList = todoList;
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        public TodoViewHolder(View itemView){
            super(itemView);
            this.itemView = itemView;
        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        TextView tvTitle = (TextView) holder.itemView.findViewById(R.id.tvTitle);
        CheckBox cbDone = (CheckBox) holder.itemView.findViewById(R.id.cbDone);

        tvTitle.setText(todoList.get(position).getTitle());
        cbDone.setChecked(todoList.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }


}
