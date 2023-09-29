package com.example.applicationnews;

import android.content.Context;
import android.content.Intent;

public class Utils {
    public static void shareLink(Context context, String link) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "App News");
            shareIntent.putExtra(Intent.EXTRA_TEXT, link);
            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }
}
