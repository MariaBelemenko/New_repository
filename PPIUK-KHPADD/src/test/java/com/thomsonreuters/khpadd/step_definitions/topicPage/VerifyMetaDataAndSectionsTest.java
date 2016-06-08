package com.thomsonreuters.khpadd.step_definitions.topicPage;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.CommonResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.rest.LinkingBaseUtils;
import com.thomsonreuters.pageobjects.utils.document.Document;
import com.thomsonreuters.pageobjects.utils.document.content.Section;
import com.thomsonreuters.pageobjects.utils.document.metadata.Jurisdiction;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;

public class VerifyMetaDataAndSectionsTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private LinkingBaseUtils linkingUtils = new LinkingBaseUtils();
    private CommonResourcePage commonResourcePage = new CommonResourcePage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private CommonMethods comMethods = new CommonMethods();
    private DocumentRightPanelPage rhsPanel = new DocumentRightPanelPage();


    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.waitForPageToLoad();
        categoryPage.openPageByText(linkName);
    }

    @When("^the user clicks on the '(.+)' link$")
    public void clickDocumentLink(String linkName) throws Throwable {
        categoryPage.waitForPageToLoad();
        categoryPage.clickOnLinkInText(linkName);
    }

    @Then("^the user verifies MetaData and Sections$")
    public void theUserVerifiesMetaDataAndSections() {
        SoftAssertions softAssertions = new SoftAssertions();
        Document docMetaData = linkingUtils.getDocumentMetaDataAndSectionsFromFatWire(commonResourcePage.plcRef().getText());
        List<String> documentSections = (standardDocumentPage.isContainsSection()) ?
                comMethods.getTextsFromWebElements(commonResourcePage.allHeadings()) : new ArrayList<String>();
        List<String> productsMetadata = comMethods.getTextsFromWebElements(standardDocumentPage.getProductsFromMetadata(), ",");
        List<String> jurisdictionsMetadata = rhsPanel.getVisibleJurisdictions();
        List<String> xmlSections = getSectionTitlesFromXml(docMetaData.getSections());
        List<String> xmlProducts = getProductNamesFromXml(docMetaData.getProducts());
        List<String> xmlJurisdictions = getJurisdictionNamesFromXml(docMetaData.getJurisdictions());

        /** XML data is expected, page data - is actual. So, let's remove actual results from expected.
         And if result list will be with 0 elements than all necessary data are present on the page. */
        xmlSections.removeAll(documentSections);
        xmlProducts.removeAll(productsMetadata);
        xmlJurisdictions.removeAll(jurisdictionsMetadata);
        softAssertions.assertThat(xmlSections)
                .withFailMessage("Following sections from XML are absent on the page: " + xmlSections)
                .isEmpty();
        softAssertions.assertThat(xmlProducts)
                .withFailMessage("Following products from XML meta-data are absent on the page: " + xmlProducts)
                .isEmpty();
        softAssertions.assertThat(xmlJurisdictions)
                .withFailMessage("Following jurisdictions from XML meta-data are absent on the page: " + xmlJurisdictions)
                .isEmpty();

        /** Verify doc resource type
         Sometimes resource type can be obtained with unnecessary space which should be removed by .trim() method */
        softAssertions.assertThat(rhsPanel.resourceTypeText().getText().trim())
                .isEqualTo(docMetaData.getResourceType().trim());
        softAssertions.assertAll();
    }

    /**
     * Get list with section titles from the section list, which got from Legacy Fatwire
     *
     * @param sections List with {@link Section}s
     * @return List with section titles
     */
    private List<String> getSectionTitlesFromXml(List<Section> sections) {
        List<String> result = new ArrayList<>();
        for (Section section : sections) {
            result.add(section.getTitle());
        }
        return result;
    }

    /**
     * Get list with product names from the product list, which got from Legacy Fatwire
     *
     * @return List with product names
     */
    private List<String> getProductNamesFromXml(List<com.thomsonreuters.pageobjects.utils.document.metadata.Product> products) {
        List<String> result = new ArrayList<>();
        for (com.thomsonreuters.pageobjects.utils.document.metadata.Product product : products) {
            result.add(product.getName());
        }
        return result;
    }

    /**
     * Get list with jurisdiction names from the jurisdiction list, which got from Legacy Fatwire
     *
     * @param jurisdictions List with {@link Jurisdiction}s
     * @return List with jurisdiction names
     */
    private List<String> getJurisdictionNamesFromXml(List<Jurisdiction> jurisdictions) {
        List<String> result = new ArrayList<>();
        for (Jurisdiction jurisdiction : jurisdictions) {
            result.add(jurisdiction.getName());
        }
        return result;
    }

}
