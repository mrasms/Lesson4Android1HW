package com.example.lesson4android1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson4android1.R;
import com.example.lesson4android1.listener.OnItemClickListener;
import com.example.lesson4android1.model.BooksModel;

import java.util.ArrayList;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.HolderBook> {

    OnItemClickListener onItemClickListener;
    ArrayList<BooksModel> list;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterBook(ArrayList<BooksModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterBook.HolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_holder, parent, false);
        return new HolderBook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBook.HolderBook holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class HolderBook extends RecyclerView.ViewHolder {
        TextView tvBookName;

        public HolderBook(@NonNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tv_book_name);
        }


        public void onBind(BooksModel booksModel) {
            tvBookName.setText(booksModel.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(booksModel);
                }
            });
        }
    }
}
