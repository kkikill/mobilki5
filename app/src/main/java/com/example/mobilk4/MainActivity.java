package com.example.mobilk4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] categories = {"Яблоки", "Бананы", "Овощи", "Молочные продукты"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewCategories);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("category", categories[position]);
                startActivity(intent);
            }
        });
    }
    public void scrollbutton(View view){
        Intent intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);
    }
    public void recyclerbutton(View view){
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }
    public void spinnerbutton(View view){
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }
}
