package com.boredump.sciencehook.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maagarwa on 8/31/2015.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseFragmentHostInterface baseFragmentInterface;

    private View rootView;

    public abstract boolean OnBackPressed();

    public abstract String getTagText();

    public View createCachedView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, int layout) {
        if(rootView == null) {
            rootView = inflater.inflate(layout, null);
        }
        else {
            ((ViewGroup)rootView.getParent()).removeView(rootView);
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!(getActivity() instanceof BaseFragmentHostInterface)) {
            throw new ClassCastException("MainActivty should implement the host to base interface");
        }
        else {
            baseFragmentInterface = (BaseFragmentHostInterface) getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        baseFragmentInterface.setSelectedFragment(this);
    }
}
