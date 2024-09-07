package com.example.age;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText mYearEt;
    Button mCalBtn;
    TextView mAgeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYearEt = findViewById(R.id.yearEditText);
        mCalBtn = findViewById(R.id.calculate_btn);
        mAgeTv = findViewById(R.id.ageTextView);

        mCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userDOB = mYearEt.getText().toString().trim();
                int year = Calendar.getInstance().get(Calendar.YEAR);

                if (userDOB.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter a year.", Toast.LENGTH_SHORT).show();
                }

                else if (userDOB.compareTo(String.valueOf(year)) > 0)
                {
                    Toast.makeText(MainActivity.this, "Year should be less than year.", Toast.LENGTH_SHORT).show();
                }
                else {
                    int myAge = year - Integer.parseInt(userDOB);
                    mAgeTv.setText("Your age is "  +myAge+ " year.");

                }
            }
        });



    }
}