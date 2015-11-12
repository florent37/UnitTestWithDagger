package fr.xebia.unittestwithdagger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by florentchampigny on 12/11/2015.
 */
public class UserActivity extends Activity {

    @Inject UserStorage userStorage;

    @Bind(R.id.text) TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        MyApplication.get().component().inject(this);
    }

    @OnClick(R.id.login)
    public void displayLoggedUser() {
        User user = userStorage.loadUser();
        textView.setText(user.getName());
    }
}
