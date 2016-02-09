package com.thomsonreuters.pageobjects.pages.search;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class WhatsMarketComparisonReportPage extends AbstractPage {

    /**
     * this is the Deal Comparison Report heading
     */
    public WebElement dealComparisonReportHeader() {
        return waitForExpectedElement(By.xpath("//div[@id='co_docHeaderContainer']//div[contains(text(),'Deal Comparison Report')]"), 30);
    }

    /**
     * this is the menu toggle option to the top left hand side of the page
     */
    public WebElement menuToggleButton() {
        return waitForExpectedElement(By.xpath("//div[@id='kh_tocContainer']//a[@class='menu-toggle']"), 10);
    }

    /**
     * object representing the report profile dropdown to the left of the page
     */
    public WebElement reportProfileDropdown() {
        return findElement(By.id("profileList"));
    }

    /**
     * object representing the options listed in the report profile dropdown to the left of the page
     */
    public WebElement reportProfileDropdownOption(String option) {
        return findElement(By.xpath("//select[@id='profileList']/option[text()='" + option + "']"));
    }

    /**
     * method to show if the specified option is listed in the report profile dropdown to the left of the page
     */
    public boolean isReportProfileDropdownOptionDisplayed(String option) {
        try {
            reportProfileDropdownOption(option).isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
        return true;
    }

    /**
     * object representing the company number column on the deal comparison report
     */
    public WebElement compNameColumn() {
        return findElement(By.xpath("//th[@class='co_dcrTable_companyName companyName']"));
    }

    /**
     * method to show if the company name column is displayed in the deal comparison report
     */
    public boolean isCompNameColumnDisplayed() {
        try {
            compNameColumn().isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
        return true;
    }

    /**
     * object representing the select all option beneath the report profile dropdown
     */
    public WebElement selectAllCheckbox() {
        return waitForExpectedElement(By.id("selectAll"));
    }

    /**
     * object representing the individual checkboxes for selection e.g. Company name
     */
    public WebElement whatsMarketCheckbox(String name) {
        return waitForExpectedElement(By.xpath("//ul[@id='fieldGroup_0']//input[@id='" + name + "']"));
    }

    /**
     * object representing the status of the left hand toggle button
     */
    public Boolean leftHandPaneToggleButtonActive() {
        Boolean isActive = false;
        WebElement leftHandToggle = waitForExpectedElement(By.xpath("//div[@id='co_leftColumn']"), 10);
        String classValue = leftHandToggle.getAttribute("class");
        if (classValue.equals("is-active")) {
            isActive = true;
        }
        return isActive;
    }

    /**
     * object representing the option to save the report profile
     */
    public WebElement saveReportProfile() {
        return waitForExpectedElement(By.id("saveLink"));
    }

    /**
     * object representing the option to delete the report profile
     */
    public WebElement deleteReportProfile() {
        return waitForExpectedElement(By.id("deleteLink"));
    }

    /**
     * object representing the option to reduce or increase the number of columns displayed entitled # of columns
     */
    public WebElement selectColumnCountDropdown() {
        return waitForExpectedElement(By.id("selectColumnCount"));
    }

    /**
     * object representing the report column headers in the report table itself e.g. Company name
     */
    public WebElement columnHeader(String name) {
        return waitForExpectedElement(By.xpath("//div[@id='reportBodyContainer']//span[contains(text(),'" + name + "')]"));
    }

    /**
     * object representing the organize columns button
     */
    public WebElement organizeColumns() {
        return waitForExpectedElement(By.xpath("//a[@id='organizeColumns']/span[text()='Organize Columns']"));
    }

    /**
     * object representing the organize columns header on the organize columns pop up box
     */
    public WebElement organizeColumnsHeader() {
        return waitForExpectedElement(By.xpath("//div[@id='columnReorderLightbox']//h3[text()='Organize Columns']"));
    }

    /**
     * object representing the various named columns for reorganisation on the organize columns pop up box e.g. Company number
     */
    public WebElement columnOption(String name) {
        return waitForExpectedElement(By.xpath("//ul[@id='columnList']//a[text()='" + name + "']"));
    }

    /**
     * object representing the Move To Top option on the organize columns pop up box
     */
    public WebElement moveToTopOption() {
        return waitForExpectedElement(By.id("reorderMoveTop"));
    }

    /**
     * object representing the Move To Bottom option on the organize columns pop up box
     */
    public WebElement moveToBottomOption() {
        return waitForExpectedElement(By.id("reorderMoveBottom"));
    }

    /**
     * object representing the Move up option on the organize columns pop up box
     */
    public WebElement moveUpOption() {
        return waitForExpectedElement(By.id("reorderMoveUp"));
    }

    /**
     * object representing the Move down option on the organize columns pop up box
     */
    public WebElement moveDownOption() {
        return waitForExpectedElement(By.id("reorderMoveDown"));
    }

    /**
     * object representing the close option on the organize columns pop up box
     */
    public WebElement closeButtonOrganizeColumns() {
        return waitForExpectedElement(By.id("co_closeColReorderLightbox"));
    }

    /**
     * object representing the heading "Save Report Profile" on the create new profile pop up box
     */
    public WebElement newProfilePopUpHeader() {
        return waitForExpectedElement(By.xpath("//div[@id='co_deliveryLightbox']//h3[text()='Save Report Profile']"));
    }

    /**
     * object representing the heading "Delete Report Profile" on the create new profile pop up box
     */
    public WebElement deleteProfilePopUpHeader() {
        return waitForExpectedElement(By.xpath("//div[@id='coid_lightboxOverlay']//h3[text()='Delete Report Profile']"));
    }

    /**
     * object representing the Profile Name text entry field
     */
    public WebElement profileTextEntryField() {
        return waitForExpectedElement(By.id("profileName"));
    }

    /**
     * object representing the save option on the new profile pop up
     */
    public WebElement saveOptionOnPopUp() {
        return waitForExpectedElement(By.id("saveProfileButton"));
    }

    /**
     * object representing the Return to Search Results link
     */
    public WebElement returnToSearchResultsLink() {
        return waitForExpectedElement(By.xpath("//div[@id='coid_backToResults']//span[contains(text(),'Return To Search Results')]"));
    }

    /**
     * object representing the report profile on the delete profile pop up
     */
    public WebElement reportProfileOnDeleteProfilePopup(String profile) {
        return waitForExpectedElement(By.xpath("//ul[@id='deleteProfileList']//a[contains(text(),'" + profile + "')]"));
    }

    /**
     * object representing the delete button on the delete profile pop up
     */
    public WebElement deleteButtonOnDeleteProfilePopup() {
        return waitForExpectedElement(By.id("deleteProfileButton"));
    }

    /**
     * This is an object representing the company names in a deal comparison report as a group (necessary when checking ordering for example)
     */
    public List<String> getDealComparisonReportDeal() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//div[@id='reportBodyContainer']//tbody/tr/td[2]/a"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is an object representing the date administrators appointed in a deal comparison report as a group (necessary when checking ordering for example)
     */
    public List<String> getDealComparisonReportDateAdminAppointed() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//div[@id='reportBodyContainer']//tbody/tr/td[7]/div"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is an object representing the columns on Organize Columns popup as a group (necessary when checking ordering for example)
     */
    public List<String> getColumnsOrganizeColumns() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//ul[@id='columnList']//a"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * object representing the save button on the organize columns popup
     */
    public WebElement saveButtonOrganizeColumns() {
        return waitForExpectedElement(By.xpath("//div[@id='columnReorderLightbox']//input[@value='Save']"));
    }

    /**
     * object representing the cancel button on the organize columns popup
     */
    public WebElement cancelButtonOrganizeColumns() {
        return waitForExpectedElement(By.xpath("//div[@id='columnReorderLightbox']//a[text()='Cancel']"));
    }

    /**
     * object representing the clear selected button on the comparison terms selector
     */
    public WebElement clearSelected() {
        return waitForExpectedElement(By.id("unselectAll"));
    }

    /**
     * object representing the next arrow on the deal comparison report
     */
    public WebElement nextArrow() {
        return waitForExpectedElement(By.id("nextArrow"));
    }

    /**
     * object representing the previous arrow on the deal comparison report
     */
    public WebElement previousArrow() {
        return waitForExpectedElement(By.id("previousArrow"));
    }

    /**
     * object representing the heading "Download Report" or "Email Report" on the download/email report popup
     */
    public WebElement downloadEmailReportPopUpHeader(String header) {
        return waitForExpectedElement(By.xpath("//div[@id='co_deliveryLightbox']//h3[text()='" + header + "']"));
    }

    /**
     * object representing the different Comparison Terms options
     */
    public WebElement comparisonTermsOptions(String option) {
        option = option.replaceAll("’", "'");
        String text = "'" + option + "'";
        if (option.contains("'")) {
            option = "\"" + option + "\"";
            text = option;
        }
        return waitForExpectedElement(By.xpath("//div[@id='fieldGroupsContainer']//label[contains(text()," + text + ")]/parent::li"));
    }

    /**
     * object representing the Comparison Terms header which is displayed when the menu option to the left of the page
     * is expanded
     */
    public WebElement comparisonTermsHeader() {
        return waitForExpectedElement(By.xpath("//div[@id='kh_tocContainer']//span[contains(text(),'Comparison Terms')]"), 20);
    }

    public WebElement leftHandColumnSelect() {
        return waitForExpectedElement(By.xpath("//div[@class='kh_toc-content']"), 35);
    }

    public WebElement returnToSearchLink() {
        return waitForExpectedElement(By.xpath("//span[@class='kh_icon icon-reply-arrow']"), 10);
    }

    /**
     * object representing the menu icon on the comparison report page - this can be expanded to show the comparison
     * Comparison Terms header and all the comparison options
     */
    public WebElement menuIcon() {
        return waitForExpectedElement(By.xpath("//div[@id='kh_tocContainer']//span[@class='kh_icon icon-menu']"));
    }

    /**
     * object representing the download icon on the comparison report page
     */
    public WebElement downloadIcon() {
        return waitForExpectedElement(By.xpath("//a[@id='deliveryLinkRowDownload']"));
    }

    /**
     * object representing the email icon on the comparison report page
     */
    public WebElement emailIcon() {
        return waitForExpectedElement(By.xpath("//a[@id='deliveryLinkRowEmail']"));
    }

    /**
     * generic element to return a report header column
     */
    public String headerColumns(Integer columnNumber) {
        String columnName;
        /** Return columns that are not hidden */
        List<WebElement> columnNames = waitForExpectedElements(By.xpath("//div[@id='reportBodyContainer']//tr/th[not(contains(@class,'co_hideState'))]//span[@class='co_dcrTable_Header']"), 10);
        columnName = columnNames.get(columnNumber - 1).getText();
        return columnName;
    }

    public WebElement organizeColumnsLightBox() {
        return waitForExpectedElement(By.id("columnReorderLightbox"));
    }

    public WebElement homeNode() {
        return waitForExpectedElement(By.xpath("//a[@id='logo']"));
    }

}
