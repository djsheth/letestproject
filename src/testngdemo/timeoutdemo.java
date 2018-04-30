package testngdemo;

import org.testng.annotations.Test;

public class timeoutdemo {
  @Test
  public void passtest() {
	  
	  System.out.println("This test is pass");
  }

  @Test(timeOut=3000)
  public void failtest() {
	  
	  System.out.println("This test is fail because of timeout");
	  while(true);
  }
}
