package fr.xebia.unittestwithdagger;

/**
 * Created by florentchampigny on 12/11/2015.
 */
public class MyTestApplication extends MyApplication{

    @Override
    protected void initComponents() {
        component = DaggerMyComponent.builder()
                .myModule(new MyTestModule(this))
                .build();
    }
}
