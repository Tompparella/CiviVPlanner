/*
CiviVPlanner; Android Studio; Tommi Kunnari; DialogBox.class;

This is a class for a customized dialogbox. It was supposed to
alert the user of a problem with connecting to the database, but
I figured it would be better to just use toasts. It's left here
in case of use in the future.
*/

package com.example.javaharkka;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogBox extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Info:")
                .setMessage("Couldn't connect to database. Click 'OK' when you've secured connection.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        return builder.create();
    }
}

