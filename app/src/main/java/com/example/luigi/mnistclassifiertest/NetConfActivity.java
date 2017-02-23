package com.example.luigi.mnistclassifiertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import static com.example.luigi.mnistclassifiertest.MainActivity.net;

public class NetConfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_conf);
        TextView textView = (TextView) findViewById(R.id.textView4);
        //textView.setText(net.getDefaultConfiguration().toString());

    }
}
