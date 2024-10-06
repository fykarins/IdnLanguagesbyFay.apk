package com.example.idnlanguagesbyfay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Language> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recycler_view_languages);
        recyclerView.setHasFixedSize(false);

        // Tambahkan data ke list
        list.add(new Language("DKI Jakarta", "Salah satu bahasa yang digunakan di Provinsi DKI Jakarta adalah bahasa ... ", R.drawable.main_1));
        list.add(new Language("DI Yogyakarta", "Salah satu bahasa yang digunakan di Provinsi DI Yogyakarta adalah bahasa ... ", R.drawable.main_2));
        list.add(new Language("Bali", "Salah satu bahasa yang digunakan di Provinsi Bali adalah bahasa ...", R.drawable.main_3));
        list.add(new Language("Banten", "Salah satu bahasa yang digunakan di Provinsi Banten adalah bahasa ... ", R.drawable.main_4));
        list.add(new Language("Sulawesi Tengah", "Salah satu bahasa yang digunakan di Provinsi Sulawesi Tengah adalah bahasa ... ", R.drawable.main_5));
        list.add(new Language("Kepulauan Riau", "Salah satu bahasa yang digunakan di Provinsi Kepulauan Riau adalah bahasa ...", R.drawable.main_6));
        list.add(new Language("Aceh", "Salah satu bahasa yang digunakan di Provinsi Aceh adalah bahasa ...", R.drawable.main_7));
        list.add(new Language("Kalimantan Tengah", "Salah satu bahasa yang digunakan di Provinsi Kalimantan Tengah adalah bahasa ... ", R.drawable.main_8));
        // Log to check data
        Log.d("DATA", list.toString());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LanguageAdapter languageAdapter = new LanguageAdapter(list);
        recyclerView.setAdapter(languageAdapter);

        languageAdapter.setOnItemClickListener(new LanguageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Language language) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                // Mengirimkan layout_id yang sesuai berdasarkan item yang diklik
                switch (language.getName()) {
                    case "DKI Jakarta":
                        intent.putExtra("layout_id", R.layout.activity_detail1);
                        break;
                    case "DI Yogyakarta":
                        intent.putExtra("layout_id", R.layout.activity_detail2);
                        break;
                    case "Bali":
                        intent.putExtra("layout_id", R.layout.activity_detail3);
                        break;
                    case "Banten":
                        intent.putExtra("layout_id", R.layout.activity_detail4);
                        break;
                    case "Sulawesi Tengah":
                        intent.putExtra("layout_id", R.layout.activity_detail5);
                        break;
                    case "Kepulauan Riau":
                        intent.putExtra("layout_id", R.layout.activity_detail6);
                        break;
                    case "Aceh":
                        intent.putExtra("layout_id", R.layout.activity_detail7);
                        break;
                    case "Kalimantan Tengah":
                        intent.putExtra("layout_id", R.layout.activity_detail8);
                        break;
                    default:
                        Log.d("DEBUG", "Item yang diklik tidak ada dalam daftar.");
                        return;
                }

                // Kirim data lainnya
                intent.putExtra("language_name", language.getName());
                intent.putExtra("language_description", language.getDescription());
                intent.putExtra("language_photo", language.getPhoto());

                // Log untuk memastikan intent sudah siap
                Log.d("DEBUG", "Opening detail for: " + language.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.profile_icon) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
