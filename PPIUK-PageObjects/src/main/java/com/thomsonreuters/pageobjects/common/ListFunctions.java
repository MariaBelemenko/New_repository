package com.thomsonreuters.pageobjects.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*  =====================================================================================================================
    This library contains the below functions
    1) getSelectedValueList - This function returns the current selected value in the list
    2) SelectValueInList -  This function selects the value in the list
    ====================================================================================================================== */
public class ListFunctions {

    public String getSelectedValueList(WebElement list) {
        String value = null;
        Select selectedOption = new Select(list);
        value = selectedOption.getFirstSelectedOption().getText();
        return value;
    }

    public void SelectValueInList(WebElement list, String value) {
        Select selectedOption = new Select(list);
        selectedOption.selectByValue(value);
    }

    public void selectByVisibleText(WebElement list, String text) {
        new Select(list).selectByVisibleText(text);
    }

}
