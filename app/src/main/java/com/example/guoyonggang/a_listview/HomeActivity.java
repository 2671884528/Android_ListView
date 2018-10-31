package com.example.guoyonggang.a_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list;
    private ArrayAdapter<String> ada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        listView = findViewById(R.id.lv02);
        list = new ArrayList<String>();
        for (int i = 0; i<20; i++){
            list.add("item" + i);
        }

        ada = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_list_item_1, list);
        //将布局文件转换成为一个view视图,
        View headerView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.imageview,null);
        ImageView imageView = headerView.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.ic_launcher_background);
        listView.addHeaderView(headerView);

        View footerView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.button,null);
        Button button = footerView.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = list.size();
                for (int i = index; i< index+20; i++){
                    list.add("item" +i);
                }
                ada.notifyDataSetChanged();
            }
        });
        listView.addFooterView(footerView);

        listView.setAdapter(ada);
    }
}