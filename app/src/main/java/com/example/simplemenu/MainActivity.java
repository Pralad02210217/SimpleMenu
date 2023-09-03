package com.example.simplemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Message");
        list.add("Map");
        list.add("Image");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = list.get(position);
                openApp(selectedItem);
            }
        });
    }

    public void openApp(String appName) {
        Intent intent = null;

        switch (appName) {
            case "Message":
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"));

                break;
            case "Map":
                intent = new Intent(MainActivity.this, Message.class);
                break;
            case "Image":
                // Replace this with the actual package name of the image app you want to open
                intent = new Intent(MainActivity.this, ImageActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
