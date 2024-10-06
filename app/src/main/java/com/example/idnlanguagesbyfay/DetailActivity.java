package com.example.idnlanguagesbyfay;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetailPhoto;
    private TextView tvDetailName, tvDetailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ambil layout_id dari Intent
        int layoutId = getIntent().getIntExtra("layout_id", -1);
        if (layoutId != -1) {
            setContentView(layoutId);
        } else {
            // Log atau tangani jika layout_id tidak ditemukan
            Log.e("DetailActivity", "Layout ID not found");
        }


        // Inisialisasi komponen
        ivDetailPhoto = findViewById(R.id.iv_detail_photo);
        tvDetailName = findViewById(R.id.tv_detail_name);
        tvDetailDescription = findViewById(R.id.tv_detail_description);

        // Ambil data dari Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("language_name");
        String description = intent.getStringExtra("language_description");
        int photo = intent.getIntExtra("language_photo", 0);

        // Set data di View
        tvDetailName.setText(name);
        tvDetailDescription.setText(description);
        ivDetailPhoto.setImageResource(photo);

        // Inisialisasi tombol back
        ImageButton btnBack = findViewById(R.id.btn_back);

        // Set onClickListener untuk tombol back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke MainActivity
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Menutup DetailActivity agar tidak kembali ke sini ketika menekan tombol back di MainActivity
        super.onBackPressed();
        finish();
    }
}
