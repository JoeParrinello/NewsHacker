package com.tsums.newshacker;

import android.app.Application;

import com.tsums.newshacker.dependencies.DaggerNHComponent;
import com.tsums.newshacker.dependencies.NHComponent;
import com.tsums.newshacker.dependencies.NHDebugModule;
import com.tsums.newshacker.dependencies.NHModule;

/**
 * Application class where we can instantiate runtime needs like Dagger injection.
 */
public class NHApplication extends Application {

    private NHComponent mComponent;

    public NHComponent getmComponent () {
        return mComponent;
    }

    @Override
    public void onCreate () {

        super.onCreate();

        if (BuildConfig.DEBUG) {
            mComponent = DaggerNHComponent.builder().nHModule(new NHDebugModule(this)).build();
        } else {
            mComponent = DaggerNHComponent.builder().nHModule(new NHModule(this)).build();
        }


    }
}
