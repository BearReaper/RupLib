package com.example.nenezoid.ruplibapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        SharedPreferences sp= getSharedPreferences("LibData", 0);
        String restoredText= sp.getString("SearchType", null);
        if (restoredText == null)
            return;
        final EditText title = (EditText)findViewById(R.id.TitleInEditText);
        if(restoredText.contains("free"))
        {
            setTitle("Free Search");
            title.setHint("Enter key to "+restoredText+" search");
        }
        else

        {
            setTitle("Search by " + restoredText);
            title.setHint("Enter key to search by "+restoredText);
        }

        title.setHint("Enter name to search by "+restoredText);

        final Context context = this;

        findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the title input string from user and save it on intent first
                //Send intent to SearchActivity hopefully

                String strSrchKey = new StringBuilder(title.getText().toString()).toString();
                if(strSrchKey.isEmpty())
                {
                    AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Wrong input!");
                    alertDialogBuilder.setMessage("Enter some search key").setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog= alertDialogBuilder.create();
                    alertDialog.show();
                }
                else {
                    Intent intush = new Intent(TitleActivity.this,SearchActivity.class);
                    intush.putExtra("SearchKey" , strSrchKey);
                    startActivity(intush);
                }
            }
        });
    }
}
