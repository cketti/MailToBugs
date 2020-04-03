package com.example.mailtobugs;


import android.net.MailTo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class MailToTest {
    @Test
    public void encodedAmpersandInBody() {
        MailTo mailTo = MailTo.parse("mailto:alice@example.com?body=a%26b");

        assertEquals("a&b", mailTo.getBody());
    }

    @Test
    public void encodedEqualSignInBody() {
        MailTo mailTo = MailTo.parse("mailto:alice@example.com?body=a%3Db");

        assertEquals("a=b", mailTo.getBody());
    }

    @Test
    public void encodedPercentValueInBody() {
        MailTo mailTo = MailTo.parse("mailto:alice@example.com?body=%2525");

        assertEquals("%25", mailTo.getBody());
    }

    @Test
    public void colonInBody() {
        MailTo mailTo = MailTo.parse("mailto:alice@example.com?body=one:two");

        assertEquals("one:two", mailTo.getBody());
    }
}
