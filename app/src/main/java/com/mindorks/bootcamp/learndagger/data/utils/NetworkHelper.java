package com.mindorks.bootcamp.learndagger.data.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;

import javax.inject.Inject;

public class NetworkHelper {


    private Context context;

    @Inject
    public NetworkHelper(@ApplicationContext  Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        //If connectivity object is not null
        if (connectivity != null) {
            //Get network info - Mobile internet access
            NetworkInfo info = connectivity.getActiveNetworkInfo();

            if (info != null) {
                //Look for whether device is currently connected to Mobile internet
                if (info.isConnected()) {
                    return true;
                }


            }
        }
        return false;
    }

}
