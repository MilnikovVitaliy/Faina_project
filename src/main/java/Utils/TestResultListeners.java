package Utils;

import Driver.DriverClass;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestResultListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        var srcFile = ((TakesScreenshot) DriverClass.startChromeDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
