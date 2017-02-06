package com.rhodonite.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rhodonite on 2/6/17.
 */
public class My_BtAdapter extends BaseAdapter
{
    private ArrayList<String> Files= new ArrayList<>();
    Context mainActivity;
    private int selectedValue =-1;
    public My_BtAdapter(Context c, ArrayList<String> appList) {
        this.Files = appList;
        this.mainActivity = c;
    }
    public void setPos(int pos)
    {
        this.selectedValue = pos;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Files.size();
    }
    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return Files.get(arg0);
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.adapter_layout, null);
        TextView ItemName = (TextView)vi.findViewById(R.id.ItemName);
        final Button bt_delete = (Button)vi.findViewById(R.id.ItemButton);
        ItemName.setText(Files.get(position));
        if(selectedValue==position && selectedValue!=-1)
        {
            bt_delete.setVisibility(View.VISIBLE);
        }
        else
        {
            bt_delete.setVisibility(View.GONE);
        }

        return vi;
    }

}