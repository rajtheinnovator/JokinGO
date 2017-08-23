package com.enpassio.jokingo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class FetchRESTResponseTaskTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    Context context;
    String mJoke;

    @Test
    public void testVerifyJoke() throws InterruptedException {
        context = InstrumentationRegistry.getContext();

        onView(withId(R.id.ok)).perform(click());
        EndpointAsyncTask jokeTask = new EndpointAsyncTask();

        /* code below referenced from the
         * link: https://discussions.udacity.com/t/writing-tests-for-async-task/25482/10
         */
        try {
            jokeTask.execute();
            mJoke = jokeTask.get(30, TimeUnit.SECONDS);
            assertTrue("The string is empty", mJoke.length() > 0);
        } catch (Exception e) {
            //exception can be caught here
        }

    }

}
