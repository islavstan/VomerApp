package com.islavdroid.vomerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import at.markushi.ui.CircleButton;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewDisplay;
    private ImageButton buttonDel;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonStar;
    private Button buttonZero;
    private Button buttonPound;
    private static final String SYMBOL_STAR = "*";
    private static final String SYMBOL_POUND = "#";
    private  Vibrator vibe;
    private CircleButton button_call,button_back;
    private List<Users> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecUserAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_phone);

        recyclerView = (RecyclerView)findViewById(R.id.find_contacts);
        mAdapter = new RecUserAdapter(this,userList,R.layout.find_contacts_item);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerView.setAdapter(mAdapter);

        prepareUserData();
         vibe = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE) ;
        button1 =(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        buttonZero =(Button)findViewById(R.id.button_zero);
        buttonZero.setOnClickListener(this);
        button2 =(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        button3 =(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        button4 =(Button)findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        button5 =(Button)findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        button6 =(Button)findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        button7 =(Button)findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        button8=(Button)findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        button9=(Button)findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        buttonStar=(Button)findViewById(R.id.button_star);
        buttonStar.setOnClickListener(this);
        buttonPound=(Button)findViewById(R.id.button_pound);
        buttonPound.setOnClickListener(this);
        buttonDel=(ImageButton) findViewById(R.id.button_del);
        buttonDel.setOnClickListener(this);
        textViewDisplay=(TextView) findViewById(R.id.text_view_display);
        button_back=(CircleButton)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_call=(CircleButton)findViewById(R.id.button_call);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PhoneActivity.this,CallActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_del:
                deleteCharacter();
                break;
            case R.id.button_1:
                appendDigitAndFormat(1);
                break;
            case R.id.button_2:
                appendDigitAndFormat(2);
                break;
            case R.id.button_3:
                appendDigitAndFormat(3);
                break;
            case R.id.button_4:
                appendDigitAndFormat(4);
                break;
            case R.id.button_5:
                appendDigitAndFormat(5);
                break;
            case R.id.button_6:
                appendDigitAndFormat(6);
                break;
            case R.id.button_7:
                appendDigitAndFormat(7);
                break;
            case R.id.button_8:
                appendDigitAndFormat(8);
                break;
            case R.id.button_9:
                appendDigitAndFormat(9);
                break;
            case R.id.button_zero:
                appendDigitAndFormat(0);
                break;
            case R.id.button_star:
                appenSymbolAndFormat(SYMBOL_STAR);
                break;
            case R.id.button_pound:
                appenSymbolAndFormat(SYMBOL_POUND);
                break;
            default:
                break;
    }
}




    private void appendDigitAndFormat(int i) {
        textViewDisplay.append(String.valueOf(i));
        vibe.vibrate(50);
    }




    private void deleteCharacter() {
        if (textViewDisplay.getText() != null) {
            String phoneNumber = textViewDisplay.getText().toString();
            if (phoneNumber.length() > 0) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                vibe.vibrate(50);
                textViewDisplay.setText(phoneNumber);
            }
        }
    }



    private void appenSymbolAndFormat(String symbol) {
        textViewDisplay.append(symbol);
        vibe.vibrate(50);



}
    private void prepareUserData() {

        Users users =new Users("Василий Петров","+3000.3333333",R.drawable.a);
        userList.add(users);
        users =new Users( "Людмила Кирсовна", "+3000.0000001", R.drawable.b);
        userList.add(users);
        users =new Users( "Татьяна Анькова", "+3000.92548484", R.drawable.c);
        userList.add(users);
        users =new Users( "Дмитрий Петров", "+3000.405599", R.drawable.d);
        userList.add(users);
        users =new Users("Юлия Котиковна", "+3000.9696878", R.drawable.g);
        userList.add(users);
        users =new Users( "Сергей Ефремов", "+3000.4040507", R.drawable.n);
        userList.add(users);


    }




}
