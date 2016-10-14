package com.islavdroid.vomerapp.invite_friends;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.islavdroid.vomerapp.R;
import com.islavdroid.vomerapp.SimpleDividerItemDecoration;


import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity {
    private List<ContactBean> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecContactsAdapter mAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Пригласить друзей");
        recyclerView=(RecyclerView)findViewById(R.id.list);

        Cursor phones = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
                null, null);
        while (phones.moveToNext()) {

            String name = phones
                    .getString(phones
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            String phoneNumber = phones
                    .getString(phones
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            ContactBean objContact = new ContactBean();
            objContact.setName(name);
            objContact.setPhoneNo(phoneNumber);
            contactList.add(objContact);
        }phones.close();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        mAdapter=new RecContactsAdapter(this,contactList,R.layout.contacts_item);
       recyclerView.setAdapter(mAdapter);



    }}