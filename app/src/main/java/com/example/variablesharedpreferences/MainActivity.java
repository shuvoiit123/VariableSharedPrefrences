package com.example.variablesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button applyButton,saveButton;
    private Switch switch1;
    public static final String SHERED_PREFS = "Shared_prefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    private String text;
    private Boolean switchOnOff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewId);
        applyButton = findViewById(R.id.applyButtonId);
        saveButton = findViewById(R.id.saveButtonId);
        switch1 = findViewById(R.id.switchId);
        editText = findViewById(R.id.editTextId);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString().trim());
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();

            }
        });
        loadData();
        updateViews();
    }
    public void saveData()
    {
        SharedPreferences sharedPreferences  = getSharedPreferences(SHERED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,editText.getText().toString());
        editor.putBoolean(SWITCH1,switch1.isChecked());

        editor.apply();

        Toast.makeText(getApplicationContext(),"Data is saved",Toast.LENGTH_SHORT).show();

    }
    public void loadData()
    {
        SharedPreferences sharedPreferences  = getSharedPreferences(SHERED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT," ");
        //By default text is null
        switchOnOff = sharedPreferences.getBoolean(SWITCH1,false);
        //false becase by default it will be false

    }
    public void updateViews()
    {
        textView.setText(text);
        switch1.setChecked(switchOnOff);

    }
}
