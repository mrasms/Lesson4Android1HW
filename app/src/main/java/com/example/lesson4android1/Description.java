package com.example.lesson4android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.lesson4android1.model.BookModel;


public class Description extends AppCompatActivity {

    TextView tvDescription;
    TextView tvTitle;
    TextView tvNameOfBook;
    TextView tvTitleOfBookDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        inItView();
        Bundle bundle = getIntent().getExtras();
        BookModel model = (BookModel) bundle.getSerializable("model");
        tvNameOfBook.setText(model.getName());
        tvDescription.setText(model.getDescription());
        tvTitle.setText("Название Книги:");
        tvTitleOfBookDescription.setText("Описание книги:");

    }

    private void inItView(){
        tvDescription= findViewById(R.id.tv_book_description);
        tvTitle= findViewById(R.id.tv_title);
        tvNameOfBook = findViewById(R.id.tv_book_name);
        tvTitleOfBookDescription = findViewById(R.id.tv_description_title);


    }
}