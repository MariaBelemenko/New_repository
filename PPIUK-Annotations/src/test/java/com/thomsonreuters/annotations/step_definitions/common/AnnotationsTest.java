package com.thomsonreuters.annotations.step_definitions.common;

import com.thomsonreuters.annotations.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.annotations.FormatType;
import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import com.thomsonreuters.pageobjects.utils.User;
import org.springframework.util.StringUtils;

/**
 * Created by uc186961 on 01/03/2016.
 */
public class AnnotationsTest extends BaseStepDef {


    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();

    protected String getUserFullName(String contact) {
        User user = annotationUsers.get(contact);
        if (StringUtils.isEmpty(user)) {
            throw new PageOperationException("Usernames are not matching between usernameAndPassword properties and plPlusUser username value.");
        }
        return user.getFullName();
    }

    protected String getUserNameStartswithLastName(String contact) {
        User user = annotationUsers.get(contact);
        if (StringUtils.isEmpty(user)) {
            throw new PageOperationException("Usernames are not matching between usernameAndPassword properties and plPlusUser username value.");
        }
        return user.getLastName() + ", " + user.getFirstName();
    }



    protected FormatType getFormatType(String style) {
        return FormatType.valueOf(style.toUpperCase().trim());
    }

}
