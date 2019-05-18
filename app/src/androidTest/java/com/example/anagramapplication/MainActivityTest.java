package com.example.anagramapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View viewEditText = mActivity.findViewById(R.id.editText);
        assertNotNull(viewEditText);

        View viewTextView = mActivity.findViewById(R.id.textView);
        assertNotNull(viewTextView);

        View viewButtonAnagram = mActivity.findViewById(R.id.button);
        assertNotNull(viewButtonAnagram);

        View viewButtonClear = mActivity.findViewById(R.id.imageButton);
        assertNotNull(viewButtonClear);
    }

    @Test
    public void testMainActivityEspresso() throws Exception {
        onView(withId(R.id.editText)).perform(typeText("a1bcd efg!h"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("d1cba hgf!e")));

        onView(withId(R.id.editText)).perform(typeText("a1bcd efg!h"));
        onView(withId(R.id.imageButton)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("")));
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}