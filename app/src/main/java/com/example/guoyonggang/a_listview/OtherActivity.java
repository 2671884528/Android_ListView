package com.example.guoyonggang.a_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        listView = findViewById(R.id.lv02);
        list = new ArrayList<String>();
        for (int i = 0; i<20; i++){
            list.add("item" + i);
        }
        adapter = new ArrayAdapter<String>(OtherActivity.this, android.R.layout.simple_list_item_1, list);
        //设置视图
        ImageView imageView = new ImageView(OtherActivity.this);
        imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        imageView.setImageResource(R.drawable.ic_launcher_background);

        Button button = new Button(OtherActivity.this);
        button.setText("加载更多数据");
        button.setTextSize(20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = list.size();
                for (int i = index; i< index+20; i++){
                    list.add("item" + i);
                }
        //notifyDataSetChanged方法通过一个外部的方法控制如果适配器的内容改变
        // 需要强制调用getView来刷新每个Item的内容
                adapter.notifyDataSetChanged();
            }
        });
        //将控件加入到list view的头部,必须在setAdapter()之前
        listView.addHeaderView(imageView);
        //将button加在尾部
        listView.addFooterView(button);

        listView.setAdapter(adapter);

    }
}
