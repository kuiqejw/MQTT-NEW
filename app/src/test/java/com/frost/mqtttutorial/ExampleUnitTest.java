package com.frost.mqtttutorial;

import com.frost.mqtt.MainActivity;
import com.frost.mqtt.SmsHelper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void SmsHelper_isValidPhoneNumber() throws Exception {
        assertTrue(SmsHelper.isValidPhoneNumber("91234567"));
    }
    @Test
    public void SmsHelper_notValidNumber() throws Exception {
        assertFalse(SmsHelper.isValidPhoneNumber("Java Unit Test"));
    }
    @Test
    public void toggle_Valid() throws Exception{
        MainActivity.toggle.toggle();
        assertTrue(MainActivity.FLAG);
    }
}