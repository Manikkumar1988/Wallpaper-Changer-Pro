package com.mani.kumar.wallpaperchangerpro;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.view.WindowManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Rule
    public ActivityTestRule<GalleryActivity> mActivityRule = new ActivityTestRule<>(
            GalleryActivity.class);

    @Before
    public void setUp() {
        final GalleryActivity activity = mActivityRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Test
    public void check() {
        assertEquals(true,true);
    }
}