package fr.xebia.unittestwithdagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by florentchampigny on 12/11/2015.
 */
public class UserStorage {
    final Context context;
    final Gson gson;
    final SharedPreferences sharedPreferences;
    public UserStorage(Context context, Gson gson, SharedPreferences sharedPreferences){
        this.context = context;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void saveUser(User user){
        sharedPreferences.edit()
                .putString("user",gson.toJson(user))
                .apply();
    }

    public User loadUser(){
        String userJson = sharedPreferences.getString("user", null);
        return gson.fromJson(userJson, User.class);
    }
}