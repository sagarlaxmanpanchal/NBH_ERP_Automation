package Tests;

import CommonTestComponents.BaseTest;
import NBHPages.BillingHeads;
import NBHPages.GenrateBills;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandAlonTest extends BaseTest {

    @Test
    public void Test1() throws InterruptedException {
        GenrateBills gb=new GenrateBills(driver);
        String successmessage=gb.billGenrationforAllflats();
        Assert.assertEquals(successmessage,"Received your bill generation request. It will be processed soon and appear in post bills page!");
    }
    @Test
    public void Test2() throws InterruptedException {
        GenrateBills gb=new GenrateBills(driver);
        String successmessage=gb.billGenrationforTower();
        Assert.assertEquals(successmessage,"Received your bill generation request. It will be processed soon and appear in post bills page!");


    }

    @Test
    public void Test3() throws InterruptedException {
        GenrateBills gb= new GenrateBills(driver);
        String successmessage=gb.billGenrationforSelectedFlats();
        Assert.assertEquals(successmessage,"Received your bill generation request. It will be processed soon and appear in post bills page!");
    }
    @Test
    public void VerifyBillHeadCreation(){
        BillingHeads bh= new BillingHeads(driver);
        bh.CreateBillhead();
    }
}
