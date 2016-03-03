package com.udacity.gradle.builditbiggerfree;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends TestSuite {

    CountDownLatch signal;
    EndpointsAsyncTask asyncTask;

    public static Test suite() {
        return new TestSuiteBuilder(ApplicationTest.class)
                .includeAllPackagesUnderHere().build();
    }






}