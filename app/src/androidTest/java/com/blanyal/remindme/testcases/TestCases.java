package com.blanyal.remindme.testcases;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.blanyal.remindme.MainActivity;
import com.blanyal.remindme.R;
import com.blanyal.remindme.testoperations.Functions;
import com.robotium.solo.Solo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Shankar on 9/23/2015.
 */

// References https://github.com/RobotiumTech/robotium/wiki/Getting-Started

public class TestCases {

    Functions functions;

    //Test case id: 31
    //Test case for creating a reminder
    public void testCreateRemindly(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {
            functions.clickOnView(solo, R.id.add_reminder);
        } else {
            Log.e("WRONG_SCREEN", "wrong screen landed");
        }
        if (functions.isActivityExists(solo, R.id.reminder_title)) {
            functions.enterReminderText(solo, R.id.reminder_title, "FirstTestCase-Reminder");
            functions.clickOnView(solo, R.id.save_reminder);
            //functions.verifyIfReminderisCreated(solo, "FirstTestCase-Reminder");
        } else {
            Log.e("WRONG_SCREEN", "Reminder screen Failed");
        }

    }

    //Test case id: 32
    //Test case for deleting a specific reminder
    public void testDeleteRemindly(Solo solo) throws InterruptedException {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();
            solo.clickLongInRecycleView(0);
            functions.clickOnView(solo, R.id.discard_reminder);
            Log.d("count", String.valueOf(count));
        }

    }

    //Test case id: 33
    //Test case for deleting all reminders
    public void testDeleteAllRemindly(Solo solo) throws InterruptedException {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();
            for (int i = 0; i < count; i++) {
                solo.clickLongInRecycleView(0);
                functions.clickOnView(solo, R.id.discard_reminder);
            }
            Log.d("count", String.valueOf(count));
        }

    }

    //Test case id: 34
    //Test case for changing reminder title
    public void testRemindlyTitle(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clearEditText((EditText) solo.getView(R.id.reminder_title));
            solo.enterText((EditText) solo.getView(R.id.reminder_title), "newTitle");
            functions.clickOnView(solo, R.id.save_reminder);
        }
    }

    //Test case id: 35
    //Test case for changing reminder time
    public void testTime(Solo solo) {
        functions = new Functions();
        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.time));

            //Sleep for 5476 milliseconds
            solo.sleep(300);
            //android.widget.TextView textviewDate = (android.widget.TextView) solo.getView(android.widget.TextView.class,0);
            //solo.enterText((EditText) textviewDate,"13");

            //solo.enterText((EditText) textview,"13");
            // solo.clickOnView(textview);
            ArrayList<View> vs = solo.getCurrentViews();
