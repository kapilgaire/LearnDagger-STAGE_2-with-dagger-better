package com.mindorks.bootcamp.learndagger.ui.home;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.data.utils.NetworkHelper;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class HomeViewModel {


    private DatabaseService databaseService;
    private NetworkService networkService;
    private NetworkHelper mNetworkHelper;

    @Inject
    public HomeViewModel(DatabaseService databaseService, NetworkService networkService, NetworkHelper mNetworkHelper) {
        this.databaseService = databaseService;
        this.networkService = networkService;
        this.mNetworkHelper = mNetworkHelper;
    }

    public boolean isNetworkConnected() {
        return mNetworkHelper.isNetworkConnected();
    }
}