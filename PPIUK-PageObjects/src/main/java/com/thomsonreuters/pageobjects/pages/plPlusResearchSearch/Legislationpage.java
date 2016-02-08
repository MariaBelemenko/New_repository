package com.thomsonreuters.pageobjects.pages.plPlusResearchSearch;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

/**
 * This page Object is created to navigate to legislation Search Page
 */

public class Legislationpage extends AbstractPage {

    public Legislationpage() {
    }

    public WebElement ukLegislationClick() {
        return waitForExpectedElement(By.cssSelector("a[href*='UKLEGISLATION']"));
    }

    public WebElement displayLegislationResults() {
        try {
            return retryingFindElement(By.id("cobalt_search_ukLegislation_results"));
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            throw new PageOperationException(retryingFindElement(By.id("cobalt_search_no_results")).getText());
        }
    }

    public WebElement actTitleField() {
        return retryingFindElement(By.id("co_search_advancedSearch_TI"));
    }

    public WebElement provisionType() {
        return retryingFindElement(By.id("co_search_advancedSearch_PT"));
    }

    public WebElement provisionNumber() {
        return retryingFindElement(By.id("co_search_advancedSearch_PR"));
    }

    public WebElement globalSearchBox() {
        return waitForExpectedElement(By.id("searchInputId"));
    }

    public WebElement advErrorMsg() {
        return retryingFindElement(By.xpath("//div[@id='co_search_advancedSearch_errorMsgBox']//div[@class='co_infoBox_message']"));
    }

    public WebElement advErrorPN() {
        return retryingFindElement(By.xpath(".//*[@id='co_search_advancedSearch_errorList']/li"));
    }

    public WebElement advErrorPT() {
        return waitForExpectedElement(By.xpath(".//*[@id='co_search_advancedSearch_errorList']/li"));
    }

    public int getFacetCount(String jurisdiction) {
        try {
            return Integer.valueOf(waitFluentForElement(By.xpath(".//label[text()='" + jurisdiction + "']/../span[@class='co_facetCount']")).getText());
        } catch (TimeoutException te) {
            LOG.info("context", te);
            throw new PageOperationException("Exceeded time to find the facet count for : " + jurisdiction);
        }
    }

    public boolean isJurisdictionDisplayed() {
        try {
            return findElement(By.cssSelector(".co_facet_tree>li>label")).isDisplayed();
        } catch (NoSuchElementException nse) {
            LOG.info("context", nse);
        }
        return false;
    }

    public WebElement ukFacetExpand() {
        return waitForExpectedElement(By.cssSelector("a[id^='jurisdictionSummary']"));
    }

