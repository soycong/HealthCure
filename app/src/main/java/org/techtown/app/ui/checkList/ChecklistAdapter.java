package org.techtown.app.ui.checkList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.app.R;

import java.util.ArrayList;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ViewHolder> implements OnHealthItemClickListener{
    ArrayList<CheckList> items = new ArrayList<CheckList>();
    OnHealthItemClickListener listener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.checklist_item,viewGroup,false);
        return new ViewHolder(itemView,this);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CheckList item = items.get(position);
        viewHolder.setItem(item);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public  void addItem(CheckList item){
        items.add(item);
    }
    public void setItems(ArrayList<CheckList> items){
        this.items = items;
    }
    public CheckList getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, CheckList item){
        items.set(position,item);
    }
    public void setOnItemClickListener(OnHealthItemClickListener listener){
        this.listener = listener;
    }

    public void onItemClick(ViewHolder holder, View view, int position){
        if (listener != null){
            listener.onItemClick(holder,view,position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox checkBox;
        public ViewHolder(View itemView,final ChecklistAdapter listener){
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkBox);
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

        public void setItem(CheckList item){
            textView.setText(item.getHitem());
            checkBox.setChecked(item.isCheck());
        }
    }
}
