package fr.xebia.unittestwithdagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by florentchampigny on 12/11/2015.
 */
@Module
public class MyModule {

    private final Application application;

    public MyModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public UserStorage provideUserStorage(Context context, Gson gson, @Named("user") SharedPreferences sharedPreferences) {
        return new UserStorage(context,gson,sharedPreferences);
    }

    @Provides
    @Singleton
    @Named("user")
    public SharedPreferences provideUserSharedPreferences(Context context) {
        return context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }
}
