package com.cucumber.demo.cucumber_demo;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.coveros.selenified.Selenified;
import com.coveros.selenified.application.App;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GooglePageTest extends Selenified {
	
	ThreadLocal<GooglePage> google = new ThreadLocal<GooglePage>();

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        // set the base URL for the tests here
        setTestSite(this, test, "https://www.google.com");
        // set the author of the tests here
        setAuthor(this, test, "Arya Atighehchian\n<br/>arya.atighehchian@coveros.com");
        // set the version of the tests or of the software, possibly with a
        // dynamic check
        setVersion(this, test, "0.0.1");
    }

   

    @BeforeMethod(alwaysRun = true)
    public void setUpPage() {
    	google.set(new GooglePage(this.apps.get()));
    }

    
    @Given("^I've opened google$")
    public void i_ve_opened_google() throws Throwable {
    }

    @When("^I search for term$")
    public void i_search_for_term() throws Throwable {
        
    }

    @Then("^I validate the term$")
    public void i_validate_the_term() throws Throwable {
    }


    
}

