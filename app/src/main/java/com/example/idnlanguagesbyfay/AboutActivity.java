package com.example.idnlanguagesbyfay;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    private ImageView imgAboutPhoto;
    private TextView tvAboutName, tvAboutEmail;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imgAboutPhoto = findViewById(R.id.img_about_photo);
        tvAboutName = findViewById(R.id.tv_about_name);
        tvAboutEmail = findViewById(R.id.tv_about_email);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setZ(1);

        // Set image, name, and email
        imgAboutPhoto.setImageResource(R.drawable.about_1);
        tvAboutName.setText("FAY IVANA KARIN");
        tvAboutEmail.setText("a001b4kx1460@dicoding.academy");

        // Back button functionality
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log untuk memastikan tombol bekerja
                Log.d("AboutActivity", "Back button clicked");

                // Berpindah ke MainActivity
                Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Menutup AboutActivity
            }
        });
    }
}
