package com.example.user.samplelog.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.samplelog.Interface.ItemClickListener;
import com.example.user.samplelog.R;

/**
 * Created by USER on 5/5/2018.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtorderid,txtorderstatus,txtorderphone,txtorderaddress;

    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);
        txtorderaddress=(TextView)itemView.findViewById(R.id.order_address);
        txtorderid=(TextView)itemView.findViewById(R.id.order_id);
        txtorderstatus=(TextView)itemView.findViewById(R.id.order_status);
        txtorderphone=(TextView)itemView.findViewById(R.id.order_phone);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}
