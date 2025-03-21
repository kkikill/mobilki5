package com.example.mobilk4;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button addButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listView = findViewById(R.id.listViewItems);
        editText = findViewById(R.id.editTextItem);
        addButton = findViewById(R.id.buttonAdd);

        String category = getIntent().getStringExtra("category");
        setTitle(category);

        items = new ArrayList<>();
        if ("Яблоки".equals(category)) {
            items.add("Голден");
            items.add("Гренни Смит");
            items.add("Антоновка");
        } else {
            items.add("Продукт 1");
            items.add("Продукт 2");
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    items.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
