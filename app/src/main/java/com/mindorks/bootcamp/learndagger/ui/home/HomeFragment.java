package com.mindorks.bootcamp.learndagger.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent;
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Inject
    public HomeViewModel mViewModel;

    TextView connectivityStatusTv;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        connectivityStatusTv = view.findViewById(R.id.connectivity_status_tv);

        connectivityStatusTv.setText(mViewModel.isNetworkConnected() ? "Connected" : "NotConnected");


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getActivity().getApplication()).applicationComponent)
                .build()
                .inject(this);
    }


}
