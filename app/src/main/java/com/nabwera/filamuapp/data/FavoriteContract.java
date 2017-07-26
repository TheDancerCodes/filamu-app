package com.nabwera.filamuapp.data;

import android.provider.BaseColumns;

/**
 * Created by nabwera on 25/07/2017.
 */

public class FavoriteContract {

    // Setting up the column and table name of DB
    public static final class FavoriteEntry implements BaseColumns{
        public static final String TABLE_NAME = "favorite";
        public static final String COLUMN_MOVIEID = "movieid";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_USERRATING = "userrating";
        public static final String COLUMN_POSTER_PATH = "posterpath";
        public static final String COLUMN_PLOT_SYNOPSIS = "overview";

    }
}
