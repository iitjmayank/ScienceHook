package com.boredump.sciencehook.base;

import android.widget.ImageView;

/**
 * Created by maagarwa on 8/31/2015.
 */
public interface BaseFragmentHostInterface {
    public void setSelectedFragment(BaseFragment fragment);
    public void popBackStack();
    public void addFragment(BaseFragment fragment, boolean WithAnimation);
    public void loadImageFromURL(String url, ImageView imageView);
}
