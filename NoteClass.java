package com.example.admin.notepad;

/**
 * Created by Admin on 7/11/2016.
 */
public class NoteClass {
    private String title;
    private String note;

    public NoteClass(){}
    public NoteClass(String title, String note)
    {
        this.note = note;
        this.title = title;
    }

    public String getTitle()
    { return title;}

    public String getNote()
    { return note;}

}

