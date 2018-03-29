package com.example.sulikowskip.tender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class About extends AppCompatActivity {

    RelativeLayout introMessage;

    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        addListenerOnButton();

        introMessage = (RelativeLayout) findViewById(R.id.welcome_message_layout);
    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.about_back);

        button2 = (Button) findViewById(R.id.check_this_out);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Welcome.class);
                startActivity(intent);
            }

        });

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, More.class);
                startActivity(intent);
            }

        });
    }
}