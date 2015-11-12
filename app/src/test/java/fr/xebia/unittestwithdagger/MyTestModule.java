package fr.xebia.unittestwithdagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by florentchampigny on 12/11/2015.
 */
public class MyTestModule extends MyModule{

    public MyTestModule(MyApplication application) {
        super(application);
    }

    @Override
    @Provides
    @Singleton
    public UserStorage provideUserStorage(Context context, Gson gson, SharedPreferences sharedPreferences) {
        return Mockito.mock(UserStorage.class);
    }
}
