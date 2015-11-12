package fr.xebia.unittestwithdagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by florentchampigny on 12/11/2015.
 */
@Singleton
@Component(modules = {MyModule.class})
public interface MyComponent {
    UserStorage userStorage();
    void inject(UserActivity userActivity);
}
