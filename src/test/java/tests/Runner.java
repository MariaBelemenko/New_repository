package tests;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class Runner {
    public static void main(String[] args) {
        TestNG tng = new TestNG();

        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");
        List<String> files = new ArrayList<String>();
        files.addAll(new ArrayList<String>() {{
            add("./src/test/resources/Testng.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        tng.setXmlSuites(suites);
        tng.run();
    }
}
