package com.udacity.gradle.builditbiggerfree;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

import java.util.concurrent.ExecutionException;

/**
 * Created by benwong on 2016-03-02.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public void testAsyncTask(){
        try {
            new com.udacity.gradle.builditbiggerpaid.EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "...")).get();
            assertEquals(new com.udacity.gradle.builditbiggerpaid.EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "...")).get().getClass().getName(), String.class.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
