package com.cihan.newsfeedbycihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FirstScreenActivity extends AppCompatActivity {

    private TextView mBtnCumhuriyet;
    private TextView mBtnBBC;
    private TextView mBtnBirgun;
    private TextView mBtnFutbol;
    private TextView mBtnCanliHaber;
    private TextView mBtnCnnTurk;
    private TextView mBtnSputnik;

    public void init(){
        mBtnCumhuriyet = (TextView) findViewById(R.id.btnCumhuriyet);
        mBtnBBC = (TextView) findViewById(R.id.btnBBC);
        mBtnBirgun = (TextView) findViewById(R.id.btnBirgün);
        mBtnFutbol = (TextView) findViewById(R.id.btnFutbol);
        mBtnCanliHaber = (TextView) findViewById(R.id.btnCanliHaber);
        mBtnCnnTurk = (TextView) findViewById(R.id.btnCnnTurk);
        mBtnSputnik = (TextView) findViewById(R.id.btnSputnik);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        init();

        mBtnCumhuriyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://www.cumhuriyet.com.tr/rss/son_dakika.xml");
                startActivity(intent);

            }
        });

        mBtnBBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://feeds.bbci.co.uk/turkce/rss.xml");
                startActivity(intent);

            }
        });

        mBtnBirgun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://www.birgun.net/xml/rss.xml");
                startActivity(intent);

            }
        });

        mBtnFutbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://www.futbolsayfasi.net/rss.php");
                startActivity(intent);

            }
        });

        mBtnCanliHaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://www.canlihaber.com/rss");
                startActivity(intent);

            }
        });

        mBtnCnnTurk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://www.cnnturk.com/feed/rss/all/news");
                startActivity(intent);

            }
        });

        mBtnSputnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this,MainActivity.class);
                intent.putExtra("site", "https://tr.sputniknews.com/export/rss2/archive/index.xml");
                startActivity(intent);

            }
        });
    }
}