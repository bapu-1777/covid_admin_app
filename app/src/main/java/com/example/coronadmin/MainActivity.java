package com.example.coronadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText name,area,state,dis,pincode,phone,type,time,aveble;
    Button post,read;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        name=findViewById(R.id.name);
        area=findViewById(R.id.area);
        state=findViewById(R.id.state);
        dis=findViewById(R.id.dis);
        pincode=findViewById(R.id.pincode);
        phone=findViewById(R.id.phone);
        type=findViewById(R.id.type);
        time=findViewById(R.id.time);
        aveble=findViewById(R.id.avelable);

        post=findViewById(R.id.buttonput);
        read=findViewById(R.id.buttonread);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("tifin");

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kk(v);
            }
        });
    }
    private void kk(View view){
        String key=myRef.push().getKey();
        String data=name.getText().toString();
        String data1=area.getText().toString();
        String data2=state.getText().toString();
        String data3=dis.getText().toString();
        String data4=pincode.getText().toString();
        String data5=phone.getText().toString();
        String data6=type.getText().toString();
        String data7=time.getText().toString();
        String data8=aveble.getText().toString();

        Map<String,Object> req=new HashMap<>();
        req.put("name",data);
        req.put("pincode",data4);
        req.put("area",data1);
        req.put("available",data8);
        req.put("dis",data3);
        req.put("phone",data5);
        req.put("state",data2);
        req.put("time",data7);
        req.put("type",data6);

        myRef.child(key).setValue(req);

    }
}