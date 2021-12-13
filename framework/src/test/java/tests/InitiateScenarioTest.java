package tests;

import constants.ResultConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InitiateScenarioTest extends CommonConditions {
    @Test
    public void isVMClassCorrect() {
        Assert.assertEquals(estimatePage.getVmClassValue().getText(), ResultConstants.getVM_CLASS(), "wrong VMClass value");
    }

    @Test
    public void isInstanceCorrect() {
        Assert.assertEquals(estimatePage.getInstanceTypeValue().getText(), ResultConstants.getCPU(), "wrong instance type");
    }

    @Test
    public void isRegionCorrect() {
        Assert.assertEquals(estimatePage.getRegionValue().getText(), ResultConstants.getREGION(), "wrong region");
    }

    @Test
    public void isLocalSsdCorrect() {
        Assert.assertEquals(estimatePage.getLocalSSDValue().getText(), ResultConstants.getSSD(), "wrong SSD");
    }

    @Test
    public void isCommitedTermCorrect() {
        Assert.assertEquals(estimatePage.getTermValue().getText(), ResultConstants.getTERM(), "wrong comitted term");
    }

    @Test
    public void isSumCorrect() {
        Assert.assertEquals(estimatePage.getCountedSumLabelValue().getText(), ResultConstants.getSUM(), "wrong sum");
    }

}
