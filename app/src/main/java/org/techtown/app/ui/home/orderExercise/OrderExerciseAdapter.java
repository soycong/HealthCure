package org.techtown.app.ui.home.orderExercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.app.R;

import java.util.ArrayList;

public class OrderExerciseAdapter extends RecyclerView.Adapter<OrderExerciseAdapter.ViewHolder> implements OnOrderExerciseClickListener {
    ArrayList<OrderExercise> items = new ArrayList<OrderExercise>();
    OnOrderExerciseClickListener listener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.orderexercise_item,viewGroup,false);
        return new ViewHolder(itemView,this);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        OrderExercise item = items.get(position);
        viewHolder.setItem(item);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public  void addItem(OrderExercise item){
        items.add(item);
    }
    public void setItems(ArrayList<OrderExercise> items){
        this.items = items;
    }
    public OrderExercise getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, OrderExercise item){
        items.set(position,item);
    }
    public void setOnItemClickListener(OnOrderExerciseClickListener listener){
        this.listener = listener;
    }
    public void onItemClick(ViewHolder holder, View view, int position){
        if (listener != null){
            listener.onItemClick(holder,view,position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView,final OrderExerciseAdapter listener){
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position =getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }
        public void setItem(OrderExercise item){
            textView.setText(item.getExercise());
        }
    }
}
