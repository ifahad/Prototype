package com.example.prototype.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prototype.AcademicRequest;
import com.example.prototype.CheckRequest;
import com.example.prototype.Model.GetNewRq4AD;
import com.example.prototype.R;

import java.util.ArrayList;

/**
 * Created by LEnovo on 05/05/17.
 */

public class newrequestAdpter extends RecyclerView.Adapter<newrequestAdpter.customholder> {
    ArrayList<GetNewRq4AD> items;
    Context context;

    public newrequestAdpter(ArrayList<GetNewRq4AD> items,Context context) {
        this.items = items;
        this.context=context;
    }

    @Override
    public customholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_request,parent,false);
        customholder holder=new customholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(customholder holder, final int position) {
        holder.std_id.setText(items.get(position).getStudent_ID());
        holder.Code.setText(items.get(position).getC_code());
        holder.Opertion.setText(items.get(position).getOperation_Type());

        //onclick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendInfo=new Intent(context, AcademicRequest.class);
                sendInfo.putExtra("opertion",items.get(position).getOperation_Type());
                sendInfo.putExtra("id",items.get(position).getStudent_ID());
                sendInfo.putExtra("code",items.get(position).getC_code());
                sendInfo.putExtra("gpa",items.get(position).getGPA());
                sendInfo.putExtra("section",items.get(position).getSection());

                sendInfo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(sendInfo);

            }
        });
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
