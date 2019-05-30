package com.example.rabia.alertbox;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button box1,bix2;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box1=findViewById(R.id.dialog);
        bix2=findViewById(R.id.alertDialog);
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final Dialog dialog=new Dialog(MainActivity.this);
                 dialog.setContentView(R.layout.custom_dialog);
                 dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 Button cancel=dialog.findViewById(R.id.cancel);
                 Button update=dialog.findViewById(R.id.update);
                name=dialog.findViewById(R.id.name1);
                 cancel.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         dialog.dismiss();
                     }
                 });
                 update.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         String name1=name.getText().toString();
                         Toast.makeText(getApplicationContext()," My name is " +name1,Toast.LENGTH_SHORT).show();
                     }
                 });
                 dialog.show();

            }
        });

        bix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Do You Want to Delete This Record");
                alertDialog.setCancelable(false)
                        .setMessage("Click yes to delete")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog1=alertDialog.create();
                alertDialog1.show();
            }
        });

    }
}
