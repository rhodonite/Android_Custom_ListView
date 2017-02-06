package com.rhodonite.custom_listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lv;
    private ArrayList<String> Files = new ArrayList<>();
    My_BtAdapter mba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            Files.add("測試 " + i);
        }


        lv = (ListView) findViewById(R.id.listView);

        mba = new My_BtAdapter(this, Files);

        lv.setOnItemClickListener(mListview);
        lv.setAdapter(mba);

    }


    private AdapterView.OnItemClickListener mListview = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> av, View v, final int arg2, long arg3) {
            /****/
            Button bt_delete = (Button) v.findViewById(R.id.ItemButton);
            bt_delete.setVisibility(View.VISIBLE);
            bt_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("bt_index", "" + arg2);
                }
            });
            /****/
            String info = ((TextView) v.findViewById(R.id.ItemName)).getText().toString();
            Log.e("info", info);
            /****/

            mba.setPos(arg2);
            mba.notifyDataSetChanged();
        }
    };

}
