package com.example.lesson4android1.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson4android1.R;
import com.example.lesson4android1.databinding.ListHolderBinding;
import com.example.lesson4android1.listener.OnItemClickListener;
import com.example.lesson4android1.model.BooksModel;

import java.util.ArrayList;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.HolderBook> {
    ArrayList<BooksModel> list = new ArrayList<>();


    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdapterBook.HolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderBook(ListHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBook.HolderBook holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void getBooksName(ArrayList<BooksModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class HolderBook extends RecyclerView.ViewHolder {
        private ListHolderBinding binding;

        public HolderBook(@NonNull ListHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(BooksModel booksModel) {
            binding.tvBookName.setText(booksModel.getName());
            itemView.setOnClickListener(view ->
                    onItemClickListener.onItemClick(booksModel));
        }
    }
}
