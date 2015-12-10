/*
 * Copyright 2015 Blanyal D'Souza.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blanyal.remindme;

// References https://github.com/RobotiumTech/robotium/wiki/Getting-Started

import android.test.ActivityInstrumentationTestCase2;

import com.blanyal.remindme.testcases.TestCases;
import com.robotium.solo.Solo;

import junit.framework.TestSuite;

import java.io.IOException;
import java.text.ParseException;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    // This function initiate the app
    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }


    public void testSuite() throws IOException {

        try {

            new TestCases().testCreateRemindly(solo);

            new TestCases().testDeleteRemindly(solo);

            new TestCases().testDeleteAllRemindly(solo);

            new TestCases().testCreateRemindly(solo);
            new TestCases().testRemindlyTitle(solo);

            new TestCases().testTime(solo);

            new TestCases().testCalendarAfterDate(solo);

            new TestCases().testRepetitionTypesMinute(solo);

            new TestCases().testRepetitionTypesHour(solo);

            new TestCases().testRepetitionTypesDay(solo);

            new TestCases().testRepetitionTypesWeek(solo);

            new TestCases().testRepetitionTypesMonth(solo);

            new TestCases().testRepetitionInterval(solo);

            new TestCases().testDiscardChanges(solo);

            new TestCases().testDisableMute(solo);

            new TestCases().testEnableMute(solo);

            new TestCases().testRepeatSwitchRepeatedOff(solo);

            new TestCases().testRepeatSwitchRepeatedOn(solo);

            new TestCases().testLicense(solo);

            new TestCases().testCalendarTodayDate(solo);

            new TestCases().testCalendarBeforeDate(solo);

            //To run this test case, please comment above all test cases
            new TestCases().testIntervalZero(solo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

}