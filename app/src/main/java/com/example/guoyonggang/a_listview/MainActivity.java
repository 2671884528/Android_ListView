package com.example.guoyonggang.a_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv_name);
        //1：准备数据源
        String[] str = getResources().getStringArray(R.array.city_str);
        //2：数据源加载到适配器
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, str);
        //3：适配器加载到控件
        lv.setAdapter(adapter);

        //点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
        //长按时间,返回false及处理长安时间也处理点击事件
        //如果是true只处理长按事件
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
