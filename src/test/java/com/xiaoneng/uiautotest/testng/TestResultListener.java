package com.xiaoneng.uiautotest.testng;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.xiaoneng.uiautotest.base.AutoTestBase;
import com.xiaoneng.uiautotest.util.Assertion;
import com.xiaoneng.uiautotest.util.Log;

/**
 * @author dell
 *	监听测试结果类
 */
public class TestResultListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
    	 this.handleAssertion(tr);
        Log.logInfo(tr.getName() + " Failure");
        saveScreenShot(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
    	 this.handleAssertion(tr);
        Log.logInfo(tr.getName() + " Skipped");
        saveScreenShot(tr);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
    	 this.handleAssertion(tr);
        Log.logInfo(tr.getName() + " Success");
    }

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);
        Assertion.flag = true; 
        Assertion.errors.clear();
        Log.logInfo(tr.getName() + " Start");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
        Set<Integer> passedTestIds = new HashSet<Integer>();
        for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
            Log.logInfo("PassedTests : " + passedTest.getName());
            passedTestIds.add(getId(passedTest));
        }

        Set<Integer> skipTestIds = new HashSet<Integer>();
        for (ITestResult skipTest : testContext.getSkippedTests().getAllResults()) {
            Log.logInfo("skipTest : " + skipTest.getName());

            int skipTestId = getId(skipTest);

            if (skipTestIds.contains(skipTestId) || passedTestIds.contains(skipTestId)) {
                testsToBeRemoved.add(skipTest);
            } else {
                skipTestIds.add(skipTestId);
            }
        }

        Set<Integer> failedTestIds = new HashSet<Integer>();
        for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
            Log.logInfo("FailedTest : " + failedTest.getName());
            int failedTestId = getId(failedTest);

            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId) ||
                    skipTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        for (Iterator<ITestResult> iterator = testContext.getFailedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
                Log.logInfo("Remove repeat Fail Test : " + testResult.getName());
                iterator.remove();
            }
        }

    }

    private int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = id + result.getMethod().getMethodName().hashCode();
        id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
        return id;
    }

    private void saveScreenShot(ITestResult tr) {
        String filePath_testngReports = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String mDateTime = formatter.format(new Date());
        String fileName = tr.getName() + "-" + mDateTime;

        try {
            filePath_testngReports = AutoTestBase.ScreenShot(fileName);
        } catch (Exception e) {
            Log.logInfo(tr.getName() + " takeScreenshot Failure:");
        }

        if (null != filePath_testngReports && !"".equals(filePath_testngReports)) {
            Reporter.setCurrentTestResult(tr);
            Reporter.log("<img src=\"../screenShots/" + fileName + ".png" + "\" style=\"width:180px;height:300px;\"/>");

        }
    }
    
    
    private int index = 0;
    
    private void handleAssertion(ITestResult tr){
        if(!Assertion.flag){
            Throwable throwable = tr.getThrowable();           
            if(throwable==null){
                throwable = new Throwable();
            }           
            StackTraceElement[] traces = throwable.getStackTrace();
            StackTraceElement[] alltrace = new StackTraceElement[0];           
            for (Error e : Assertion.errors) {
                StackTraceElement[] errorTraces = e.getStackTrace();
                StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
                StackTraceElement[] message = new StackTraceElement[]{new StackTraceElement("message : "+e.getMessage()+" in method : ", tr.getMethod().getMethodName(), tr.getTestClass().getRealClass().getSimpleName(), index)};
                index = 0;
                alltrace = this.merge(alltrace, message);
                alltrace = this.merge(alltrace, et);
            }
            if(traces!=null){
                traces = this.getKeyStackTrace(tr, traces);
                alltrace = this.merge(alltrace, traces);
            }           
            throwable.setStackTrace(alltrace);
            tr.setThrowable(throwable);
            Assertion.flag = true;   
            Assertion.errors.clear();
            tr.setStatus(ITestResult.FAILURE);           
        }
    }
     
    private StackTraceElement[] getKeyStackTrace(ITestResult tr, StackTraceElement[] stackTraceElements){
        List<StackTraceElement> ets = new ArrayList<StackTraceElement>();
        for (StackTraceElement stackTraceElement : stackTraceElements) {           
            if(stackTraceElement.getClassName().equals(tr.getTestClass().getName())){               
                ets.add(stackTraceElement);
                index = stackTraceElement.getLineNumber();
            }
        }
        StackTraceElement[] et = new StackTraceElement[ets.size()];
        for (int i = 0; i < et.length; i++) {
            et[i] = ets.get(i);
        }
        return et;
    }
     
    private StackTraceElement[] merge(StackTraceElement[] traces1, StackTraceElement[] traces2){
        StackTraceElement[] ste = new StackTraceElement[traces1.length+traces2.length];
        for (int i = 0; i < traces1.length; i++) {
            ste[i] = traces1[i];
        }
        for (int i = 0; i < traces2.length; i++) {
            ste[traces1.length+i] = traces2[i];
        }
        return ste;
    }
}