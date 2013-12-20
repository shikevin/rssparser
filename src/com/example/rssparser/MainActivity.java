package com.example.rssparser;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.rssparser.RSSItem;
import com.example.rssparser.RSSListener;
import com.example.rssparser.RSSLoader;
public class MainActivity extends Activity {
private MainActivity local;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
local = this;
RSSTask task = new RSSTask();
task.execute("http://www.gizmodo.co.uk/feed/");
}
private class RSSTask extends AsyncTask<String, Void, List<RSSItem> > {
@Override
protected List<RSSItem> doInBackground(String... urls) {
try {
RSSLoader rssLoader = new RSSLoader(urls[0]);
return rssLoader.getItems();
} catch (Exception e) {
Log.e("RSSLoader", e.getMessage());
}
return null;
}
@Override
protected void onPostExecute(List<RSSItem> result) {
ListView gizItems = (ListView) findViewById(R.id.rssListView);
ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(local,android.R.layout.simple_list_item_1, result);
gizItems.setAdapter(adapter);
gizItems.setOnItemClickListener(new RSSListener(result, local));
}
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}
}
