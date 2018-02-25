package android.example.com.one_1202154320_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by One Tika Suryati on 2/24/2018.
 */

public class Water {
    private final String title; //inisialisasi variabel title
    private final String info; //inisialisasi variabel info
    private final int imageResource; //inisialisasi variabel gambar

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    Water(String title, String info, int imageResource) {
        //ngambil nilai title, info dan image dari kelas ini
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    /**
     * Gets the title of the sport
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    } // set string title dan return
    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    } // set string info dan return

    /**
     * Gets the resource for the image
     * @return The resource for the image
     */
    int getImageResource() { // set int image dan return

        return imageResource;
    }

    /**
     * Method for creating  the Detail Intent
     * @param context Application context, used for launching the Intent
     * @param title The title of the current Sport
     * @param imageResId The image resource associated with the current sport
     * @return The Intent containing the extras about the sport, launches Detail activity
     */
    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class); //merujuk ke kelas detail
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}

