package com.islavdroid.vomerapp;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

//НАСТРОЙКИ
public class SettingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    RelativeLayout change_pin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Настройки");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        change_pin=(RelativeLayout)findViewById(R.id.change_pin);
        change_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePin();
            }
        });
}
private void changePin(){
    LayoutInflater layoutInflater = LayoutInflater.from(SettingActivity.this);
    View promptView = layoutInflater.inflate(R.layout.dialog_for_change_pin, null);
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SettingActivity.this);
    alertDialogBuilder.setView(promptView);

    //final EditText editText = (EditText) promptView.findViewById(R.id.email_edittext);
    // setup a dialog window
    alertDialogBuilder
            .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //  resultText.setText("Hello, " + editText.getText());
                }
            })
            .setNegativeButton("Отмена",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });


    AlertDialog alert = alertDialogBuilder.create();

// Customize the button

    alert.show();
    Button button = alert.getButton(DialogInterface.BUTTON_POSITIVE);
    button.setTextColor(Color.BLACK);
    //  button.setTypeface(Typeface.DEFAULT_BOLD);
    Button button2 = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
    button2.setTextColor(Color.BLACK);

}
}