    public List<String> getMainJurisdictionFacets() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.cssSelector(".co_facet_tree>li>label[for^='facet_hierarchy_jurisdictionSummary']"))) {
                list.add(facet.getText());
            }
        } catch (PageOperationException te) {
            LOG.info("context", te);
            list = new ArrayList<String>();
        }
        return list;
    }

    public List<String> getUKJurisdictionFacets() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//label[text()='UK']/..//ul[contains(@id,'jurisdiction')]//li//label"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    public int getFacetCount(String facetGroup, String... facetNames) {
        String temp = "";
        String tempStr = "/label[text()='";
        try {
            StringBuilder xpath = new StringBuilder();
            if (facetGroup.equals("Jurisdiction")) {
                xpath.append(".//div[@id='facet_div_jurisdictionSummary']/ul/li");
            } else if (facetGroup.equals("Topic")) {
                xpath.append(".//div[@id='facet_div_topicSummary']/ul/li");
            } else if (facetGroup.equals("Document Type")) {
                xpath.append(".//div[@id='facet_div_legislationDocumentTypeSummary']/ul/li");
            } else if (facetGroup.equals("Status")) {
                xpath.append(".//div[@id='facet_div_legislationStatusSummary']/ul/li");
            }
            temp = xpath.toString();

            for (int i = 0; i < facetNames.length - 1; i++) {
                WebElement checkbox = retryingFindElement(By.xpath(xpath + tempStr + facetNames[i] + "']/../a"));
                if (checkbox.getAttribute("class").equals("co_facet_expand")) {
                    checkbox.click();
                }
                xpath.append("/div/ul/li");
            }
            xpath.append("/label[text()='%s']/../span[@class='co_facetCount']");
            int size = Integer.valueOf(retryingFindElement(By.xpath(String.format(xpath.toString(), facetNames[facetNames.length - 1]))).getText());

            for (int i = facetNames.length - 2; i >= 0; i--) {
                String extraURL = "";
                int j = i;
                while (j > 0) {
                    extraURL += "/div/ul/li";
                    j--;
                }
                if (extraURL.length() > 0) {
                    retryingFindElement(By.xpath(temp + extraURL + "/label[text()='" + facetNames[i] + "']/../a")).click();
                } else {
                    retryingFindElement(By.xpath(temp + "/label[text()='" + facetNames[i] + "']/../a")).click();
                }
            }
            return size;
        } catch (TimeoutException te) {
            LOG.info("context", te);
            throw new PageOperationException("Exceeded time to find the facet count for : ");
        }
    }

    public WebElement checkBoxByLabelName(String label) {
        WebElement findlabel = retryingFindElement(By.xpath("//div[contains(@id,'narrowResultsBy')]//label[text()='" + label + "']"));
        String labelFor = findlabel.getAttribute("for");
        return waitForExpectedElement(By.id(labelFor));
    }

    public WebElement childCheckBoxByLabelName(String label) {
        String path = "div[id^='facet_hierarchy_childrenjurisdictionSummary'] ul li";
        List<WebElement> webElements = findElements(By.cssSelector(path));
        for (WebElement webElement : webElements) {
            WebElement labelElement = webElement.findElement(By.cssSelector(path + ">label"));
            WebElement checkBox = webElement.findElement(By.cssSelector(path + ">input"));
            if (labelElement.getText().trim().equalsIgnoreCase(label)) {
                return checkBox;
            }
        }
        return null;
    }

    public void selectCheckBoxByLabelName(String facetGroup, String... facetNames) {
        getCheckBox(facetGroup, facetNames).click();
    }

    public boolean isCheckBoxSelected(String facetGroup, String... facetNames) {
        try {
            waitForElementPresent(By.id("co_facetHeaderjurisdictionSummary")).click();
            return getCheckBox(facetGroup, facetNames).isSelected();
        } catch (Exception e) {
            LOG.info("context", e);
            return false;
        }
    }

    private WebElement getCheckBox(String facetGroup, String[] facetNames) {
        String tempStr = "/label[text()='";
        try {
            StringBuilder xpath = new StringBuilder();
            if (facetGroup.equals("Jurisdiction")) {
                xpath.append(".//div[@id='facet_div_jurisdictionSummary']/ul/li");
            } else if (facetGroup.equals("Topic")) {
                xpath.append(".//div[@id='facet_div_topicSummary']/ul/li");
            } else if (facetGroup.equals("Document Type")) {
                xpath.append(".//div[@id='facet_div_legislationDocumentTypeSummary']/ul/li");
            } else if (facetGroup.equals("Status")) {
                xpath.append(".//div[@id='facet_div_legislationStatusSummary']/ul/li");
            }

            for (int i = 0; i < facetNames.length - 1; i++) {
                WebElement checkbox = retryingFindElement(By.xpath(xpath + tempStr + facetNames[i] + "']/../a"));
                if (checkbox.getAttribute("class").equals("co_facet_expand")) {
                    checkbox.click();
                }
                xpath.append("/div/ul/li");
            }
            xpath.append("/label[text()='%s']/../input");
            return retryingFindElement(By.xpath(String.format(xpath.toString(), facetNames[facetNames.length - 1])));
        } catch (TimeoutException te) {
            LOG.info("context", te);
            throw new PageOperationException("Exceeded time to find the facet count for : ");
        }
    }

    public int getLegislationCount() {
        int Size = Integer.valueOf(retryingFindElement(By.cssSelector(".co_search_titleCount")).getText().replace("(", "").replace(")", "").replace(",", "").trim());
        return Size;
    }

}