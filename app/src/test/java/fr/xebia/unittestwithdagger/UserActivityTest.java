package fr.xebia.unittestwithdagger;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import fr.xebia.unittestwithdagger.internal.CustomRobolectricTestRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * Created by florentchampigny on 12/11/2015.
 */
@RunWith(CustomRobolectricTestRunner.class)
@Config(application = MyTestApplication.class, constants = BuildConfig.class, sdk=21)
public class UserActivityTest {

    UserActivity activity;
    UserStorage userStorage;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(UserActivity.class).create().get();

        userStorage = MyApplication.get().component().userStorage();
    }

    @Test
    public void displayLoggedUserShoulDisplayFlorent(){
        given(userStorage.loadUser()).willReturn(new User("florent"));
        TextView textView = (TextView)activity.findViewById(R.id.text);

        activity.displayLoggedUser();

        assertEquals("florent", textView.getText().toString());
    }
}