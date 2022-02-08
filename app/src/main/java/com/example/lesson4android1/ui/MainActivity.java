package com.example.lesson4android1.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.lesson4android1.R;
import com.example.lesson4android1.adapter.AdapterBook;
import com.example.lesson4android1.databinding.ActivityMainBinding;
import com.example.lesson4android1.listener.OnItemClickListener;
import com.example.lesson4android1.model.BooksModel;
import com.example.lesson4android1.data.BooksClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<BooksModel> list = new ArrayList<>();
    AdapterBook adapterBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialisation();
        listeners();
    }


    private void initialisation() {
        list = BooksClient.getBook();
        adapterBook = new AdapterBook();
        adapterBook.getBooksName(list);
        binding.recyclerView.setAdapter(adapterBook);

    }

    private void listeners() {
        adapterBook.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BooksModel booksModel) {
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra("key", booksModel);
                startActivity(intent);
            }
        });


    }
}