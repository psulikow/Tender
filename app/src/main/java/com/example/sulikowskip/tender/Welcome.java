package com.example.sulikowskip.tender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Welcome extends AppCompatActivity {

    RelativeLayout introMessage;

    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_message_android);
        addListenerOnButton();

        introMessage = (RelativeLayout) findViewById(R.id.welcome_message_layout);
    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button1);

        button2 = (Button) findViewById(R.id.about_button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, GetInfo.class);
                startActivity(intent);
            }

        });

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, About.class);
                startActivity(intent);
            }

        });
    }
}