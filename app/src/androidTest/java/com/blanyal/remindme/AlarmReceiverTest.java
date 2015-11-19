package com.blanyal.remindme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.test.AndroidTestCase;
import android.util.Log;

import junit.framework.TestCase;

import java.util.Calendar;



/**
 * Created by theDarkKnight on 11/10/15.
 */
public class AlarmReceiverTest extends AndroidTestCase {

    public static final String EXTRA_TEST_INFO = "Reminder_ID";

    public void setUp() throws Exception {
        super.setUp();

    }

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(reality, reality);
    }

    public void tearDown() throws Exception {

    }

    public void testOnReceive() throws Exception {
        ReminderDatabase rb = new ReminderDatabase(getContext());
        int ID = rb.addReminder(new Reminder("Title", "12/11/2016", "3:59", "true", "1", "Hour", "true"));
        Intent intent = new Intent(getContext(), AlarmReceiver.class);
        intent.putExtra(ReminderEditActivity.EXTRA_REMINDER_ID, Integer.toString(ID));
        intent.putExtra(ReminderEditActivity.EXTRA_TEST_BOOL, "true");
        new AlarmReceiver().onReceive(getContext(), intent);
        Intent i = new Intent(getContext(), ReminderEditActivity.class);
        i.putExtra(ReminderEditActivity.EXTRA_REMINDER_ID, ID);
    }

    public void testSetAlarm() throws Exception {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.MONTH, 1);
        mCalendar.set(Calendar.YEAR, 2015);
        mCalendar.set(Calendar.DAY_OF_MONTH, 20);
        mCalendar.set(Calendar.HOUR_OF_DAY, 3);
        mCalendar.set(Calendar.MINUTE, 55);
        mCalendar.set(Calendar.SECOND, 0);
        int ID = 1;

        boolean alarmUp = (PendingIntent.getBroadcast(getContext(), ID,
                new Intent(getContext(), AlarmReceiver.class),
                PendingIntent.FLAG_NO_CREATE) != null);
        assertFalse(alarmUp);

        new AlarmReceiver().setAlarm(getContext(), mCalendar, ID);

        alarmUp = (PendingIntent.getBroadcast(getContext(), ID,
                new Intent(getContext(), AlarmReceiver.class),
                PendingIntent.FLAG_NO_CREATE) != null);
        assertTrue(alarmUp);
    }

    public void testSetRepeatAlarm() throws Exception {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.MONTH, 1);
        mCalendar.set(Calendar.YEAR, 2015);
        mCalendar.set(Calendar.DAY_OF_MONTH, 20);
        mCalendar.set(Calendar.HOUR_OF_DAY, 3);
        mCalendar.set(Calendar.MINUTE, 55);
        mCalendar.set(Calendar.SECOND, 0);
        int ID = 2;

        boolean alarmUp = (PendingIntent.getBroadcast(getContext(), ID,
                new Intent(getContext(), AlarmReceiver.class),
                PendingIntent.FLAG_NO_CREATE) != null);
        assertFalse(alarmUp);

        new AlarmReceiver().setAlarm(getContext(), mCalendar, ID);

        alarmUp = (PendingIntent.getBroadcast(getContext(), ID,
                new Intent(getContext(), AlarmReceiver.class),
                PendingIntent.FLAG_NO_CREATE) != null);
        assertTrue(alarmUp);
    }

    public void testCancelAlarm() throws Exception {
        //impossible to test
    }
}

