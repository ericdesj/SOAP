package cs.dal.krush.seeders;

import android.content.Context;
import android.database.Cursor;

import cs.dal.krush.models.DBHelper;

/**
 * Created by greg on 27/02/17.
 */

public class DatabaseSeeder {
    /**
     * Declare variables
     */
    DBHelper mydb;
    Object[] args;
    Context context;

    /**
     * Empty constructor
     * @param context
     */
    public DatabaseSeeder(Context context){
        this.context = context;
    }

    /**
     * Seed data into database
     */
    public void insertData() {
        //instantiate DBHelper
        mydb = new DBHelper(context);

        /**
         * Insert data
         */
        LocationSeeder.insert(mydb);
        SchoolSeeder.insert(mydb);
        TutorSeeder.insert(mydb);
        StudentSeeder.insert(mydb);
        TutoringSessionSeeder.insert(mydb);
        CourseSeeder.insert(mydb);
        AudioRecordingSeeder.insert(mydb);
        CoursesTutorsSeeder.insert(mydb);

    } //end method

    /**
     * Display data inserted by seeders
     */
    public void displayData(){

        //instantiate DBHelper
        mydb = new DBHelper(context);

        /**
         * Get and display data
         */
        Cursor rs;
        rs = mydb.audioRecording.getData(1);
        rs.moveToFirst();
        String s;
        s = rs.getString(rs.getColumnIndex("location_id"));
        System.out.println(s);
        if (!rs.isClosed()) {
            rs.close();
        }

        rs = mydb.location.getLocationBySchool(1);
        rs.moveToFirst();
        s = rs.getString(rs.getColumnIndex("location"));
        System.out.println("LOCATION:" + s);
        if (!rs.isClosed()) {
            rs.close();
        }

        rs = mydb.course.getData(1);
        rs.moveToFirst();
        s = rs.getString(rs.getColumnIndex("course_code"));
        System.out.println(s);
        if (!rs.isClosed()) {
            rs.close();
        }

        rs = mydb.school.getData(1);
        rs.moveToFirst();
        s = rs.getString(rs.getColumnIndex("name"));
        System.out.println(s);
        if (!rs.isClosed()) {
            rs.close();
        }

        rs = mydb.tutor.getData(1);
        rs.moveToFirst();
        s = rs.getString(rs.getColumnIndex("f_name"));
        System.out.println(s);
        if (!rs.isClosed()) {
            rs.close();
        }
    }

} // end class