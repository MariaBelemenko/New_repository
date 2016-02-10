package com.thomsonreuters.pageobjects.pages.search;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.*;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class KnowHowSearchResultsPage extends AbstractPage {


    public KnowHowSearchResultsPage() {
    }

    /**
     * expand a facet
     */
    public WebElement expandFacet(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='co_narrowResultsBy']//label[contains(text(),'" + facetName + "')]/../a[@class='co_facet_expand']"));
    }

    /**
     * collapse a facet
     */
    public WebElement collapseFacet(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='co_narrowResultsBy']//label[contains(text(),'" + facetName + "')]/../a[@class='co_facet_collapse']"));
    }

    /**
     * this is the facet name - pass in the facet name as a string e.g. Standard clauses
     */
    public WebElement facetName(String Name) throws Exception {
        return retryingFindElement(By.xpath("//div[contains(@id,'narrowResultsBy')]//label[contains(text(),'" + Name + "')]"));
    }

    /**
     * This method is to verify the facet name is displayed ot not.
     *
     * @param Name
     * @return boolean
     */
    public boolean isFacetNameDisplayed(String Name) {
        try {
            return retryingFindElement(By.xpath("//div[contains(@id,'narrowResultsBy')]//label[contains(text(),'" + Name + "')]")).isDisplayed();
        } catch (PageOperationException pe) {
            LOG.info("context", pe);
            return false;
        }
    }

    /**
     * Object representing the total search result count for the search
     */
    public WebElement knowHowSearchResultCount() {
        return retryingFindElement(By.xpath("//div[@id='coid_website_searchAvailableFacets']//span[@class='co_search_titleCount']"));
    }

    /**
     * Object representing any know how facet checkbox as identified by facet name
     */
    public WebElement knowHowFacetCheckbox(String facetName) {
        try {
            WebElement findlabel = retryingFindElement(By.xpath("//div[contains(@id,'narrowResultsBy')]//label[text()='" + facetName + "']"));
            String labelFor = findlabel.getAttribute("for");
            return waitForExpectedElement(By.id(labelFor));
        } catch (StaleElementReferenceException se) {
            return knowHowFacetCheckbox(facetName);
        }
    }

    /**
     * Object representing Resource Type heading for know how facet group
     */
    public WebElement facetGroupHeaderResourceType() {
        return waitForExpectedElement(By.id("co_facetHeaderknowHowResourceTypeSummary"));
    }
    /**
     * By Object representing Resource Type heading for know how facet group
     */
    public By resourceTypeFacetGroupByTitle() {
        return By.id("co_facetHeaderknowHowResourceTypeSummary");
    }

    /**
     * Object representing Practice Area heading for know how facet group
     */
    public WebElement facetGroupHeaderPracticeArea() {
        return waitForExpectedElement(By.id("co_facetHeaderknowHowPracticeAreaSummary"));
    }

    /**
     * Object representing Jurisdiction heading for know how facet group
     */
    public WebElement facetGroupHeaderJurisdiction() {
        return waitForExpectedElement(By.id("co_facetHeaderknowHowJurisdictionSummary"));
    }

    /**
     * This is an object representing the Apply Filters button
     */
    public WebElement applyFiltersButton() {
        return retryingFindElement(By.linkText("Apply filters"));
    }

    /**
     * This is an object representing the facet count associated with each facet (any facet on the know how page)
     */
    public WebElement facetCount(String facetname) {
        return retryingFindElement(By.xpath("//div[@id='co_narrowResultsBy']//label[contains(text(),'" + facetname + "')]/../span[@class='co_facetCount']"));
    }

    /**
     * This is an object for all the listed know how jurisdiction facets
     */
    public List<String> getJurisdictionFacets() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//div[@id='co_narrowResultsBy']/div/h4[contains(text(), 'Jurisdiction')]/../ul/li/label"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is an object representing a facet in an expanded state
     */
    public WebElement expandedKnowHowFacet(String facetname) {
        return waitForExpectedElement(By.xpath("//ul[@class='co_facet_tree']//label[text()='" + facetname + "']/preceding-sibling::a[@class='co_facet_collapse']"));
    }

    /**
     * This is an object representing a facet in an collapsed state
     */
    public WebElement collapsedKnowHowFacet(String facetname) {
        return waitForExpectedElement(By.xpath("//ul[@class='co_facet_tree']//label[text()='" + facetname + "']/preceding-sibling::a[@class=' co_facet_expand']"));
    }

    /**
     * This is an object representing the practice area facets as a group (necessary when checking ordering for example)
     */
    public List<String> getMainPracticeAreaFacets(String facetHeaderName) {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//h4[contains(@class,'facet_header')]/self::h4[text()='" + facetHeaderName + "']/../ul/li/label"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is an object representing the child practice area facets as a group (necessary when checking ordering for example)
     */
    public List<String> getChildPracticeAreaFacets(String facetHeaderName) {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//div[@id='facet_div_knowHowPracticeAreaSummary']//label[text()='" + facetHeaderName + "']/../div/ul/li/label"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is an object representing the grandchild practice area facets as a group (necessary when checking ordering for example)
     */
    public List<String> getGrandchildPracticeAreaFacets(String facetHeaderName) {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement facet : retryingFindElements(By.xpath("//div[@id='facet_div_knowHowPracticeAreaSummary']//label[text()='" + facetHeaderName + "']/../div/ul/li/label"))) {
                list.add(facet.getText());
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is an object representing the facet counts as a group (necessary when checking ordering for example)
     */
    public List<Integer> getFacetCounts(String facetHeaderName) {
        List<Integer> list = new ArrayList<Integer>();
        try {
            for (WebElement facetCounts : retryingFindElements(By.xpath("//h4[contains(@class,'facet_header')]/self::h4[text()='" + facetHeaderName + "']/../ul/li/span"))) {
                int facetCounts2 = Integer.parseInt(facetCounts.getText().replace(",", ""));
                list.add(facetCounts2);
            }
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return list;
    }

    /**
     * This is for "Clear all" link element
     */
    public WebElement clearAllLink() {
        return waitForExpectedElement(By.xpath("//div[@id='co_undoAllSelections']/a"));
    }




    /**
     * This is for "Combined Know How UK" title element
     */
    public WebElement combinedKnowHowUKTitle() {
        return waitForExpectedElement(By.xpath("//h1[@id='co_browsePageLabel' and text()='Combined Know How UK']"));
    }

    /**
     * This is for "Practice Area" facet label element
     */
    public WebElement practiceAreaFacetLabel() {
        return waitForExpectedElement(By.id("co_facetHeaderknowHowPracticeAreaSummary"));
    }

    /**
     * This is the dropdown to select search results per page
     */
    public WebElement resultDropdown() {
        return retryingFindElement(By.id("coid_search_pagination_size"));
    }

    /**
     * This is the generic method to verify the any facet under the any group and returns the bolean value accordingly.
     *
     * @param facetGroup (Mention the facet group ex., ResourceType/Jurisdiction/Practice Area)
     * @param facetNames (path to the facet eg., StandardDocumentsAndClauses > Drafting notes)
     * @return boolean
     */
    public boolean isFacetDisplayed(String facetGroup, String... facetNames) {
        try {
            return retryingFindElement(By.xpath(String.format(generateFacetXpath(facetGroup, facetNames).toString(), facetNames[facetNames.length - 1]))).isDisplayed();
        } catch (PageOperationException p) {
            LOG.info("context", p);
            return false;
        }
    }

    /**
     * This is the generic method to verify that given facet is not expected to display under the any group and returns the bolean value accordingly.
     *
     * @param facetGroup (Mention the facet group ex., ResourceType/Jurisdiction/Practice Area)
     * @param facetNames (path to the facet eg., StandardDocumentsAndClauses > Drafting notes)
     * @return boolean
     */
    public boolean isFacetNotDisplayed(String facetGroup, String[] facetNames) {
        try {
            return !(waitForExpectedElement(By.xpath(String.format(generateFacetXpath(facetGroup, facetNames).toString(), facetNames[facetNames.length - 1])), 10).isDisplayed());
        } catch (PageOperationException | TimeoutException p) {
            LOG.info("context", p);
            return false;
        }
    }

    private StringBuilder generateFacetXpath(String facetGroup, String[] facetNames) {
        StringBuilder xpath = getFacetTypeXpath(facetGroup);
        String tempStr = "/label[text()='";
        try {
            for (int i = 0; i < facetNames.length - 1; i++) {
                WebElement checkbox = retryingFindElement(By.xpath(xpath + tempStr + facetNames[i] + "']/../a"));
                if (checkbox.getAttribute("class").equals("co_facet_expand")) {
                    checkbox.click();
                }
                xpath.append("/div/ul/li");
            }
            xpath.append("/label[text()='%s']");
        } catch (TimeoutException te) {
            throw new PageOperationException("Exceeded time to find the facet" + facetNames[facetNames.length - 1]);
        }
        return xpath;
    }

    private StringBuilder getFacetTypeXpath(String facetGroup) {
        StringBuilder xpath = new StringBuilder();
        if (facetGroup.equals("Resource Type")) {
            xpath.append(".//div[@id='facet_div_knowHowResourceTypeSummary']/ul/li");
        } else if (facetGroup.equals("Practice Area")) {
            xpath.append(".//div[@id='facet_div_knowHowPracticeAreaSummary']/ul/li");
        } else if (facetGroup.equals("Jurisdiction")) {
            xpath.append(".//div[@id='facet_div_knowHowJurisdictionSummary']/ul/li");
        }
        return xpath;
    }

    /**
     * This is the generic method to verify the any parent facet has child facets or not and returns the bolean value accordingly.
     *
     * @param facetGroup (Mention the facet group ex., ResourceType/Jurisdiction/Practice Area)
     * @param facetNames (path to the parent facet eg., StandardDocumentsAndClauses > Drafting notes)
     * @return boolean
     */
    public boolean isParentHasAtLeastOneChildFacet(String facetGroup, String[] facetNames) {
        try {
            return retryingFindElement(By.xpath(String.format(generateFacetXpath(facetGroup, facetNames).toString() + "/../div/ul", facetNames[facetNames.length - 1]))).isDisplayed();
        } catch (PageOperationException p) {
            LOG.info("context", p);
            return false;
        }
    }

    /**
     * This is to verify that no facets are diaplyed on search results page when there is 0 results.
     *
     * @return boolean
     */
    public boolean isNoFacetsAreAvailable() {
        return (!(isAnyResourceTypeFacetsDisplayed() || isAnyPracticeAreaFacetsDisplayed() || isAnyJuriscitionFacetsDisplayed()));
    }

    private boolean isAnyResourceTypeFacetsDisplayed() {
        try {
            return waitForExpectedElement(By.cssSelector("div#facet_div_knowHowResourceTypeSummary/ul"), 5).isDisplayed();
        } catch (TimeoutException te) {
            LOG.info("context", te);
            return false;
        }
    }

    private boolean isAnyPracticeAreaFacetsDisplayed() {
        try {
            return waitForExpectedElement(By.cssSelector("div#facet_div_knowHowPracticeAreaSummary/ul"), 5).isDisplayed();
        } catch (TimeoutException te) {
            LOG.info("context", te);
            return false;
        }
    }

    private boolean isAnyJuriscitionFacetsDisplayed() {
        try {
            return waitForExpectedElement(By.cssSelector("div#facet_div_knowHowJurisdictionSummary/ul"), 5).isDisplayed();
        } catch (TimeoutException te) {
            LOG.info("context", te);
            return false;
        }
    }

    /**
     * This is the first result structure of the search result page
     */
    public List<WebElement> searchFirstResultElementsList() {
        return waitForExpectedElements(By.xpath("//div[@id='co_searchResults_citation_1']//div"));
    }
    /**
     * This is the first result summary of the search result page
     */
    public WebElement searchFirstResultElementsSummary() {
        return waitForExpectedElement(By.xpath("//div[@id='co_searchResults_summary_1']"));
    }

    /**
     * This method is to get the displayed facet names under given Parent Facet name.
     * Whenever Parent Facet name is not present it will return the all parent facets under given facet type group.
     *
     * @param facetType
     * @param parentFacetNames
     * @return List<String>
     */
    public List<String> getFacetNamesUnderFacetType(String facetType, String... parentFacetNames) {
        List<String> list = new ArrayList<String>();
        StringBuilder xpath = new StringBuilder();
        if (StringUtils.isEmpty(facetType)) {
            throw new IllegalArgumentException("FacetType should not be blank or null");
        }
        try {
            xpath = getFacetTypeXpath(facetType);
            if (!StringUtils.isEmpty(parentFacetNames)) {
                for (int i = 0; i < parentFacetNames.length; i++) {
                    WebElement checkbox = retryingFindElement(By.xpath(xpath + "/label[text()='" + parentFacetNames[i].trim() + "']/../a"));
                    if (checkbox.getAttribute("class").equals("co_facet_expand")) {
                        checkbox.click();
                    }
                    xpath.append("/label[text()='" + parentFacetNames[parentFacetNames.length - 1].trim() + "']/../div/ul/li");
                }
            }
            xpath.append("/label");
            for (WebElement element : retryingFindElements(By.xpath(xpath.toString()))) {
                list.add(element.getText());
            }
            if (!StringUtils.isEmpty(parentFacetNames)) {
                xpath = getFacetTypeXpath(facetType);
                for (int i = 0; i < parentFacetNames.length; i++) {
                    WebElement checkbox = retryingFindElement(By.xpath(xpath + "/label[text()='" + parentFacetNames[i].trim() + "']/../a"));
                    if (!checkbox.getAttribute("class").equals("co_facet_expand")) {
                        checkbox.click();
                    }
                }
            }
        } catch (TimeoutException te) {
            LOG.info("Exceeded time to find the Resource Type facets", te);
        }
        return list;
    }

    /**
     * This method does the waiting until results to be loaded on Search results page.
     */
    public void waitForSearchResults() {
        try {
            try {
                waitForElementVisible(By.cssSelector(".co_search_ajaxLoading"));
                try {
                    waitForElementInvisible(By.cssSelector(".co_search_ajaxLoading"));
                } catch (TimeoutException | NoSuchElementException te) {
                    LOG.info("Page loading issue...." + te.getMessage());
                }
            } catch (TimeoutException | NoSuchElementException te) {
                LOG.info("context", te);
            }
            //retryingFindElements(By.cssSelector("h3 a"));
        } catch (PageOperationException | TimeoutException  te) {
            throw new PageOperationException("Exceeded time to locate the results on search results page" + te.getMessage());
        }
    }

    public void selectFacetCheckBox(String facetGroup, String... facetNames) {
        getCheckBox(facetGroup, facetNames).click();
    }

    private WebElement getCheckBox(String facetGroup, String[] facetNames) {
        try {
            String xpath = "/../input";
            return retryingFindElement(By.xpath(String.format(generateFacetXpath(facetGroup, facetNames).toString(), facetNames[facetNames.length - 1]) + xpath));
        } catch (TimeoutException te) {
            LOG.info("context", te);
            throw new PageOperationException("Exceeded time to find the facet count for : ");
        }
    }

    /**
     * This is the generic method to verify the any facet is selected under the any group and returns the bolean value accordingly.
     *
     * @param facetGroup (Mention the facet group ex., ResourceType/Jurisdiction/Practice Area)
     * @param facetNames (path to the facet eg., StandardDocumentsAndClauses > Drafting notes)
     * @return boolean
     */
    public boolean isFacetSelected(String facetGroup, String... facetNames) {
        try {
            return getCheckBox(facetGroup, facetNames).isSelected();
        } catch (PageOperationException p) {
            LOG.info("context", p);
            return false;
        }
    }

    /**
     * This method verifies the more option is avialable or not and returns the boolean accordingly.
     *
     * @return boolean
     */
    public boolean isMoreOptionAvailableForKnowHowJurisdiction() {
        try {
            return retryingFindElement(By.linkText("More Jurisdictions")).isDisplayed();
        } catch (PageOperationException se) {
            LOG.info("context", se);
        }
        return false;
    }

    /**
     * This method clicks on the more option present under the given facet group name.
     */
    public void clickMoreOptionOnKnowHowJurisdiction() {
        try {
            retryingFindElement(By.linkText("More Jurisdictions")).click();
            waitForElementVisible(By.id("co_facet_knowHowJurisdictionSummary_popup"));
        } catch (TimeoutException se) {
            LOG.info("context", se);
            throw new PageOperationException("Exceeded time to find the More popup.");
        }
    }

    /**
     * This is the method to enable the Apply Filters button by clicking on Select Multiple Filters button on results page.
     */
    public void clickOnSelectMultipleFilters() {
        try {
            WebElement button = waitForExpectedElement(By.linkText("Select multiple filters"), 2);
            button.click();
        } catch (Exception e) {
            LOG.info("context", e);
        }
    }

    /**
     * This is the object representing the Select multiple filters button
     */
    public WebElement selectMultipleFiltersButton() {
        return waitForExpectedElement(By.linkText("Select multiple filters"));
    }

    /**
     * This is the title of the know how search result in position X
     */
    public WebElement knowHowSearchResultTitle(String result) {
        return waitForExpectedElement(By.id("cobalt_result_knowhow_title" + result));
    }

    /**
     * This method is used to click on ResultItem link present on results page based on given resultIndex.
     *
     * @param resultIndex
     */
    public void clickOnResultItem(int resultIndex) {
        retryingFindElement(By.id("cobalt_result_knowhow_title" + resultIndex)).click();
    }

    /**
     * This method returns the displayed search suggestions as list of strings.
     *
     * @return List<String>
     */
    public List<String> getSearchSuggestions() {
        List<String> list = new ArrayList<String>();
        try {
            for (WebElement element : retryingFindElements(By.cssSelector("#searchBoxIndexSpan li"))) {
                list.add(element.getText());
            }
            return list;
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return Collections.emptyList();
        }
    }

    public void useKeyBoard(List<Keys> keys, WebElement element) {
        for (Keys key : keys) {
            element.sendKeys(key);
        }
    }

    /**
     * Page object for the date on the first result
     */


        public WebElement date() {
            return waitForExpectedElement(By.xpath("//div[@id='co_searchResults_citation_1']//div/strong/span"));
        }



    public boolean isFacetCountPresent(String count) {
        try{
            for(WebElement element: retryingFindElements(By.xpath("//div[@id='co_narrowResultsBy']//span[@class='co_facetCount']"))){
                if(element.getText().equals(count)){
                    return true;
                }
            }
        }catch(Exception e){
            
        }
        return false;
    }
    /**
     * Page per dropdown link
     */
    public WebElement searchPerPageDrodownLink() {
        return waitForExpectedElement(By.xpath("//a[@id='selectedDisplayItemCount']"));
    }

    /**
     * Page per dropdown list items (20,50,100)
     */
    public List<WebElement> searchPerPageDrodownListItemLinks() {
        return waitForExpectedElements(By.xpath("//div[@id='displayItemCount']//ul[@class='co_dropDownMenuList']//li//a"));
    }
    /**
     * Page per pagination list items (1,2,3...> >>)
     */
    public List<WebElement> searchPaginationItemLinks() {
        return waitForExpectedElements(By.xpath("//ul[@id='co_navigationFooter']//li//a"));
    }

    /**
     * Search Result page heading
     */
    public WebElement searchResultHeading() {
        return waitForExpectedElement(By.xpath("//div[@id='co_subHeader']//h1"));
    }

    /**
     * Search Result page heading
     */
    public WebElement searchResultHeadingWithString(String headingText) {
        return waitForExpectedElement(By.xpath("//div[@id='co_subHeader']//h1[contains(.,'" + headingText + "')]"));
    }
    /**
     * List of Results after first 12 results
     */
    public List<WebElement> searchResultsItemsList() {
        return waitForExpectedElements(By.xpath("//ol[@class='co_searchResult_list']//li[contains(@id,'cobalt_search_results_know')]"));
    }
    /**
     * Results count like "1-20"
     */
    public WebElement searchResultCountLabel() {
        return waitForExpectedElement(By.xpath("//ol[@id='co_navigationPages']//span"));
    }

    /**
     * Results count like "1-20"
     */
    public By searchResultByCountLabel() {
        return By.id("selectedDisplayItemCount");
    }

    /**
     * Searching wrong result gives you the no result following paragraph
     */
    public WebElement searchNoResultParagraph() {
        return waitForExpectedElement(By.id("cobalt_search_no_results"));
    }
    /**
     * Whole filter facet element
     */
    public WebElement searchFilterFacet() {
        return waitForExpectedElement(By.id("co_website_searchFacets"));
    }

    /**
     * This method is to find the notes added icon is displayed or not based on the given result positions
     * @param position
     * @return boolean
     */
    public boolean isNotesAddedLinkPresent(String position){
        try{
            return retryingFindElement(By.cssSelector("#cobalt_search_results_knowHowPlc"+position+" .co_document_icon_notes>img")).isDisplayed();
        }catch(PageOperationException te){}
        return false;
    }

    /**
     * This is for "Clear all" link element for history page
     */
    public WebElement historyPageClearAllFiltersLink() {
        return waitForExpectedElement(By.xpath("//div[@id='co_undoAllSelectionsHistory']/a[@class='co_btnGray co_btnBack']"));
    }

    /**
     * This is for "Cliend ID " facets element for history page
     */
    public WebElement clientIDFacetCheckbox(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='facet_div_Client_IDs']//label[contains(.,'"+facetName+"')]/../input"));
    }

    /**
     * This is for "Cliend ID " facets element for history page
     */
    public WebElement clientIDByFacetCheckbox(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='facet_div_Client_IDs']//label[contains(.,'"+facetName+"')]/../input"));
    }

    /**
     * This is for "Event" facets element for history page
     */
    public WebElement eventFacetCheckbox(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='facet_div_Event']//label[contains(.,'"+facetName+"')]/../input"));
    }

    /**
     * This is for "Cliend ID " facets count element for history page
     */
    public WebElement clientIDFacetCount(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='facet_div_Client_IDs']//label[contains(.,'"+facetName+"')]/../span"));
    }
    /**
     * This is for "Event" facets element for history page
     */
    public WebElement eventFacetCount(String facetName) {
        return waitForExpectedElement(By.xpath("//div[@id='facet_div_Event']//label[contains(.,'"+facetName+"')]/../span"));
    }

    /**
     * This is for List of elements of clientID column history page
     */
    public List<WebElement> clientIDCellList() {
        return waitForExpectedElements(By.xpath("//table[@class='co_detailsTable']//tr//td[@class='co_detailsTable_clientId']//span"));
    }
    /**
     * This is for List of elements of Event column history page
     */
    public List<WebElement> eventCellList() {
        return waitForExpectedElements(By.xpath("//table[@class='co_detailsTable']//tr//td[@class='co_detailsTable_event']//span"));
    }

    /**
     * Get results count for the search after waiting
     * @return Results count
     */
    public WebElement waitKnowHowSearchResultCount() {
        // knowHowSearchResultCount() method is inapplicable here because for current method need more waiting,
        // when element will be visible, without any retries, just wait
        return waitForElementVisible(By.xpath("//div[@id='coid_website_searchAvailableFacets']//span[@class='co_search_titleCount']"));
    }

    /**
     * Get check-box element of given facet name
     * @param facetName Facet name
     * @return Check-box element of given facet name
     */
    public WebElement getFacetCheckbox(String facetName) {
        return waitForElementVisible(By.xpath("//div[@id='co_narrowResultsBy']//li[contains(., '" + facetName + "')]/input[@type='checkbox']"));
    }

    /**
     * Indicate if "Cancel" button exists for facets
     * @return True - if check passed, otherwise - false.
     */
    public boolean isCancelButtonExists() {
        return isExists(By.xpath("//a[contains(@onclick, 'cancelMultiFacetMode') and not(contains(@class, 'hideState'))]"));
    }

    /**
     * Get check-box element of given facet name
     * @param snippetRowNumber to get specific row number
     * @return
     */
    public List<WebElement> snippetSearchTermList(int snippetRowNumber) {
        return waitForElementsVisible(By.xpath("//a[@id='cobalt_result_knowhow_snippet_"+snippetRowNumber+"_1']//span[@class='co_searchTerm']"));
    }

}