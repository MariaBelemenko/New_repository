package com.thomsonreuters.pageobjects.utils.homepage;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import org.slf4j.LoggerFactory;

/**
 * Created by Ian Hudson uc087619 on 16/02/2016.
 */
public class HomePageUtils {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonMethods.class);

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();

    public void clickThePracticalLawHomepageLogo() {
        practicalLawHomepage.practicalLawTRLogo().click();
    }

}
