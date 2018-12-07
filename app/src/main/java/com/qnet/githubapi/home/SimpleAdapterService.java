package com.qnet.githubapi.home;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class SimpleAdapterService {
    List<String> items;
    Context context;

    public SimpleAdapterService(Context context) {
        this.context = context;
    }

    public SimpleAdapterService(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public ArrayAdapter<String> getSimpleAdapter(){
        String[] reposArrayString = new String[items.size()];
        reposArrayString = items.toArray(reposArrayString);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.context, android.R.layout.simple_list_item_1 ,reposArrayString);
        return adapter;
    }
}
