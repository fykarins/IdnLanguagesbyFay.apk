package com.example.idnlanguagesbyfay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    private ArrayList<Language> listLanguage;
    private OnItemClickListener onItemClickListener;

    public LanguageAdapter(ArrayList<Language> list) {
        this.listLanguage = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout item_language.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_language, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Language language = listLanguage.get(position);
        holder.bind(language, onItemClickListener, position);
    }

    @Override
    public int getItemCount() {
        return listLanguage.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, itemDescription;
        ImageView itemPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.tv_item_name_1); // ID default untuk tampilan 1
            itemDescription = itemView.findViewById(R.id.tv_item_description_1); // ID default untuk tampilan 1
            itemPhoto = itemView.findViewById(R.id.img_item_photo_1); // ID default untuk tampilan 1
        }

        public void bind(Language language, OnItemClickListener listener, int position) {
            itemName.setText(language.getName());
            itemDescription.setText(language.getDescription());
            itemPhoto.setImageResource(language.getPhoto());

            // Sesuaikan ID berdasarkan posisi
            switch (position) {
                case 0:
                    // tampilan 1
                    break;
                case 1:
                    itemName.setId(R.id.tv_item_name_2);
                    itemDescription.setId(R.id.tv_item_description_2);
                    itemPhoto.setId(R.id.img_item_photo_2);
                    break;
                case 2:
                    itemName.setId(R.id.tv_item_name_3);
                    itemDescription.setId(R.id.tv_item_description_3);
                    itemPhoto.setId(R.id.img_item_photo_3);
                    break;
                // Tambahkan case sampai 9
                default:
                    // tampilan default jika diperlukan
                    break;
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Clicked: " + language.getName(), Toast.LENGTH_SHORT).show();

                    if (listener != null) {
                        listener.onItemClick(language);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Language language);
    }
}
