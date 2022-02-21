package com.example.dayfiveiti_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dayfiveiti_sqllite.database.DatabaseAdapter;
import com.example.dayfiveiti_sqllite.database.Model;

public class second extends AppCompatActivity {

    Button btnBack;
    TextView tvName ,tvPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnBack=findViewById(R.id.btn_back);
        tvName=findViewById(R.id.tv_name_2);
        tvPhone=findViewById(R.id.tv_phone_2);

        DatabaseAdapter adapter =new DatabaseAdapter(this);
        Model result= adapter.getEntre();

        tvName.setText(result.getMessage());
        tvPhone.setText(result.getPhone());



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}