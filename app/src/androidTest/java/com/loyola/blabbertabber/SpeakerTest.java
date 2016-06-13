package com.loyola.blabbertabber;

import android.support.test.runner.AndroidJUnit4;

import com.loyola.talktracer.model.Speaker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by cunnie on 11/17/15.
 */

@RunWith(AndroidJUnit4.class)
public class SpeakerTest {
    private static final String TAG = "SpeakerTest";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testConstructor() {
        Speaker speaker = new Speaker("Sam", 'M');
        assertEquals("Newly constructed speaker's name is Sam", "Sam", speaker.getName());
        assertEquals("Newly constructed speaker's gender is M", 'M', speaker.getGender());
    }

    @Test
    public void testAddTurn() {
        Speaker speaker = new Speaker("Sam", 'M');
        speaker.addTurn(529, 293);
        assertEquals("Duration is 293", 293, speaker.getTotalDuration());
    }

}
