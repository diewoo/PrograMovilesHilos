package com.bignerdranch.android.multitarea;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mboton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread hilo = new Thread() {
            @Override
            public void run() {
                //codigo que se va a ejecutar

                Log.i("MainActivity", "hilo");
            }
        };
        hilo.start();
        Log.i("MainActivity", "onCreate");


        mboton=(Button) findViewById(R.id.boton);
        mboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Runnable porcionUi=new Runnable() {
                    int cuenta=0;
                    @Override
                    public void run() {



                        cuenta++;
                        Toast.makeText(
                                MainActivity.this,
                                "Toast!"+ cuenta,
                                Toast.LENGTH_SHORT).show();

                    }
                };
                ThreadPoolExecutor poolExecutor=
                        new ThreadPoolExecutor(
                                5,
                                5,
                                60l,
                                TimeUnit.SECONDS,
                                new LinkedBlockingDeque<Runnable>()



                        );

               final Handler handler=new Handler();
              for(int i=0;i<50;i++){
                  final  int  cont=i;
                  poolExecutor.execute(new Runnable() {
                      @Override
                      public void run() {
                          try {
                              Thread.sleep(3000);

                          }catch (InterruptedException e){
                              e.printStackTrace();


                          }
                          Log.i("MainActivity","Cont"+ cont);
                          handler.post(porcionUi);

                     //     Toast.makeText(MainActivity.this,
                       //           "Toast!:"+ cont, Toast.LENGTH_SHORT).show();
                      }

                  });
              }
            }
        });

    }
}