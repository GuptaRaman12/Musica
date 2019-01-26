package internshala.com.echomusik.activties


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import internshala.com.echomusik.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SplashActivtyTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashActivty::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.PROCESS_OUTGOING_CALLS",
                    "android.permission.MODIFY_AUDIO_SETTINGS",
                    "android.permission.READ_EXTERNAL_STORAGE",
                    "android.permission.RECORD_AUDIO",
                    "android.permission.READ_PHONE_STATE")

    @Test
    fun splashActivtyTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(1000)

        val appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.appBarLayout),
                                                0)),
                                1),
                        isDisplayed()))
        appCompatImageButton.perform(click())

        val appCompatImageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.appBarLayout),
                                                0)),
                                1),
                        isDisplayed()))
        appCompatImageButton2.perform(click())

        val relativeLayout = onView(
                allOf(withId(R.id.navdrawer_item_content_holder),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation_recycler_view),
                                        0),
                                0),
                        isDisplayed()))
        relativeLayout.perform(click())

        val relativeLayout2 = onView(
                allOf(withId(R.id.navdrawer_item_content_holder),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation_recycler_view),
                                        1),
                                0),
                        isDisplayed()))
        relativeLayout2.perform(click())

        val appCompatImageButton3 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.appBarLayout),
                                                0)),
                                1),
                        isDisplayed()))
        appCompatImageButton3.perform(click())

        val relativeLayout3 = onView(
                allOf(withId(R.id.navdrawer_item_content_holder),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation_recycler_view),
                                        3),
                                0),
                        isDisplayed()))
        relativeLayout3.perform(click())

        val relativeLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.details_fragment),
                                childAtPosition(
                                        withClassName(`is`("android.widget.RelativeLayout")),
                                        1)),
                        2),
                        isDisplayed()))
        relativeLayout4.perform(click())

        val appCompatImageButton4 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.appBarLayout),
                                                0)),
                                1),
                        isDisplayed()))
        appCompatImageButton4.perform(click())

        val relativeLayout5 = onView(
                allOf(withId(R.id.navdrawer_item_content_holder),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation_recycler_view),
                                        2),
                                0),
                        isDisplayed()))
        relativeLayout5.perform(click())

        val switch_ = onView(
                allOf(withId(R.id.switchShake),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.details_fragment),
                                        2),
                                1),
                        isDisplayed()))
        switch_.perform(click())

        val switch_2 = onView(
                allOf(withId(R.id.switchShake),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.details_fragment),
                                        2),
                                1),
                        isDisplayed()))
        switch_2.perform(click())
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
