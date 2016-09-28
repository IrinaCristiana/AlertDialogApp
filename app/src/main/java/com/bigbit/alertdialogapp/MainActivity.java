package com.bigbit.alertdialogapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    public int contor = 0;
    TextView textView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinateLayout);
        final MediaPlayer mpButtonClick = MediaPlayer.create(this, R.raw.message_alert);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(6000, 1000) {

                    public void onTick(long milisec) {
                        textView.setText(String.valueOf(contor));
                        contor++;
                    }

                    @Override
                    public void onFinish() {
                        mpButtonClick.start();
                        FriendRequestPopup.show(MainActivity.this,"Player3");
                    }
                }.start();
                FriendRequestPopup.show(MainActivity.this,"Player 1",6000);
            }
        });
    }

    //Method to show the AlertDialog

    /*public void showAlertDialog() {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("X sent a friend request")
                        .setCancelable(false)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                intent.putExtra("friend_request", "You added X to your Friends");
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("X", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })

                 .setTitle("Friend request");

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }*/

    }