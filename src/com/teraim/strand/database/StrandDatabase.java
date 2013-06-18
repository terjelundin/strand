package com.teraim.strand.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * 
 * @author Terje
 *
 * A database to use with Strand. 
 */

public class StrandDatabase extends SQLiteOpenHelper {
	
	//Database Constructs. This is strict.
	private static final String TEXT_TYPE = " TEXT";
	//TEXT type is also used for DATE type.
	private static final String DATE_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Strand.db";

    public StrandDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    
	private static final String SQL_CREATE_MAIN_TABLE =
		    "CREATE TABLE " + StrandContract.MainTable.TABLE_NAME + " (" +
		    		StrandContract.MainTable._ID + " INTEGER PRIMARY KEY," +
		    		StrandContract.COLUMN_NAME_RUTA_ID + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.COLUMN_NAME_PROVYTA_ID + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_LAG_ID + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_INVENTOR + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_DATE + DATE_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_INVENT_TYPE + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_REASON + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_STRAND_TYPE + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_COAST_TYPE + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_TREE_DENSITY + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.MainTable.COLUMN_NAME_EXP + TEXT_TYPE +
		    		" )";

	private static final String SQL_CREATE_TRANSECT_TABLE =
		    "CREATE TABLE " + StrandContract.TransectTable.TABLE_NAME + " (" +
		    		StrandContract.TransectTable._ID + " INTEGER PRIMARY KEY," +
		    		StrandContract.COLUMN_NAME_RUTA_ID + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.COLUMN_NAME_PROVYTA_ID + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_VATTENDISTRIKT + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		StrandContract.TransectTable.COLUMN_NAME_ + TEXT_TYPE + COMMA_SEP +
		    		
		    		
		    		
		    		" )";
	
	
	
		private static final String SQL_DELETE_MAIN_TABLE =
		    "DROP TABLE IF EXISTS " + StrandContract.MainTable.TABLE_NAME;

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SQL_CREATE_MAIN_TABLE);
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(SQL_DELETE_MAIN_TABLE);
	        onCreate(db);
		}

		
		public void insertHeader(ArrayList<String> parameters) {
		
			
		ContentValues values = new ContentValues();
	    values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
	    long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
	        values);
		}
		

private static class StrandContract {
	private StrandContract() {}
	
	//Ruta, provyta, lagnr, etc are generic names used for all columns in all tables.
	public static final String COLUMN_NAME_RUTA_ID = "ruta";
	public static final String COLUMN_NAME_PROVYTA_ID = "provyta";
	//Identifies the group responsible for collecting data.
	public static final String COLUMN_NAME_LAG_ID = "lagnr";
	public static final String COLUMN_NAME_YEAR = "year";

	/**
	 * 
	 * @author Terje
	 * Main table contains variables in the scope RUTA_PROVYTA.
	 */
	public static abstract class MainTable implements BaseColumns {
		public static final String TABLE_NAME = "oversikt";
		///////////
		public static final String COLUMN_NAME_VATTENDISTRIKT = "vattendistrikt";
		public static final String COLUMN_NAME_NAMN = "namn";
		public static final String COLUMN_NAME_BIOGEO = "biogeo";
		public static final String COLUMN_NAME_URVALSKLASS = "urvalsklass";
		public static final String COLUMN_NAME_EXPLOATERING = "exploatering";
		public static final String COLUMN_NAME_STRANDTYP = "strandtyp";
		public static final String COLUMN_NAME_KUSTTYP = "kusttyp";		
		public static final String COLUMN_NAME_VAGEXP = "vagexponering";
		public static final String COLUMN_NAME_EASTING = "east";
		public static final String COLUMN_NAME_NORTHING = "north";
//		public static final String COLUMN_NAME_INVENTOR = "inventerare";
//		public static final String COLUMN_NAME_DATE = "datum";
//		public static final String COLUMN_NAME_INVENT_TYPE = "invent_typ";
//		public static final String COLUMN_NAME_REASON = "orsak";
//		public static final String COLUMN_NAME_TREE_DENSITY = "forekomst";
//		public static final String COLUMN_NAME_EXP = "exponering";
	}
	
