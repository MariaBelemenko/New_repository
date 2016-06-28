package tests;

import com.epam.TestNG.customAnnotation.ClassName;
import com.epam.TestNG.pageFactory.steps.Steps;
import com.epam.TestNG.hook.ShutdownHook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class Runner {
    private static final Logger LOG = LogManager.getLogger(Steps.class.getName());

    public static void main(String[] args) {
        String name = "";
        TestNG tng = new TestNG();
        ShutdownHook profilesHook = new ShutdownHook();
        profilesHook.attachShutdownHook();

        Class<Steps> obj = Steps.class;

        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(ClassName.class)) {
                name = obj.getName();
            }
        }
        LOG.info("Name of the class is " + name);

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
        LOG.info("TestNG runner is working");
    }
}
