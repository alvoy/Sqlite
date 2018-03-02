package newandroid.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alvaro on 3/2/18.
 */

public class ClaseAuxiliarSQLiteOpenHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "aux.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_DEPTOS = "aux";
    public static final String COLUMN_ID_AUX = "id_aux";

    public ClaseAuxiliarSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
