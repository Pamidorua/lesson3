package lesson5;

import org.testng.annotations.*;

public class FullAnotationList {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("before groups");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @Test
    public void Test() {
        System.out.println("test");
    }

    @Test(dependsOnMethods = {"Test"})
    public void testWithDepends() {
        System.out.println("test with depends");
    }

    @Test(priority = 2)
    public void testWithPriorityHigh() {
        System.out.println("test with priority hig");
    }

    @Test(priority = 15)
    public void testWithPriorityLow() {
        System.out.println("low priority");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("after groups");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }
    }
