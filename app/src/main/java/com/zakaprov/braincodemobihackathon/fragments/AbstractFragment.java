package com.zakaprov.braincodemobihackathon.fragments;

import android.animation.Animator;
import android.app.Fragment;

/**
 * Created by kulak on 14/03/15.
 */
public class AbstractFragment extends Fragment {
    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {

        return super.onCreateAnimator(transit, enter, nextAnim);
    }
}
