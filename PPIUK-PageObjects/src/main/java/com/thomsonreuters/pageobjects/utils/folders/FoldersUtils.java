package com.thomsonreuters.pageobjects.utils.folders;

import com.thomsonreuters.pageobjects.common.DocumentColumn;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.pages.folders.NewGroupPopup;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.ShareFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.ShareFolderRolesPopup;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class FoldersUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FoldersUtils.class);
    private static final String ENTER_BUTTON_CODE = "13";

    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private NewGroupPopup newGroupPopup = new NewGroupPopup();
    private ShareFolderRolesPopup shareFolderRolesPopup = new ShareFolderRolesPopup();
    private ShareFolderPopup shareFolderPopup = new ShareFolderPopup();

    public void openFolder(String folder) {
        researchOrganizerPage.rootFolderLinkLeftFrame().click();
        if (!folder.equals("root")) {
            researchOrganizerPage.folderLinkLeftFrame(folder).click();
        }
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    public boolean doesFolderExist(String folder) {
        boolean folderExists = false;
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.rootFolderLinkLeftFrame().click();
        try {
            researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
            researchOrganizerPage.folderLinkLeftFrame(folder).click();
            folderExists = true;
        } catch (Exception e) {
        }

        return folderExists;
    }

    public void shareFolder(String folderName) {
        openFolder(folderName);
        researchOrganizerPage.shareFolder(folderName).click();
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    public void shareFolderViaEmail(String owner, String folderName, String userNameToShare) {
        String email = ExcelFileReader.getCobaltEmail(userNameToShare);
        shareFolderViaEmailByEmail(owner, folderName, email);
    }

    public void shareFolderViaEmailByEmail(String owner, String folderName, String emailToShare) {
        shareFolder(folderName);
        JavascriptExecutor js = (JavascriptExecutor) shareFolderPopup;
        js.executeScript("$('#coid_contacts_addedContactsInput').click();");
        js.executeScript(
                String.format("$('#coid_contacts_addedContactsInput input').val(\"%s\").trigger($.Event(\"keyup\", { keyCode: %s }));",
                        emailToShare, ENTER_BUTTON_CODE)
        );
        shareFolderPopup.continueButton().click();
        shareFolderPopup.waitForPageToLoad();
        shareFolderPopup.emailToNotify().sendKeys(ExcelFileReader.getCobaltEmail(owner));
        shareFolderPopup.continueButton().click();
        shareFolderPopup.waitForPageToLoad();
        shareFolderRolesPopup.shareButton().click();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    public void createNewGroupToShareFolder(String groupName, String member) {
        newGroupPopup.waitForPageToLoadAndJQueryProcessing();
        newGroupPopup.groupName().sendKeys(groupName);
        newGroupPopup.people(member).click();
        newGroupPopup.saveGroup().click();
    }

    /**
     * Check if rows on the page sorted in according to necessary alghorythm
     * IMPORTANT! Only documents data will be counted. Rows, which contains nested folders, will be ignored.
     *
     * @param column        Column to get data from.
     * @param sortDirection Expected sorting direction {@link SortOptions}
     * @return True - if check was passed, otherwise - false.
     * @see DocumentColumn
     */
    public boolean isDocSortedBy(DocumentColumn column, SortOptions sortDirection) {
        List<String> inputStrings = researchOrganizerPage.getDocumentsDataInColumn(column);
        switch (column) {
            case TITLE:
            case CONTENT:
                return checkStringsSorting(inputStrings, sortDirection);
            case DATE_ADDED:
                return checkDatesSorting(inputStrings, sortDirection);
            default:
                throw new UnsupportedOperationException("There is no sorting check alghorythm for column " + column.getName());
        }
    }

    //////////////////
    // Private methods
    //////////////////

    /**
     * Check if strings in list going in order according to given direction (asc or desc)
     *
     * @param inputStrings  List with strings
     * @param sortDirection Sort direction {@link SortOptions}
     * @return True - if check was passed, otherwise - false.
     */
    private boolean checkStringsSorting(List<String> inputStrings, SortOptions sortDirection) {
        String previousString = inputStrings.get(0);
        for (String currentString : inputStrings) {
            // if words going in alphabet order then comparison method will return int > 0
            if ((currentString.compareTo(previousString) < 0 && sortDirection == SortOptions.ASC) ||
                    (currentString.compareTo(previousString) > 0 && sortDirection == SortOptions.DESC)) {
                return false;
            }
            previousString = currentString;
        }
        return true;
    }

    /**
     * Check if strings with dates represents in list are going in order according to given direction (asc or desc)
     *
     * @param inputStrings  List with strings
     * @param sortDirection Sort direction {@link SortOptions}
     * @return True - if check was passed, otherwise - false.
     */
    private boolean checkDatesSorting(List<String> inputStrings, SortOptions sortDirection) {
        try {
            Date previousDate = CalendarAndDate.convertPublishedDateStringInstanceToDateInstanceFromLUPage(inputStrings.get(0));
            for (String currentString : inputStrings) {
                // if dates going in chronology order then comparison method will return int > 0
                Date currentDate = CalendarAndDate.convertPublishedDateStringInstanceToDateInstanceFromLUPage(currentString);
                if ((currentDate.compareTo(previousDate) < 0 && sortDirection == SortOptions.ASC) ||
                        (currentDate.compareTo(previousDate) > 0 && sortDirection == SortOptions.DESC)) {
                    return false;
                }
                previousDate = currentDate;
            }
        } catch (ParseException e) {
            LOG.warn("Error occurred when trying to parse date", e);
            return false;
        }
        return true;
    }

}
