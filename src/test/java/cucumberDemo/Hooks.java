package cucumberDemo;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario() {
		//System.out.println("Before hook");
	}
	
	@After
	public void afterScenario() {
		//System.out.println("After hook");
	}
}
