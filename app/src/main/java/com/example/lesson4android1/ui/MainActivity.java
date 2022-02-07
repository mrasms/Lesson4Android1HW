package com.example.lesson4android1.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.lesson4android1.R;
import com.example.lesson4android1.adapter.AdapterBook;
import com.example.lesson4android1.listener.OnItemClickListener;
import com.example.lesson4android1.model.BooksModel;
import com.example.lesson4android1.data.BooksClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterBook adapterBook;
    ArrayList<BooksModel> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItView();
    }

    private void inItView() {
        recyclerView = findViewById(R.id.recycler_view);
        list = BooksClient.getBook();
        adapterBook = new AdapterBook(list);
        recyclerView.setAdapter(adapterBook);
        adapterBook.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClickListener(BooksModel model) {
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra("model",model);
                startActivity(intent);

            }
        });
    }
}