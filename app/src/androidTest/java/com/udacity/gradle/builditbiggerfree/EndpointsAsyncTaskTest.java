package com.udacity.gradle.builditbiggerfree;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

/**
 * Created by benwong on 2016-03-02.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public void testAsyncTask(){
        new com.udacity.gradle.builditbiggerpaid.EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "..."));
    }


}
