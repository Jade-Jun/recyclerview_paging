package com.sy.example.recyclerview_paging.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sy.example.recyclerview_paging.R;

import java.util.ArrayList;

/**
 * Created by SuYa on 2017. 1. 23..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    int res_id;

    public RecyclerAdapter(Context context, int res_id, ArrayList<String> arrayList) {
        this.context = context;
        this.res_id = res_id;
        this.arrayList = arrayList;
    }

    public void addAllItems(ArrayList<String> items) {
        this.arrayList.clear();
        if (null != items) {
            this.arrayList = items;
        }
    }

    public void addItems(ArrayList<String> items) {
        if (null != items) {
            this.arrayList.addAll(items);
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(this.res_id, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String item = this.arrayList.get(position);
        holder.textView.setText(item);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;


        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.title);
        }
    }

}
