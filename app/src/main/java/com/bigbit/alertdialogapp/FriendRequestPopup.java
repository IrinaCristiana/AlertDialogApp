package com.bigbit.alertdialogapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;

/**
 * Created by Irina on 24.08.2016.
 */
public class FriendRequestPopup {
    public static AlertDialog alertDialog;

    private FriendRequestPopup() {}

    public static void show(final Activity activity, String playerName)
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(playerName + " sent a friend request")
                .setCancelable(false)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(activity, Main2Activity.class);
                        intent.putExtra("friend_request", "You added X to your Friends");
                        activity.startActivity(intent);
                    }
                })
                .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })

                .setTitle("Friend request");

        FriendRequestPopup.alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void show(final Activity activity, final String playerName, final int countdown)
    {
        new CountDownTimer(countdown, 1000) {

            public void onTick(long milisec){
            }

            @Override
            public void onFinish() {
                show(activity,playerName);
            }
        }.start();
    }
}