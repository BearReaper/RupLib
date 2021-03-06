package com.example.nenezoid.ruplibapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        setTitle("Search By Title");

        final EditText title = (EditText)findViewById(R.id.TitleInEditText);

        findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the title input string from user and save it on intent first
                //Send intent to SearchActivity hopefully

                String strTitle = new StringBuilder(title.getText().toString()).toString();

                Intent intush = new Intent(TitleActivity.this,SearchActivity.class);
                intush.putExtra("Title" , strTitle);
                startActivity(intush);
            }
        });
    }
}
