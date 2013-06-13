package com.orangemako.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Listener that hooks into specific TestNG callback methods.  This can provide some level of visibility into errors
 * that occur at each stage of the test process.
 *
 * @author Kevin Leong
 *
 */
public class ResultListener extends TestListenerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ResultListener.class);

    @Override
    public void onConfigurationFailure(ITestResult tr)
    {
        LOG.info("config failed -- " + tr.getName(), tr.getThrowable());
    }

    @Override
    public void onConfigurationSkip(ITestResult tr)
    {
        LOG.info("config skip -- " + tr.getName(), tr.getThrowable());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        LOG.info("failed -- " + tr.getName(), tr.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        LOG.info("skipped -- " + tr.getName(), tr.getThrowable());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        LOG.info("pass -- " + tr.getName());
    }
}
