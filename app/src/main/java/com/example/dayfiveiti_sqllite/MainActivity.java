package com.example.dayfiveiti_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dayfiveiti_sqllite.database.DatabaseAdapter;
import com.example.dayfiveiti_sqllite.database.Model;

public class MainActivity extends AppCompatActivity {
    Button btnNext ,btnClose;
    EditText edtName,edtPhone;
    String name,phone;
    Intent outIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName=findViewById(R.id.edt_name);
        edtPhone=findViewById(R.id.edt_phone);
        btnNext=findViewById(R.id.btn_next);
        btnClose=findViewById(R.id.btn_close);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=edtName.getText().toString();
                phone=edtPhone.getText().toString();
                DatabaseAdapter adapter =new DatabaseAdapter(MainActivity.this);
                adapter.insertEntity(new Model(name,phone));

                outIntent=new Intent(MainActivity.this,second.class);
                startActivity(outIntent);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}