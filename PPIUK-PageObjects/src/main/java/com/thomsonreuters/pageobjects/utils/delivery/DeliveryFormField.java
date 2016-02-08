package com.thomsonreuters.pageobjects.utils.delivery;

import com.thomsonreuters.pageobjects.utils.form.*;
import org.openqa.selenium.By;

public enum DeliveryFormField implements FormField {

    BASIC_TAB("Basic", By.cssSelector("#co_deliveryOptionsTab1 .co_tabLink"), DefaultFormField.newInstance()),
    ADVANCED_TAB("Advanced", By.cssSelector("#co_deliveryOptionsTab2 .co_tabLink"), DefaultFormField.newInstance()),

    TO("To", By.id("co_delivery_emailAddress"), DefaultFormField.newInstance()),
    SUBJECT("Subject", By.id("co_delivery_subject"), DefaultFormField.newInstance().getTextByValue()),
    EMAIL_NOTE("Email Note", By.id("co_delivery_note"), DefaultFormField.newInstance()),
    FORMAT("Format", By.id("co_delivery_format_fulltext"), DropDown.newInstance()),
    FORMAT_LIST("Format Value", By.id("co_delivery_format_list"), DropDown.newInstance()),
    TABLE_OF_CONTENTS("Table of Contents", By.id("coid_chkDdcLayoutTableOfContents"), CheckBoxOrRadioButton.newInstance()),
    ANNOTATIONS("Annotations", By.id("coid_chkDdcContentAnnotations"), CheckBoxOrRadioButton.newInstance()),
    LIST_OF_ITEMS("List of Items", By.id("co_deliveryWhatToDeliverList"), CheckBoxOrRadioButton.newInstance()),
    DOCUMENTS("Documents", By.id("co_deliveryWhatToDeliverDocumentOnly"), CheckBoxOrRadioButton.newInstance()),
    AS("As", By.id("co_delivery_fileContainer"), DropDown.newInstance()),
	ONLY_PAGES_WITH_TERMS("Only pages with terms", By.id("coid_chkDdcLayoutOnlyPagesWithSearchTerms"), CheckBoxOrRadioButton.newInstance()),

    DOCUMENT("Document", By.id("co_deliveryWhatToDeliverDocumentOnly"), CheckBoxOrRadioButton.newInstance()),
    ONLY_DRAFTING_NOTES("Only Drafting Notes", By.id("co_deliveryWhatToDeliverDraftingNotesOnly"), CheckBoxOrRadioButton.newInstance()),
    DOCUMENT_AND_DRAFTING_NOTES("Document and Drafting Notes", By.id("co_deliveryWhatToDeliverDocumentAndDraftingNotes"), CheckBoxOrRadioButton.newInstance()),

    EXPAND_MARGIN_FOR_NOTES("Expanded Margin for Notes", By.id("coid_chkDdcLayoutRightNoteMarging"), CheckBoxOrRadioButton.newInstance()),
    COVER_PAGE("Cover Page", By.id("coid_chkDdcLayoutCoverPage"), CheckBoxOrRadioButton.newInstance()),
    COVER_PAGE_COMMENT("Cover Page Comments", By.id("coid_DdcLayoutCoverPageComment"), DefaultFormField.newInstance()),
    LINKS("Links", By.id("co_delivery_linkColor"), DropDown.newInstance()),
    UNDERLINE("Underline", By.id("co_delivery_linkUnderline"), CheckBoxOrRadioButton.newInstance()),
    FONTSIZE("Font Size", By.id("co_delivery_fontSize"), DropDown.newInstance());

    private String displayName;
    private By by;
    private FormFieldStrategy formFieldStrategy;

    DeliveryFormField(String displayName, By by, FormFieldStrategy formFieldStrategy) {
        this.displayName = displayName;
        this.by = by;
        this.formFieldStrategy = formFieldStrategy;
    }

    public String getDisplayName() {
        return displayName;
    }

    public By getBy() {
        return by;
    }

    public FormFieldStrategy getFormFieldStrategy() {
        return formFieldStrategy;
    }

    public static DeliveryFormField getByFieldDisplayName(String label) {
        for (DeliveryFormField emailDeliveryBasicForm : DeliveryFormField.values()) {
            if (emailDeliveryBasicForm.getDisplayName().equalsIgnoreCase(label)) {
                return emailDeliveryBasicForm;
            }
        }
        throw new UnsupportedOperationException("Field " + label + " is not in the ENUM");
    }

}
