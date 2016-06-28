package com.epam.TestNG.htmlElements.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Mariya_Belemenko on 6/26/2016.
 */
public class SearchFunction extends HtmlElement {
    @FindBy(id = "lst-ib")
    private TextInput requestInput;

    @FindBy(xpath = "//input[@type = 'submit']")
    private Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}
