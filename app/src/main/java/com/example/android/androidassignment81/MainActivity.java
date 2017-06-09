package com.example.android.androidassignment81;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    // Declaring the ButtonView and ListView data variables
    private Button mAscendingButton;
    private Button mDescendingButton;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] monthsName = {"January","February","March","April","May","June","July","August","September",
                                "October","November","December"};

        final ArrayList<String> mMonthList = new ArrayList<>();

        //Initializing all strings into arraylist
        for(int i =0; i<monthsName.length;i++){
            mMonthList.add(monthsName[i]);

        }

        mAscendingButton = (Button) findViewById(R.id.ascendingButton);
        mDescendingButton = (Button) findViewById(R.id.descendingButton);
        mListView = (ListView)findViewById(R.id.listView);

        //setting the onClick functionality to sort the list in ascending order
        mAscendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sortilg ArrayList in ascending order
                Collections.sort(mMonthList);
                setArrayListToAdapter(mMonthList);
            }
        });

        //setting the onClick functionality sort the list in descending order
        mDescendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sorting ArrayList in descending order
                Collections.sort(mMonthList,Collections.reverseOrder());
                setArrayListToAdapter(mMonthList);
            }
        });

    }
    //public method to inflate the simple_list_item_1
    public void setArrayListToAdapter(ArrayList<String>itemList){
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,itemList);
        mListView.setAdapter(adapter);
    }
}
