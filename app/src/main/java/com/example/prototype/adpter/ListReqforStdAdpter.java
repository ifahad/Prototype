package com.example.prototype.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prototype.Model.GetListReq4Std;
import com.example.prototype.Model.Message;
import com.example.prototype.R;

import java.util.ArrayList;

/**
 * Created by LEnovo on 06/05/17.
 */

public class ListReqforStdAdpter extends RecyclerView.Adapter<ListReqforStdAdpter.customholder> {
    ArrayList<GetListReq4Std> items3;
    Context context;

    public ListReqforStdAdpter(ArrayList<GetListReq4Std> items, Context context) {
        this.items3 = items;
        this.context=context;
    }

    @Override
    public customholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_request,parent,false);
        customholder holder3=new customholder(row);
        return holder3;
    }

    @Override
    public void onBindViewHolder(customholder holder3, int position3) {

        holder3.std_id.setText(items3.get(position3).getOperation_Type());
        holder3.Code.setText(items3.get(position3).getC_code());
        if (items3.get(position3).getStatus()==null) {

            holder3.Opertion.setText("pending");
        } else {
            holder3.Opertion.setText(items3.get(position3).getStatus());
        }
    }
    @Override
    public int getItemCount() {
        return items3.size();
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
