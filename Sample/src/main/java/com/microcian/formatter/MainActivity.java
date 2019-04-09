package com.microcian.formatter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String formatedString = "";
    boolean isBackPressed = false;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etCNIC);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setText();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                int length = editText.getText().length();
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_DEL)) {
                    isBackPressed = true;
                    setText();
//                    String input = editText.getText().toString();
//                    String newText = input.substring(0, 13) + "";
//                    editText.setText(newText);
//                    editText.setSelection(newText.length());
                    return true;
                }
                return false;
            }
        });
    }

    private void setText() {
        int length = editText.length();
        String inputField = editText.getText().toString();
        if (isBackPressed && length == 8) {
            String newText = inputField.substring(0, 6) + "";
            editText.setText(newText);
            editText.setSelection(editText.length());
            isBackPressed = false;
            return;
        }
        if (isBackPressed && length == 15) {
            String newText = inputField.substring(0, 13) + "";
            editText.setText(newText);
            editText.setSelection(editText.length());
            isBackPressed = false;
            return;
        }
        if (length == 5) {
            editText.getText().append("-");
            return;
        }
        if (length == 13) {
            editText.getText().append("-");
            return;
        }

    }
}