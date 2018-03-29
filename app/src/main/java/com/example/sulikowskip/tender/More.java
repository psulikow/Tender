package com.example.sulikowskip.tender;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class More extends Activity {

  Button button, button2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.spin_activity);
    addListenerOnButton();
  }

  @Override
  protected void onResume() {
    super.onResume();
    MyView v1 = (MyView) findViewById(R.id.v1);
    v1.startAnimation();
  }

  @Override
  protected void onPause() {
    super.onPause();
    MyView v1 = (MyView) findViewById(R.id.v1);
    v1.stopAnimation();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.more_menu, menu);

      return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void addListenerOnButton() {

    final Context context = this;

    button = (Button) findViewById(R.id.get_started_from_spin);

    button2 = (Button) findViewById(R.id.email_us);


    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
          Intent intent = new Intent(context, Welcome.class);
        startActivity(intent);
      }
    });

    button2.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
          Intent intent = new Intent(Intent.ACTION_SEND);
          intent.setType("plain/text");
          intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "some@email.address" });
          intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
          intent.putExtra(Intent.EXTRA_TEXT, "mail body");
          startActivity(Intent.createChooser(intent, ""));
      }
    });
  }
}