	/**
	 * 
	 * @author Terje
	 * Transect table contains variables in the scope RUTA_PROVYTA_TRANSEKT
	 * 
	 * Standard columns:
	 * ID
	 * YEAR
	 * RUTA
	 * PROVYTA
	 *  
	 */
	
	
	public static abstract class TransectTable implements BaseColumns {
		public static final String TABLE_NAME = "transekt";
		///////////
		//TODO: Is this really per transect?
		public static final String COLUMN_NAME_LAG = "lagnr";
		//TODO: Is this really per transect?
		public static final String COLUMN_NAME_INVENTERARE = "inventerare";
		public static final String COLUMN_NAME_DATE = "datum";
		public static final String COLUMN_NAME_INVENT_TYP = "inventeringstyp";
		public static final String COLUMN_NAME_REASON = "orsak";
		//TODO: THESE COLUMNS ARE REPEATED?
		public static final String COLUMN_NAME_STRANDTYP = "strandtyp";
		public static final String COLUMN_NAME_KUSTTYP = "kusttyp";		
		//
		public static final String COLUMN_NAME_TRADFOREKOMST = "tradforekomst";
		public static final String COLUMN_NAME_EXPONERING = "exponering";	
		public static final String COLUMN_NAME_GPS_EAST= "gpseast";
		public static final String COLUMN_NAME_GPS_NORTH = "gpsnorth";	

		public static final String COLUMN_NAME_RIKTNING = "riktning";

		//SLUTLEN?
		public static final String COLUMN_NAME_SLUTLENGEO = "slutlengeo";	
		public static final String COLUMN_NAME_SLUTLENORANGE = "slutlenorange";	
		public static final String COLUMN_NAME_SLUTLENKAL = "slutlenkal";	
		public static final String COLUMN_NAME_SLUTLENSUPRA = "slutlensupra";	
		public static final String COLUMN_NAME_SLUTLENOVAN = "slutlenovan";	

		public static final String COLUMN_NAME_LUTNINGGEO = "lutninggeo";	
		public static final String COLUMN_NAME_LUTNINGSUPRA = "lutningsupra";	
		
		public static final String COLUMN_NAME_VATTENDJUP = "vattendjup";	
	
		public static final String COLUMN_NAME_MARKTYPGEO = "marktypgeo";	
		public static final String COLUMN_NAME_MARKTYPSUPRA = "marktypsupra";	
		public static final String COLUMN_NAME_MARKTYPOVAN = "marktypovan";	
		
		public static final String COLUMN_NAME_REKREATION = "rektreation";	
		public static final String COLUMN_NAME_ROJNING = "rojning";	
		public static final String COLUMN_NAME_ROJNINGTID = "rojningtid";	
		public static final String COLUMN_NAME_BRYGGA = "brygga";	
		public static final String COLUMN_NAME_STANGSEL = "stangsel";	
		
		//Täckning?
		public static final String COLUMN_NAME_TACKN_FALT_GEO = "tacknfaltgeo";	
		public static final String COLUMN_NAME_TACKN_FALT_SUPRA = "tacknfaltsupra";	
		
		public static final String COLUMN_NAME_TACKN_BUSK_GEO = "tacknbuskgeo";	
		public static final String COLUMN_NAME_TACKN_BUSK_SUPRA = "tacknbusksupra";	

		public static final String COLUMN_NAME_TACKN_TRAD_GEO = "tackntradgeo";	
		public static final String COLUMN_NAME_TACKN_TRAD_SUPRA = "tackntradsupra";	

		//vass
		public static final String COLUMN_NAME_VASSLEN = "vasslen";	
		public static final String COLUMN_NAME_VASSTATHET = "vasstathet";	
		//kriterie
		public static final String COLUMN_NAME_KRITERIE = "kriteriestrand";	
		public static final String COLUMN_NAME_KRITERIE_OVAN = "kriterieovan";	
		//klippa
		public static final String COLUMN_NAME_KLIPPA_MAX = "klippamax";	
		public static final String COLUMN_NAME_KLIPPA_LUT = "klippalutning";	
	}	
	

	/**
	 * 
	 * @author Terje
	 * Substrat table contains variables in the scope PROVYTA
	 * 
	 * Standard columns:
	 * ID
	 * YEAR
	 * RUTA
	 * PROVYTA
	 *  
	 */
	
	
	public static abstract class TransectTable implements BaseColumns {
		public static final String TABLE_NAME = "substrat";
		///////////
		//TODO: IS 
	}
}
}