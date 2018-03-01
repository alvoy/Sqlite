package newandroid.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alvaro on 2/28/18.
 */

public class PersonasSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "personas.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PERSONAS = "personas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_ID_DEP = "id_dep";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_PERSONAS + " (" +
             COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
             COLUMN_NOMBRE + " TEXT, "+
             COLUMN_APELLIDO + " TEXT, "+
             COLUMN_ID_DEP + " INTEGER "+")";


    public PersonasSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            Log.i("LOGTAG","Tabla creada personas");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST " + TABLE_PERSONAS);
            onCreate(db);

    }
}
