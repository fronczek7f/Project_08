package com.android.fronc.project_08;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Resources resources;
    private ArrayList mSelectedItems;
    private String[] dialogOptions;
    private boolean[] dialogOptionsChecked;
    private String textToast = "";
    int arrayLength = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        resources = getResources();
        dialogOptions = resources.getStringArray(R.array.dialog_options);
        arrayLength = dialogOptions.length;
        dialogOptionsChecked = new boolean[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            if (i % 2 == 0) {
                dialogOptionsChecked[i] = true;
            } else {
                dialogOptionsChecked[i] = false;
            }
        }
    }

    public void onClickSimple(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_cancel, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClickSimpleList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.dialog_title);
        builder.setItems(R.array.dialog_options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), dialogOptions[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_cancel, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClickListRadio(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.dialog_title);
        builder.setSingleChoiceItems(R.array.dialog_options, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textToast = resources.getString(R.string.dialog_selected) + " " + dialogOptions[which];
                Toast.makeText(getApplicationContext(), textToast, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_cancel, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClickListCheckbox(View view) {
        mSelectedItems = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.dialog_title);
        builder.setMultiChoiceItems(R.array.dialog_options, dialogOptionsChecked,
            new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked && dialogOptionsChecked[which]) {
                        textToast = resources.getString(R.string.dialog_checked) + " " + dialogOptions[which];
                        Toast.makeText(getApplicationContext(), textToast, Toast.LENGTH_SHORT).show();
                        mSelectedItems.add(which);
                    } else if (mSelectedItems.contains(which) || !dialogOptionsChecked[which]) {
                        textToast = resources.getString(R.string.dialog_unchecked) + " " + dialogOptions[which];
                        Toast.makeText(getApplicationContext(), textToast, Toast.LENGTH_SHORT).show();
                        mSelectedItems.remove(Integer.valueOf(which));
                    }
                }
            });
        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_cancel, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClickCustom(View view) {
        LayoutInflater li = LayoutInflater.from(this);
        View custom_dialog = li.inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(custom_dialog);
        final EditText nameInput = (EditText) custom_dialog.findViewById(R.id.name);
        final EditText passwordInput = (EditText) custom_dialog.findViewById(R.id.password);

        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String result = nameInput.getText().toString() + "\n" + passwordInput.getText().toString();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.btn_cancel, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
