package com.example.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText editurl;
    private EditText editlokasi;
    private EditText editstatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editurl =findViewById(R.id.edit_url);
        editstatus =findViewById(R.id.edit_status);
        editlokasi =findViewById(R.id.edit_lokasi);

    }


    public void shareText(View view) {
        String share = editstatus.getText().toString();
        ShareCompat.IntentBuilder
                .from( this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(share)
                .startChooser();

    }

    public void cariLokasi(View view) {
        String lokasi = editlokasi.getText().toString();
        Uri address = Uri.parse( "geo:0,0?q=" +lokasi);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(intent);
    }


    public void openWebsite(View view) {
        String url = editurl.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);

    }
}