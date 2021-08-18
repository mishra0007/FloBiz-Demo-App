package com.snapit.flobiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<AnimalDetails> animalDetailsArrayList;

    public MyAdapter(Context context, ArrayList<AnimalDetails> animalDetailsArrayList) {
        this.context = context;
        this.animalDetailsArrayList = animalDetailsArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position){
        AnimalDetails animalDetails = animalDetailsArrayList.get(position);
        holder.animalImg.setImageResource(animalDetails.animalImg);
        holder.animalText.setText(animalDetails.animalName);
    }

    @Override
    public int getItemCount() {
        return animalDetailsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView animalImg;
        TextView animalText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImg = itemView.findViewById(R.id.animalImg);
            animalText = itemView.findViewById(R.id.animalText);
        }
    }
}
