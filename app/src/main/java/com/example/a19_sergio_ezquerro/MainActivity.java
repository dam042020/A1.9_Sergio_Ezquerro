package com.example.a19_sergio_ezquerro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView tvCounter;
    EditText tietName;
    CheckBox chbWhippedCream;
    CheckBox chChocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.textView_Counter);
        tietName= findViewById(R.id.EditText_Name);
        chbWhippedCream = findViewById(R.id.checkBox_Toppings_WhippedCream);
        chChocolate = findViewById(R.id.checkBox_Toppings_Chocolate);
        tvCounter.setText("0");
    }

    //Elements


    //Counter
    int count = 0;
    public void subtractCount(View view){
        if (count != 0){
            count--;
        }
        tvCounter.setText("" + count);
    }
    public void addCount(View view) {
        count++;
        tvCounter.setText("" + count);
    }

    //order
    public void order(View view) {
        Intent intent = new Intent(com.example.a19_sergio_ezquerro.MainActivity.this, ShowOrder.class);

        intent.putExtra("name", tietName.getText().toString());
        intent.putExtra("whippedCream", chbWhippedCream.isChecked());
        intent.putExtra("chocolate", chChocolate.isChecked());
        intent.putExtra("count", count);

        startActivity(intent);
    }
}