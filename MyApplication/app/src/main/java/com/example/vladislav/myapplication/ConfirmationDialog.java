package com.example.vladislav.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;



public class ConfirmationDialog extends DialogFragment {
    static final String RESULT_TYPE = "resType";
    String RESULT;
    private static final String TAG = "ConfirmationDialog";
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("Удаление")
                .setMessage("Вы уверены?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: " + which);
                        RESULT = "OK";
                        Intent intent = new Intent();
                        intent.putExtra(RESULT_TYPE,which);
                        getTargetFragment().onActivityResult(ItemListFragment.RESULT_REQUEST_CODE, Activity.RESULT_OK,intent);
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: " + which);
                        Intent intent = new Intent();
                        intent.putExtra(RESULT_TYPE,which);
                    }
                })
                .create();
        return dialog;
    }


}
