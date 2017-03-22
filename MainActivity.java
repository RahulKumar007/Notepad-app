package com.example.admin.notepad;

/**
 * Created by admin on 7/11/2016.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbhelper = new DBHelper(this);
        Toast.makeText(this,"Main Activity",Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showList(View view) {

        Intent ii2 = new Intent(this,ShowList.class);
        startActivity(ii2);
    }

    public ArrayAdapter<String> notesAdapter(String str[]){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.notepad_textview,str){
            //  @override
            public View getView(int position, View convertView, ViewGroup parent){

                String text = getItem(position);
                TextView listItem = new TextView(this.getContext());

                listItem.setText(text);

                return listItem;
            }
        };
        return adapter;
    }

    public void AddNoteClick(View view)
    {
        Intent i = new Intent(this,WriteNoteActivity.class);
        startActivity(i);
    }
}
