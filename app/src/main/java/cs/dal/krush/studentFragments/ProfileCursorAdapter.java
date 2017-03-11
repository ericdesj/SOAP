package cs.dal.krush.studentFragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cs.dal.krush.R;

/**
 * This is the adapter class for the customized rows in the 'Book a Tutor'
 * list view on the student home page
 */
public class ProfileCursorAdapter extends CursorAdapter {

    //store the context set in the constructor
    private Context mContext;

    /**
     * Constructor
     *
     * @param context
     * @param cursor
     */
    public ProfileCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
        this.mContext = context;
    }

    /**
     * Overrides the newView method used to inflate a new view and return it.
     *
     * @param context
     * @param cursor
     * @param parent
     * @return
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.student_home_listentry, parent, false);
    }

    /**
     * Overrides the bindView method used to bind all data to a given view.
     *
     * @param view
     * @param context
     * @param cursor
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor){
        //fetch UI components:
        TextView text1 = (TextView)view.findViewById(R.id.firstLine);
        TextView text2 = (TextView)view.findViewById(R.id.secondLine);
        ImageView image = (ImageView)view.findViewById(R.id.icon);

        //Get the tutor's profile image:
        String imageFileName = cursor.getString(cursor.getColumnIndexOrThrow("profile_pic"));
        if (imageFileName != null){
            int resourceId = mContext.getResources().getIdentifier(
                    imageFileName, "drawable", mContext.getPackageName());
            image.setImageResource(resourceId);
        }


        //Get the tutor's name:
        String tutorFirstName = cursor.getString(cursor.getColumnIndexOrThrow("f_name"));
        String tutorLastName = cursor.getString(cursor.getColumnIndexOrThrow("l_name"));
        String tutorName = tutorFirstName + " " + tutorLastName;
        text1.setText(tutorName);

        //Get the tutor's rate and subject:
        String tutorRate = cursor.getString(cursor.getColumnIndexOrThrow("rate"));
        String text2content = "Rate: " + tutorRate;
        text2.setText(text2content);
    }
}
