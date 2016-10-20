package com.islavdroid.vomerapp.login_page;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.islavdroid.vomerapp.MainActivity;
import com.islavdroid.vomerapp.R;

public class LoginActivity extends AppCompatActivity {
   TextView forgot_password,web_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Button enter_button =(Button)findViewById(R.id.enter_button);
        web_phone=(TextView)findViewById(R.id.web_phone);
        web_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,WebPhoneActivity.class);
                startActivity(intent);
            }
        });
      //  web_phone.setPaintFlags(web_phone.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        forgot_password=(TextView)findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        forgot_password.setPaintFlags(forgot_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //forgot_password.setText(Html.fromHtml(getString(R.string.forgot_password)));
        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);



            }
        });
    }
}
