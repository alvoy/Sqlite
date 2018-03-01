package newandroid.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alvaro on 2/28/18.
 */

public class DepartamentosSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "departamentos.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_DEPTOS = "departamentos";
    public static final String COLUMN_ID_DEP = "id_dep";
    public static final String COLUMN_DEPARTAMENTO = "departamento";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_DEPTOS + " (" +
             COLUMN_ID_DEP + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
             COLUMN_DEPARTAMENTO + " TEXT "+")";


    public DepartamentosSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            Log.i("LOGTAG","Tabla creada deptos");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPTOS);
            onCreate(db);

    }
}
