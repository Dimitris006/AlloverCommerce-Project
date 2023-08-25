
package practice_.tests.US09;

import org.testng.annotations.Test;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;

public class US09_TC01 {
   @Test
    public void vendorSignUp(){
       Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
   }
}
