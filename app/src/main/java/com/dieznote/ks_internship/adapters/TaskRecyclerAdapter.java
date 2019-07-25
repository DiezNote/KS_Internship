package com.dieznote.ks_internship.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dieznote.ks_internship.Listeners.OnTaskRecyclerItemClickListener;
import com.dieznote.ks_internship.R;
import com.dieznote.ks_internship.models.Person;

import java.util.ArrayList;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.ViewHolder> {

    private ArrayList<Person> persons;
    private OnTaskRecyclerItemClickListener listener;
    private Context ctx;

    public TaskRecyclerAdapter(ArrayList<Person> persons, Context ctx) {
        this.persons = persons;
        this.ctx = ctx;
    }

    @Override
    public TaskRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(view, viewHolder.getAdapterPosition());
                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskRecyclerAdapter.ViewHolder holder, int position) {
        holder.itemTitle.setText(persons.get(position).getFirstName() + " " + persons.get(position).getLastName());

        if (position == persons.size() - 1) {
            holder.divider.setVisibility(View.INVISIBLE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle;
        View divider;

        public ViewHolder(View itemView) {
            super(itemView);

            Log.e("TaskRecyclerAdapter", "finding views!");

            itemTitle = itemView.findViewById(R.id.item_task_check);
            divider = itemView.findViewById(R.id.divider);

        }
    }

    public void setListener(OnTaskRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    public ArrayList<Person> getItems() {
        return persons;
    }

    public void setItems(ArrayList<Person> persons) {
        this.persons = persons;
    }
}