//                solo.clickOnView(solo.getView("time_picker", 4));
            solo.clickOnView(solo.getView(android.view.View.class, 9));

            solo.clickOnView(solo.getView(android.view.View.class, 10));//clicks am
            //solo.clickOnView(solo.getView(android.view.View.class, 11));//clicks pm
            solo.clickOnText("OK");

                /*ArrayList<View> vs = solo.getCurrentViews();
                solo.clickOnView(vs.get(19));
                solo.clickOnView(vs.get(20));
                solo.clickOnText("OK");
*/
            functions.clickOnView(solo, R.id.save_reminder);
        }
    }

    //Test case id: 36
    //Test case for selecting date from calendar after today's date
    public void testCalendarAfterDate(Solo solo) throws ParseException {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.date));

            solo.waitForDialogToOpen(5000);

            solo.clickOnView(solo.getView("date_picker_year"));
            //Sleep for 5476 milliseconds
            solo.sleep(300);

            //Scroll to 2017
            android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
            solo.scrollListToLine(listView0, 116);

            //Click on 2017
            solo.clickOnView(solo.getView("month_text_view", 4));
            solo.sleep(5000);
            solo.clickOnView(solo.getView(android.view.View.class, 10));

            android.widget.ListView listView1 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
            solo.scrollListToLine(listView1, 1451);
            solo.sleep(2000);
            solo.clickOnView(solo.getView(android.view.View.class, 12));
            //Click on OK
            solo.clickOnView(solo.getView("ok"));
            solo.clickOnView(solo.getView("save_reminder"));

        }
    }

    //Test case id: 37
    //Test case for selecting repetition types per minute from dropdown list
    public void testRepetitionTypesMinute(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.RepeatType));
            solo.clickInList(0);// for day
            functions.clickOnView(solo, R.id.save_reminder);


        }
    }

    //Test case id: 38
    //Test case for selecting repetition types per hour from dropdown list
    public void testRepetitionTypesHour(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.RepeatType));
            solo.clickInList(1);// for day
            functions.clickOnView(solo, R.id.save_reminder);


        }
    }

    //Test case id: 39
    //Test case for selecting repetition types per day from dropdown list
    public void testRepetitionTypesDay(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.RepeatType));
            solo.clickInList(2);// for day
            functions.clickOnView(solo, R.id.save_reminder);


        }
    }

    //Test case id: 40
    //Test case for selecting repetition types per week from dropdown list
    public void testRepetitionTypesWeek(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.RepeatType));
            solo.clickInList(3);// for day
            functions.clickOnView(solo, R.id.save_reminder);


        }
    }

    //Test case id: 41
    //Test case for selecting repetition types per month from dropdown list
    public void testRepetitionTypesMonth(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.RepeatType));
            solo.clickInList(4);// for month
            functions.clickOnView(solo, R.id.save_reminder);


        }
    }

    //Test case id: 42
    //Test case for selecting changing repetition interval
    public void testRepetitionInterval(Solo solo) {
        functions = new Functions();

        solo.assertCurrentActivity("Inside main activity", MainActivity.class);
        RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
        int count = view.getAdapter().getItemCount();

        for (int i = 0; i < count; i++) {
            solo.clickInRecyclerView(i);
            solo.clickOnView(solo.getView(R.id.RepeatNo));
            solo.enterText(0, String.valueOf(2));
            solo.clickOnButton(1);
            functions.clickOnView(solo, R.id.save_reminder);
        }

    }

    //Test case id: 43
    //Test case for discarding any saved changes by user
    public void testDiscardChanges(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {
            solo.clickInRecyclerView(0);
            solo.clearEditText((EditText) solo.getView(R.id.reminder_title));
            solo.enterText((EditText) solo.getView(R.id.reminder_title), "newTitle");
            functions.clickOnView(solo, R.id.discard_reminder);
        }

    }


    //Test case id: 44
    //Test case for disabling mute
    public void testDisableMute(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {
            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.starred2));
            functions.clickOnView(solo, R.id.save_reminder);
        }
    }

    //Test case id: 45
    //Test case for enabling mute
    public void testEnableMute(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {
            // RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            // int count = view.getAdapter().getItemCount();
            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.starred1));
            functions.clickOnView(solo, R.id.save_reminder);
        }
    }

    //Test case id: 46
    //Test case for enabling repeat switch
    public void testRepeatSwitchRepeatedOff(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.repeat_switch));

            functions.clickOnView(solo, R.id.save_reminder);
        }
    }

    //Test case id: 47
    //Test case for disabling repeat switch
    public void testRepeatSwitchRepeatedOn(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.repeat_switch));

            functions.clickOnView(solo, R.id.save_reminder);
        }
    }

    //Test case id: 48
    //Test case for checking license
    public void testLicense(Solo solo) {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {
            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            // solo.clickOnMenuItem("Licenses");
            solo.pressMenuItem(0);
            solo.clickOnText("Licenses");
        }

    }

    //Test case id: 49
    //Test case for selecting date from calendar for today's date
    public void testCalendarTodayDate(Solo solo) throws ParseException {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);
            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            int count = view.getAdapter().getItemCount();

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.date));

            solo.waitForDialogToOpen(5000);

            solo.clickOnView(solo.getView("date_picker_year"));
            //Sleep for 5476 milliseconds
            solo.sleep(300);


            //Click on OK
            solo.clickOnView(solo.getView("ok"));
            solo.clickOnView(solo.getView("save_reminder"));

        }
    }


    //Test case id: 50
    //Test case for selecting date from calendar before today's date
    public void testCalendarBeforeDate(Solo solo) throws ParseException {
        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {

            solo.assertCurrentActivity("Inside main activity", MainActivity.class);

            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.date));

            solo.waitForDialogToOpen(5000);

            solo.clickOnView(solo.getView("date_picker_year"));
            //Sleep for 5476 milliseconds
            solo.sleep(300);

            //Scroll to 2017
            android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
            solo.scrollListToLine(listView0, 109);

            //Click on 2017
            solo.clickOnView(solo.getView("month_text_view", 4));
            solo.sleep(5000);
            solo.clickOnView(solo.getView(android.view.View.class, 10));

            android.widget.ListView listView1 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
            solo.scrollListToLine(listView1, 1363);
            solo.sleep(2000);
            solo.clickOnView(solo.getView(android.view.View.class, 12));
            //Click on OK
            solo.clickOnView(solo.getView("ok"));

            // Date format function referred from http://stackoverflow.com/questions/10426492/change-date-string-format-in-android
            // answered by V.J.
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            DateFormat inputFormatter = new SimpleDateFormat("MMM dd,yyyy hh:mm:ss");
            Date date = inputFormatter.parse(currentDateTimeString);

            DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
            String output = outputFormatter.format(date);
            Date date1 = outputFormatter.parse(output);

            TextView currentDate = (TextView) solo.getView(R.id.set_date);
            String setDate = currentDate.getText().toString();
            Date date2 = outputFormatter.parse(setDate);

            String check = "false";
            if (date2.compareTo(date1) < 0) {
                check = "true";
            }

            assertEquals("false", check);
            solo.clickOnView(solo.getView("save_reminder"));


        }
    }


    //To run this test case, please comment above all test cases
    //Test case id: R-51
    //Test case for checking interval zero
    public void testIntervalZero(Solo solo){

        functions = new Functions();

        if (functions.iscorrectScreenIsInvoked(solo, "Remindly")) {
            solo.assertCurrentActivity("Inside main activity", MainActivity.class);

            RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
            solo.clickInRecyclerView(0);
            solo.clickOnView(solo.getView(R.id.RepeatNo));
            solo.enterText(0, String.valueOf(0));
            solo.clickOnButton(1);

            View v = (Switch) solo.getView(R.id.repeat_switch);
            Boolean checkEnabled = true;

            if(v.isEnabled()){
                checkEnabled = false;
            }

            assertEquals("false", checkEnabled);
            functions.clickOnView(solo, R.id.save_reminder);

        }

    }


}
