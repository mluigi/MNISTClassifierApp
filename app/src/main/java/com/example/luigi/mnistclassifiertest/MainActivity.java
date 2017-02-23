package com.example.luigi.mnistclassifiertest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static MultiLayerNetwork net;
    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = (CanvasView) findViewById(R.id.canvasView);
        canvasView.clearCanvas();

        try {
            Uri netFile = Uri.parse("android.resource://" + getPackageName() + "raw/net");
            System.out.println("AAAAAAAAAAAA\n"+netFile.getPath());
            net = ModelSerializer.restoreMultiLayerNetwork(new File(netFile.getPath()), true);
            Toast.makeText(this, "Net model loaded successfully.", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearCanvas(View view) {
        canvasView.clearCanvas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (net != null) {
            if (item.getItemId() == R.id.netItem) {
                startActivity(new Intent(this, NetConfActivity.class));
            }
        }
        return true;
    }
}