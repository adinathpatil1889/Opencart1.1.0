package utilities;
 
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\OpenCartDDT.xlsx"; // taking xl file from testData

        ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility
//        
//        captcuring no of rows and columns to store in 2 dim array 
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // created for two dimension array which can store login data
        String logindata[][] = new String[totalrows][totalcols];

        // read the data from xl storing in two dimensional array
        for (int i = 1; i <= totalrows; i++) {   // i = rows
            for (int j = 0; j < totalcols; j++) { // j = columns
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata; // returning two dimension array
    }
}

//data provider2
