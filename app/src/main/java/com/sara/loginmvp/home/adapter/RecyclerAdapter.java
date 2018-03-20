package com.sara.loginmvp.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sara.loginmvp.R;
import com.sara.loginmvp.home.model.Data;

import java.util.ArrayList;

/**
 * Created by sara on 3/19/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

    ArrayList<Data> dataArrayList;
    Context context;

    public RecyclerAdapter(ArrayList<Data> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.name.setText(dataArrayList.get(position).getName());
        holder.job.setText(dataArrayList.get(position).getJob());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        private TextView name, job;

        public ListViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.itemName);
            job = itemView.findViewById(R.id.itemJob);

        }
    }
}