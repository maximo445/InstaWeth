package com.example.android.instaweth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initImageBitmap();

        DownloadTask task = new DownloadTask();
        task.execute("api.openweathermap.org/data/2.5/weather?q=London&APPID=ca568ab4d9aad4eae4f935498ca84a22");


    }

    public void initImageBitmap(){

        //Get image urls

        mImageUrls.add("https://images-na.ssl-images-amazon.com/images/I/51A685AMYoL.jpg");
        mNames.add("In Search of Lost Time");

        initRecyclerView();

    }

    public void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
