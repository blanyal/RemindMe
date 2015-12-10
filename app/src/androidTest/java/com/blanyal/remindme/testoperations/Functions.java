package com.blanyal.remindme.testoperations;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.blanyal.remindme.R;
import com.robotium.solo.Solo;


public class Functions {

    // This class contains some reusable functions and those are in chunks
    // Which are dynamic u just need to pass ids which is required to perform the oprations

    /* Verify if Correct screen landed */

    public boolean iscorrectScreenIsInvoked(Solo solo, String verifyText) {
        return solo.searchText(verifyText);
    }

    /* Fill Texts */
    public void enterReminderText(Solo solo, int editTextId, String reminderText) {
        solo.enterText((EditText) solo.getView(editTextId), reminderText);
    }

    /* Click on Buttons or view or text just pass the id of it*/
    public void clickOnView(Solo solo, int reminderID) {
        solo.clickOnView(solo.getView(reminderID));
    }


    public boolean isActivityExists(Solo solo, int viewId) {
        return solo.waitForView(viewId);
    }

    /*Verify */

    public boolean verifyIfReminderisCreated(Solo solo, String verifyText) {
        RecyclerView view = (RecyclerView) solo.getView(R.id.reminder_list);
        int count = view.getAdapter().getItemCount();
        boolean flg = false;
        for (int i=0; i< count; i++){
            solo.clickInRecyclerView(i);
            flg = iscorrectScreenIsInvoked(solo, verifyText);
            if(flg){
                return true;
            }else{
                solo.goBack();
                //clickOnView(solo,R.id.home);
            }
        }
        return  false;
    }


    /*Wait*/

    public void waitfor(Solo solo, long waittime) {
        try {
            solo.wait(waittime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
