package com.thomsonreuters.researchdocdisplay.step_definitions;

import com.thomsonreuters.pageobjects.utils.CobaltUser;
import com.thomsonreuters.pageobjects.utils.User;
import java.util.Map;
import org.slf4j.Logger;

public class BaseStepDef {

    protected static final Logger LOG = org.slf4j.LoggerFactory.getLogger(BaseStepDef.class);
    protected static CobaltUser currentUser = CobaltUser.firstUser();
    public static Map<String, User> annotationUsers;

    protected static void resetCurrentUser() {
        currentUser = CobaltUser.firstUser();
    }

}