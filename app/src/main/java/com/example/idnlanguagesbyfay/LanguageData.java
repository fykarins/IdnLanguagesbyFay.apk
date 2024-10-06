package com.example.idnlanguagesbyfay;

import java.util.ArrayList;

public class LanguageData {
    public static String[][] data = new String[][]{
            {"DKI Jakarta", "Salah satu bahasa yang digunakan di Provinsi DKI Jakarta adalah bahasa ...", "main_1"},
            {"DI Yogyakarta", "Salah satu bahasa yang digunakan di Provinsi DI Yogyakarta adalah bahasa ...", "main_2"},
            {"Bali", "Salah satu bahasa yang digunakan di Provinsi Bali adalah bahasa ...", "main_3"},
            {"Banten", "Salah satu bahasa yang digunakan di Provinsi Banten adalah bahasa ...", "main_4"},
            {"Sulawesi Tengah", "Salah satu bahasa yang digunakan di Provinsi Sulawesi Tengah adalah bahasa ...", "main_5"}
    };

    public static ArrayList<Language> getListData() {
        ArrayList<Language> list = new ArrayList<>();
        for (String[] aData : data) {
            Language language = new Language();
            language.setName(aData[0]);
            language.setDescription(aData[1]);
            int photoId = getDrawableId(aData[2]);
            language.setPhoto(photoId);
            list.add(language);
        }
        return list;
    }

    private static int getDrawableId(String name) {
        switch (name) {
            case "main_1":
                return R.drawable.main_1;
            case "main_2":
                return R.drawable.main_2;
            case "main_3":
                return R.drawable.main_3;
            case "main_4":
                return R.drawable.main_4;
            case "main_5":
                return R.drawable.main_5;
            default:
                return R.drawable.placeholder;
        }
    }
}
