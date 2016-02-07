package com.thomsonreuters.globalpages.step_definitions.common;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.globalPage.ChinaCategoryPage;
import cucumber.api.java.en.Then;

import java.util.List;

public class ChinaPageLinksTest extends BaseStepDef {

    private ChinaCategoryPage chinaCategoryPage = new ChinaCategoryPage();

    @Then("^the user sees \"(.*?)\" and the list of links$")
    public void theUserSeesAndTheListOfLinks(String header, List<String> links) throws Throwable {
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header).size() == links.size())
//                .overridingErrorMessage("Size of list of links is not right").isTrue();
//        for (int i = 0; i < chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header).size(); i++) {
//            softly.assertThat(
//                    chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header).get(i).getText()
//                            .equals(links.get(i))
//            )
//                    .overridingErrorMessage(
//                            chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header).get(i).getText()
//                                    + " not equals to " + links.get(i)
//                    ).isTrue();
//            softly.assertThat(chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header).get(i).isDisplayed())
//                    .overridingErrorMessage(
//                            chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header).get(i)
//                                    + " is not displayed"
//                    );
//        }
//        softly.assertAll();
    }

}
