package com.blanyal.remindme;

import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by theDarkKnight on 11/18/15.
 */
public class ReminderEditActivityTest extends ActivityInstrumentationTestCase2<ReminderEditActivity> {
    public ReminderEditActivityTest(){
        super(ReminderEditActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Context context = this.getInstrumentation().getTargetContext().getApplicationContext();
        Intent i = new Intent(context, ReminderEditActivity.class);
        String mStringClickID = Integer.toString(-1);
        i.putExtra(ReminderEditActivity.EXTRA_REMINDER_ID, mStringClickID);
        setActivityIntent(i);
    }

    public void testActivityExists() {
        ReminderEditActivity activity = getActivity();
        assertNotNull(activity);
    }
}
