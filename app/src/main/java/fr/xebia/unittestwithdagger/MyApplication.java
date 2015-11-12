package fr.xebia.unittestwithdagger;

import android.app.Application;

/**
 * Created by florentchampigny on 12/11/2015.
 */
public class MyApplication extends Application {
    private static MyApplication INSTANCE;
    MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initComponents();
    }

    public static MyApplication get() {
        return INSTANCE;
    }

    protected void initComponents() {
        component = DaggerMyComponent.builder()
                .myModule(new MyModule(this))
                        .build();
    }
    public MyComponent component() {
        return component;
    }
}
