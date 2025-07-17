package utils;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() throws IOException {
        //String path = "C:\\Users\\popeye\\My Coding\\com.Mystore\\TestData\\LoginData.xlsx";
        String path =" C:\\Users\\popeye\\My Coding\\com.Mystore\\TestData\\LoginData.xlsx";
        return DataDrivenExcell.getTestData(path, "LoginData");
    }
}
