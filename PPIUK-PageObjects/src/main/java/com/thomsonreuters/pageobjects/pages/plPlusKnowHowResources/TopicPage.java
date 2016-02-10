package com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by u0171568 on 20/02/2015.
 */

public class TopicPage extends AbstractPage {


    public Map<String, String> getEditorPicksAsMap() {
        findElement(By.cssSelector("#coid_website_browseTopColumn"));
        List<WebElement> editorPicks = findElements(By.cssSelector("#coid_website_browseTopColumn div[id^=ContentBlock]"));
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < editorPicks.size(); i++) {
            String resourceLink = findElement(By.cssSelector("#coid_website_browseTopColumn div#ContentBlock" + i + " h3>a")).getText().trim();
            String metadata = findElement(By.cssSelector("#coid_website_browseTopColumn div#ContentBlock" + i + "  h4")).getText().trim();
            map.put(resourceLink, metadata);
        }
        return map;
    }

    public Map<String, String> getTopicPageFacetsAsMap() {
        List<WebElement> FacetsList = findElements(By.cssSelector("#ukplc_topic_facet_links li a"));
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < FacetsList.size(); i++) {
            String facet = FacetsList.get(i).getText().trim();
            String[] facetValues = facet.split("\n");
            String facetName = facetValues[0];
            String facetCount = facetValues[1];
            map.put(facetName, facetCount);
        }
        return map;
    }

    public List<String> getResourcesList(String resourceType) {
        List<String> list = new ArrayList<String>();
        int titleNumber = 0;
        String idTitle = "";
        List<WebElement> resourceList = retryingFindElements(By.xpath("//div[@id='cobalt_search_knowHowTopicPlc_" + resourceType + "']//ol/li"));
        //List<WebElement> resourceList = findElements(By.cssSelector("#cobalt_search_knowhowtopicuk_results>div[id = 'cobalt_search_knowhowtopicuk_Practice_note:_overview'] li[id*='cobalt_search_results_knowhowtopicuk'] label"));
        for (WebElement result : resourceList) {
            idTitle = result.getAttribute("id");
            titleNumber = Integer.parseInt(idTitle.substring(idTitle.length() - 1));
            LOG.info(result.findElement(By.id("cobalt_result_knowhow_title" + titleNumber)).getText());
            list.add(result.findElement(By.id("cobalt_result_knowhow_title" + titleNumber)).getText());
        }
        return list;
    }

    public List<String> optionalBlockTitle() {

        List<WebElement> blocks = findElements(By.cssSelector("#coid_website_browseRightColumn .plplus_topic_container"));
        List<String> blockNames = new ArrayList<String>();

        for (WebElement element : blocks) {
            if (!element.getAttribute("class").contains("co_hideState")) {
                String blockVisible = element.findElement(By.cssSelector(".co_genericBoxHeader")).getText().trim();
                blockNames.add(blockVisible);
            }
        }
        return blockNames;
    }

    public WebElement pageNumber(int pageNum) {
        return findElement(By.id("co_search_footer_pagination_page" + pageNum));
    }

    public String currentPageSelected() {
        WebElement currentSelectedPage = retryingFindElement(By.id("co_search_footer_pagination_current"));
        return currentSelectedPage.getText();
    }

    public void selectEditorsPickResourceByTitle(String title) {
        WebElement element = waitAndFindElement(By.linkText(title));
        String idValue = element.getAttribute("id");
        String index = idValue.substring(idValue.lastIndexOf("_"));
        findElement(By.id("cobalt_artifact_delivery_checkbox_NaN" + index)).click();
    }

    public void selectTopicPageResourceByTitle(String title) {
//        WebElement element = waitAndFindElement(By.linkText(title));
//        String idValue = element.getAttribute("id");
//        String index = idValue.substring((idValue.length() - 1));
//        findElement(By.id("cobalt_search_knowhow_checkbox_" + index)).click();
        retryingFindElement(By.xpath(".//label[text()='"+title+"']/../../input")).click();
    }

    public WebElement clickResourceLinkOnEditorsPick(String resourceLink) {
        return waitForExpectedElement(By.linkText(resourceLink));
    }

	public WebElement topicPageTitle() {
		return waitForExpectedElement(By.id("co_browsePageLabel"));
	}

    public WebElement deliverLink() {
        return findElement(By.linkText("Deliver"));
    }

    public int totalResourcesOnFirstPage() {
        List<WebElement> resourceList = findElements(By.cssSelector("#coid_website_searchResults li[id^=cobalt_search_results_knowHowTopic]"));
        return resourceList.size();
    }

    public WebElement clickTopicLinkOnPAPage(String resourceLink) {
        return waitForExpectedElement(By.linkText(resourceLink));
    }

    public boolean NoEditorsPickWidget() {
        try {
            findElement(By.cssSelector("#coid_website_browseTopColumn>div"));
        } catch (NoSuchElementException nse) {
            return true;
        }
        return false;
    }

    public WebElement facetNameLink(String facet) {
        return retryingFindElement(By.xpath(".//ul[@id='ukplc_topic_facet_links']//a[text()='" + facet + "']"));
    }

    public WebElement resultsByResourceType(String resourceType) {
        return waitForExpectedElement(By.id("cobalt_search_knowHowTopicPlc_" + resourceType));
    }

    //public WebElement getTopicPageClickTopicLinkOnPAPage(String resourceLink) {
       // return waitForExpectedElement(By.linkText(resourceLink));
    //}

	public WebElement getChoosePracticeAreaPageTitle() {
		return waitForExpectedElement(By.xpath(".//div[@id='coid_topic_practice_areas']/h3"));
	}
    public WebElement resourceHeading(String resourceName) {
        return waitForExpectedElement(By.xpath("//div[@id='cobalt_search_knowHowTopicPlc_results']//h2[contains(text(),'" + resourceName + "')]"));
    }
    public WebElement specificFacetCount(String facetName) {
        return waitForElementPresent(By.xpath("//ul[@id='ukplc_topic_facet_links']//li//a[text()='" + facetName + "']/..//span"));
    }

    public List<WebElement> resourceDocsTitleList(String resourceName) {
        return waitForExpectedElements(By.xpath("//h2[text()='" + resourceName + "']/..//a[contains(@id,'cobalt_result_knowhow_title')]"));
    }
    public List<WebElement> resourceDocTitleAllList() {
        return waitForExpectedElements(By.xpath("//a[contains(@id,'cobalt_result_knowhow_title')]"));
    }

    public By resourceDocByTitleList() {
        return By.xpath("//a[contains(@id,'cobalt_result_knowhow_title')]");
    }

}