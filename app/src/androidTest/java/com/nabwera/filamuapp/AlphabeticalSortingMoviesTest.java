package com.nabwera.filamuapp;

import android.support.test.espresso.core.deps.guava.collect.Ordering;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nabwera.filamuapp.adapter.TestAdapter;
import com.nabwera.filamuapp.model.Movie;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by @thedancercodes on 11/10/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AlphabeticalSortingMoviesTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);



    @Test
    public void Sorted() {
        onView(withId(R.id.recycler_view)).check(matches(isSortedAlphabetically()));
    }

    private static Matcher<View> isSortedAlphabetically() {
        return new TypeSafeMatcher<View>() {

            private final List<String> movieName = new ArrayList<>();
            @Override
            protected boolean matchesSafely(View item) {
                RecyclerView recyclerView = (RecyclerView) item;
                TestAdapter testAdapter = (TestAdapter) recyclerView.getAdapter();
                movieName.clear();
                movieName.addAll(extractMovieNames(testAdapter.getMovie()));
                return Ordering.natural().isOrdered(movieName);
            }

            private List<String> extractMovieNames(List<Movie> movies) {
                List<String> movieNames = new ArrayList<>();

                // This for-each loop is iterating through the movies list
                for (Movie movie : movies) {
                    movieNames.add(movie.getOriginalTitle());
                }
                return movieName;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("has items sorted alphabetically: " + movieName);
            }
        };
    }
}
