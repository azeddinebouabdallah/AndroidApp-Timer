package com.cocoapp.counter;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int ct;
    CounterTest myCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    protected boolean onCreateOptionMenu (Menu menu){

        MenuInflater myMenuInflater = getMenuInflater();


        myMenuInflater.inflate(R.menu.activity_main_menu, menu);


        return true;
    }

    public boolean onOptionItemSelected (MenuItem item){

        int id = item.getItemId();

        if (id == R.id.homeMenu){
            Toast.makeText(this, "Home" , Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Exit" , Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    public void startFunc(View view) {
        ct = 0;
        myStartFunc();
    }
    public void myStartFunc (){

        myCounter = new CounterTest(10000,1000);
        myCounter.start();
    }
    public void endFunc(View view) {

        myCounter.cancel();


    }


    public class CounterTest extends CountDownTimer {

        TextView myTextView = (TextView) findViewById(R.id.textView);

        public CounterTest (long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

            myTextView.setText(String.valueOf(ct));
            ct++;
        }

        @Override
        public void onFinish() {
            myStartFunc();
        }

    }
}
