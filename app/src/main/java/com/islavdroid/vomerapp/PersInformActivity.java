package com.islavdroid.vomerapp;

import java.util.Calendar;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.islavdroid.vomerapp.chat.MainChatActivity;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;




public class PersInformActivity extends AppCompatActivity{

    ImageButton edit_birthday,edit_name,edit_phone,edit_email,edit_location;
    private int year;
    private int month;
    private Uri mImageUri=null;
    private int day;
    private DatePicker dpResult;
    private TextView birthday;
    private FloatingActionButton fab;
    private static final int GALLERY_REQUEST=1;
    private ImageView image;
    String yourTitle ="+3000.3329333";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pers_info2);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        image=(ImageView)findViewById(R.id.image);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent =new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,GALLERY_REQUEST);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(yourTitle);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);


     /*   AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
                android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                boolean toolbarCollapsed = Math.abs(offset) >= appBarLayout.getTotalScrollRange();
                actionBar.setTitle(toolbarCollapsed ? yourTitle : "");
                actionBar.setSubtitle(toolbarCollapsed ? yourSubTitle : "");
            }
        });
*/
      /*  ControllableAppBarLayout appBarLayout = (ControllableAppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.setOnStateChangeListener(new ControllableAppBarLayout.OnStateChangeListener() {

            @Override
            public void onStateChange(ControllableAppBarLayout.State toolbarChange) {
                switch (toolbarChange) {

                    case COLLAPSED: {
                       // Log.i(TAG, "COLLAPSED2");

                            getSupportActionBar().setTitle(yourTitle);
                            getSupportActionBar().setSubtitle(yourSubTitle);

                        break;
                    }
                    case EXPANDED:
                       // Log.i(TAG, "EXPANDED");
                        getSupportActionBar().setTitle(yourTitle);
                        getSupportActionBar().setSubtitle("");
                        break;

                    case IDLE: // Just fired once between switching states
                       // Log.i(TAG, "IDLE");
                        getSupportActionBar().setTitle(yourTitle);
                        getSupportActionBar().setSubtitle("");
                        break;
                }
            }
        });


*/











            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edit_email=(ImageButton)findViewById(R.id.edit_email);
        edit_location =(ImageButton)findViewById(R.id.edit_location);
        edit_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAddress();
            }
        });
        edit_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEmail();
            }
        });
        edit_name=(ImageButton)findViewById(R.id.edit_name);
        edit_phone=(ImageButton)findViewById(R.id.edit_phone);
        edit_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePhone();
            }
        });
        edit_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rename();
            }
        });


        birthday=(TextView)findViewById(R.id.birthday) ;
edit_birthday=(ImageButton)findViewById(R.id.edit_birthday);
        edit_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dateDialog = new DatePicker();
                dateDialog.show(getSupportFragmentManager(), "datePicker");
            }
        });


}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GALLERY_REQUEST && resultCode==RESULT_OK){
            Uri imageUri=data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                mImageUri = result.getUri();
                image.setImageURI(mImageUri);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


    //показать диалог для переименования
    protected void rename() {


        LayoutInflater layoutInflater = LayoutInflater.from(PersInformActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_for_rename_pers_info, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PersInformActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.name_edittext);
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
    //показать диалог для смены номера
    protected void changePhone() {


        LayoutInflater layoutInflater = LayoutInflater.from(PersInformActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_for_rename_number_pers_info, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PersInformActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.phone_edittext);
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

    //показать диалог смены мыла
    protected void changeEmail() {


        LayoutInflater layoutInflater = LayoutInflater.from(PersInformActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_for_change_email_pers_info, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PersInformActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.email_edittext);
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

    //показать диалог смены адреса
    protected void changeAddress() {


        LayoutInflater layoutInflater = LayoutInflater.from(PersInformActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_for_change_address, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PersInformActivity.this);
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
