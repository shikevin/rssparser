package com.example.rssparser;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.example.rssparser.RSSItem;

public class RSSListener implements OnItemClickListener {
ListlistItems;
Activity activity;
public RSSListener(List aListItems, Activity anActivity) {
listItems = aListItems;
activity = anActivity;
}
public void onItemClick(AdapterView parent, View view, int pos, long id) {
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse(listItems.get(pos).getLink()));
activity.startActivity(i);
}
}