package com.example.lesson4android1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lesson4android1.R;
import com.example.lesson4android1.databinding.ActivityDescriptionBinding;
import com.example.lesson4android1.model.BooksModel;


public class DescriptionActivity extends AppCompatActivity {
private ActivityDescriptionBinding binding;
    TextView tvDescription;
    TextView tvTitle;
    TextView tvNameOfBook;
    TextView tvTitleOfBookDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inItView();
    }

    private void inItView(){
        Intent intent = getIntent();
        BooksModel booksModel = (BooksModel) intent.getSerializableExtra("key");
        binding.tvBookDescription.setText(booksModel.getDescription());
        binding.tvTitle.setText("Название книги:");
        binding.tvBookName.setText(booksModel.getName());
        binding.tvDescriptionTitle.setText("Описание книги:");


    }
}