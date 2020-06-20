package com.anuj.retrofitsample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anuj.retrofitsample.Items.Data;
import com.anuj.retrofitsample.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<Data> data;
    private Context context;
    private LayoutInflater layoutInflater;
    private int layoutResource;

    public RecyclerAdapter(List<Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data d = data.get(position);
        int coun = d.getCount();
        holder.itemName.setText(d.getName());
        holder.count.setText(Integer.toString(coun));
        holder.desc.setText(d.getDesc());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView desc;
        TextView count;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemName = itemView.findViewById(R.id.itemName);
            this.desc = itemView.findViewById(R.id.itemDesc);
            this.count = itemView.findViewById(R.id.itemCount);

        }
    }
}
