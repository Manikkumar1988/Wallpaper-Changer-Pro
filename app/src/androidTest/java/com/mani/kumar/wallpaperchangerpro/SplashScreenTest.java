package com.mani.kumar.wallpaperchangerpro;


        import android.app.Activity;
        import android.app.Instrumentation;
        import android.support.test.espresso.Espresso;
        import android.support.test.espresso.IdlingResource;
        import android.support.test.espresso.intent.Intents;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;
        import android.test.suitebuilder.annotation.LargeTest;
        import android.view.WindowManager;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;


        import static android.support.test.espresso.action.ViewActions.click;
        import static android.support.test.espresso.intent.Intents.intended;
        import static android.support.test.espresso.intent.Intents.intending;
        import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
        import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplashScreenTest  {

    private int splashScreenWaitingTime = 10000;
    @Rule
    public ActivityTestRule<SplashActivity> activityTestRule =
            new ActivityTestRule<>(SplashActivity.class);

    @Before
    public void setUp() {
        Intents.init();
        final SplashActivity activity = activityTestRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void viewSplashFirstTime_NavigateToTutorialAfter1000ms() throws InterruptedException {

        activityTestRule.launchActivity(null);
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(splashScreenWaitingTime);
        Espresso.registerIdlingResources(idlingResource);

        intended(hasComponent(GalleryActivity.class.getName()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    @Test
    public void viewSplashScreenSecondTime_NavigateToListBooksAfter1000ms() throws InterruptedException {

        activityTestRule.launchActivity(null);
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(splashScreenWaitingTime);
        Espresso.registerIdlingResources(idlingResource);


        intended(hasComponent(GalleryActivity.class.getName()));

        Espresso.unregisterIdlingResources(idlingResource);

    }

    @Test
    public void viewSplashScreenFinish_StartListBooks(){

        activityTestRule.launchActivity(null);
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(splashScreenWaitingTime);
        Espresso.registerIdlingResources(idlingResource);

        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, null);

        intending(hasComponent(GalleryActivity.class.getName())).respondWith(result);


        Espresso.unregisterIdlingResources(idlingResource);
    }

}
