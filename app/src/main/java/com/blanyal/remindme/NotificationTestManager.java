package com.blanyal.remindme;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import static junit.framework.Assert.assertTrue;


/**
 * Created by theDarkKnight on 11/18/15.
 */
public class NotificationTestManager {
    public void testNotify(Notification notification, Context context){
        Bundle mExtras = notification.extras;
        CharSequence title = (CharSequence) mExtras.getCharSequence(Notification.EXTRA_TITLE);
        CharSequence text = (CharSequence) mExtras.getCharSequence(Notification.EXTRA_TEXT);
        if (text != null) {
            assertTrue(text.equals("Title"));
            assertTrue(title.equals(context.getResources().getString(R.string.app_name)));
        } else {
            assertTrue(false);
        }
        assertTrue(notification.tickerText.equals("Title"));

    }
}
