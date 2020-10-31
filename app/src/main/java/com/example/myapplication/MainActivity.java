package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private TableLayout tableLayout;
    private ArrayList<String> fruits = new ArrayList<String>();
    String[][] tel = {{"홍길동", "01011112222"}, {"이도령","01033334444"}, {"김삿갓","01055556666"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TableLayout tableLayout = (TableLayout)findViewById(R.id.table);
        tableLayout.setShrinkAllColumns(true);

        for (int i = 0; i < 3; i++) {
            // Creation row
            final TableRow tableRow = new TableRow(this);

            for (int j = 0; j < 2; j++) {
                final Button tb = new Button(this);
                tb.setText(tel[i][j]);
                tb.setId(i);
                tb.setOnClickListener(MainActivity.this);

                tb.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                tableRow.addView(tb);
            }
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

            tableLayout.addView(tableRow);
        }
    }

    public void onClick(View arg0) {
        Toast.makeText(getApplicationContext(), arg0.getId() + " : " + "전화걸기 버튼입니다", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_DIAL);
        int t = arg0.getId();

        intent.setData(Uri.parse("tel:" + tel[t][1]));
        startActivity(intent);
    }
}
