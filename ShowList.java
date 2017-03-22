package com.example.admin.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 7/11/2016.
 */
public class ShowList extends Activity {

    DBHelper dbh;
    ListView ls;
    String send_title,send_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepadlistview);
        dbh = new DBHelper(this);

        final List<String> titlelist = dbh.getTitlesOnly();
        final List<String> notelist = dbh.getNotesOnly();
        ArrayAdapter adpater = new ArrayAdapter(this,R.layout.notepad_textview,titlelist);
        ls = (ListView) findViewById(R.id.nplistview);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    send_title = titlelist.get(position);
                    send_note = notelist.get(position);
                    Intent ii = new Intent(getApplicationContext(),ShowDetailsActivity.class);
                    ii.putExtra("title",send_title);
                    ii.putExtra("note",send_note);
                    startActivity(ii);
            }
        });
        ls.setAdapter(adpater);
    }

   /* public void ShowDetails(View view)
    {
        Intent ii = new Intent(this,ShowDetailsActivity.class);
        ii.putExtra("Title",)
        startActivity(ii);
    }
    */
}
