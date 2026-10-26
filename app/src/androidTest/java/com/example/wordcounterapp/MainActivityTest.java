package com.example.wordcounterapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCountingUI() {
        //Ivedam tekssta edtUserInput ir paslepiam keyboard
        onView(withId(R.id.edtUserInput))
                .perform(typeText("Labas pasauli 123"), closeSoftKeyboard());

        // Paspaudziam btnCount mygtuka
        onView(withId(R.id.btnCount)).perform(click());

        //Patikrinam ar rezultatas tvResult yra "Result: 2"
        onView(withId(R.id.tvResult)).check(matches(withText("Result: 2")));
    }
}