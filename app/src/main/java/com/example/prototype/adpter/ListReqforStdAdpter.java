package com.example.prototype.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prototype.Model.Message;
import com.example.prototype.R;

import java.util.ArrayList;

/**
 * Created by LEnovo on 06/05/17.
 */

public class ListReqforStdAdpter extends RecyclerView.Adapter<ListReqforStdAdpter.customholder> {
    ArrayList<Message> items;

    public ListReqforStdAdpter(ArrayList<Message> items) {
        this.items = items;
    }

    @Override
    public customholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_request,parent,false);
        customholder holder=new customholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(customholder holder, int position) {
        holder.Code.setText(items.get(position).getMessage());
        holder.std_id.setText("");
        holder.Opertion.setText("");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class customholder extends RecyclerView.ViewHolder{

        TextView std_id,Code,Opertion;

        public customholder(View itemView) {
            super(itemView);
            std_id= (TextView) itemView.findViewById(R.id.std_id);
            Code= (TextView) itemView.findViewById(R.id.code_row);
            Opertion= (TextView) itemView.findViewById(R.id.opertion_row);
        }
    }
}
