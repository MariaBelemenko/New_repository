package com.epam.TestNG.clioption;

import org.apache.commons.cli.Option;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class TypeOfBrowser implements ICliOption {
    public String[] getDefaultValue() {
        return null;
    }

    public Option getOption() {
        return new Option("b", "Browser", true, "Type of browser");
    }

    public void parse(String[] versionPlayer) {
        //FrameworkSettings.setBrowser();
    }
}
