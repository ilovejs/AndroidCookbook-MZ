package com.example.mymodule.customizingthewindow.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private CheckBox checkBox;
    private TextView txtCheckBox, txtRadio;
    private RadioButton rb1, rb2, rb3;
    private Spinner spnMusketeers;
    private TextView selectedItem;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = (CheckBox) findViewById(R.id.cbxBox1);
        txtCheckBox = (TextView) findViewById(R.id.txtCheckBox);
        txtRadio = (TextView) findViewById(R.id.txtRadio);
        rb1 = (RadioButton) findViewById(R.id.RB1);
        rb2 = (RadioButton) findViewById(R.id.RB2);
        rb3 = (RadioButton) findViewById(R.id.RB3);
        spnMusketeers = (Spinner) findViewById(R.id.spnMusketeers);
        selectedItem = (TextView) findViewById(R.id.selectedItem);

        // React to events from the CheckBox
        checkBox.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    txtCheckBox.setText("CheckBox: Box is checked");
                } else {
                    txtCheckBox.setText("CheckBox: Not checked");
                }
            }
        });

        // React to events from the RadioGroup
        rb1.setOnClickListener(new RadioGroup.OnClickListener() {
            public void onClick(View v) {
                txtRadio.setText("Radio: Button 1 picked");
            }
        });
        rb2.setOnClickListener(new RadioGroup.OnClickListener() {
            public void onClick(View v) {
                txtRadio.setText("Radio: Button 2 picked");
            }
        });
        rb3.setOnClickListener(new RadioGroup.OnClickListener() {
            public void onClick(View v) {
                txtRadio.setText("Radio: Button 3 picked");
            }
        });

        // Set up the Spinner entries
        final List<String> lsMusketeers = new ArrayList<String>();
        lsMusketeers.add("Athos");
        lsMusketeers.add("Porthos");
        lsMusketeers.add("Aramis");
        //item template
        ArrayAdapter<String> aspnMusketeers =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lsMusketeers);
        //dropdown template
        aspnMusketeers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnMusketeers.setAdapter(aspnMusketeers);
        // Set up a callback for the spinner
        spnMusketeers.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> arg0) { }
                    public void onItemSelected(AdapterView<?> parent, View v,
                                               int position, long id) {
                        // Code that does something when the Spinner value changes
                        selectedItem.setText("You select: " + lsMusketeers.get(position));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
