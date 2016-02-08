package com.thomsonreuters.pageobjects.utils.form;

import com.thomsonreuters.pageobjects.pages.delivery.EmailOptionsPage;
import org.openqa.selenium.WebElement;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

public class FormUtils {

    private EmailOptionsPage page = new EmailOptionsPage();

    public String getValue(FormField formField) {
        return formField.getFormFieldStrategy().getValue(findElement(formField));
    }

    public WebElement findElement(FormField form) {
        return page.findElement(form.getBy());
    }

    public void editValue(FormField form, String value) {
        form.getFormFieldStrategy().editValue(findElement(form), value);
    }

    public boolean isNotDisplayed(FormField deliveryForm) {
        return isEmpty(page.findElements(deliveryForm.getBy()));
    }


}
