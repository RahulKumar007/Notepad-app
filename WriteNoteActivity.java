package com.example.admin.notepad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by admin on 7/11/2016.
 */
public class WriteNoteActivity extends Activity{

    EditText edittext1,edittext2;
    String writeup;
    String title_name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newnote);

        edittext1 = (EditText) findViewById(R.id.edittext);
        edittext2 = (EditText) findViewById(R.id.edittext2);
        button = (Button) findViewById(R.id.Save);
    }

    public void SaveDetails(View view)
    {
        DBHelper db2 = new DBHelper(this);
        title_name = edittext1.getText().toString();
        writeup = edittext2.getText().toString();
        if (title_name.equals("") || writeup.equals(""))
        {
            Toast.makeText(this,"Please fill details",Toast.LENGTH_SHORT).show();  finish();
        }
        else
        {
            NoteClass nclass = new NoteClass(title_name,writeup);
            Boolean state = db2.addNote(nclass);
            if(state)
            {
                Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Note not Saved",Toast.LENGTH_SHORT).show();
            }

        }

        db2.close();
        this.finish();

    }
}