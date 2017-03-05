package cs.dal.krush.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by greg on 27/02/17.
 */

public class School extends Table{

    public School(SQLiteDatabase dbWrite, SQLiteDatabase dbRead){
        super(dbWrite,dbRead);
    }

    /**
     * Insert row into schools table
     * @param name
     * @param locationId
     * @param type
     * @return boolean
     */
    public boolean insert(String name, int locationId, String type){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("location_id", locationId);
        contentValues.put("type", type);
        dbWrite.insert("schools", null, contentValues);
        return true;
    }

    @Override
    public Cursor getData(int id){
        res = dbRead.rawQuery("SELECT * FROM schools WHERE id="+id+"",null);
        return res;
    }

    @Override
    public Cursor getAll() {
        res = dbRead.rawQuery("SELECT * FROM schools",null);
        return res;
    }

    /**
     * Get a school by the name field
     * @param name
     * @return Cursor
     */
    public Cursor getDataByName(String name){
        res = dbRead.rawQuery("SELECT * FROM schools WHERE name="+name+"",null);
        return res;
    }

    /**
     * Get a school by the type field
     * @param type
     * @return Cursor
     */
    public Cursor getDataByType(String type){
        res = dbRead.rawQuery("SELECT * FROM schools WHERE type="+type+"",null);
        return res;
    }

    /**
     * Get a school by the location_id field
     * @param location_id
     * @return Cursor
     */
    public Cursor getSchoolsByLocation(int location_id){
        res = dbRead.rawQuery("SELECT * FROM schools WHERE location_id="+location_id+"",null);
        return res;
    }

    /**
     * Delete a school by id
     * @param id
     * @return int
     */
    public int deleteSchool(int id){
        return dbWrite.delete("schools","id = ?",new String[] { Integer.toString(id) });
    }

}
