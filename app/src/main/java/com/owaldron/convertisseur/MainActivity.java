package com.owaldron.convertisseur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder alertDialogue;
    EditText txtNum;
    TextView txtView;

    public void convert(View view) {
        double meter, pieds;
        txtNum=findViewById(R.id.txtNum);
        txtView=findViewById(R.id.txtView);
        meter= Double.parseDouble(txtNum.getText().toString());
        pieds=meter*3.28084;
        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
        txtView.setText(Double.toString(pieds));
    }

    public void reset (View view) {
        txtNum=findViewById(R.id.txtNum);
        txtView=findViewById(R.id.txtView);
        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
        txtView.setText("Valeur");
        txtNum.setText("");
    }

    public void quit (View view) {
        alertDialogue=new AlertDialog.Builder(MainActivity.this);
        alertDialogue.setTitle("Quité?");
        alertDialogue.setMessage("Êtes-vouz sure que vous vouliez quité?");
        alertDialogue.setCancelable(false);
        alertDialogue.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        alertDialogue.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = alertDialogue.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}