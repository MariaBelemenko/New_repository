package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;



import java.util.List;


public class FavouritesPage extends AbstractPage {

    private PageActions pageActions;

    public void checkCategoryPageIsAbsent(String pageName, String groupName) {
        String text = "'" + pageName + "'";
        if (pageName.contains("'")) {
        	pageName = "\"" + pageName + "\"";
            text = pageName;
        }
        String locator = "//span[text()='" + groupName + "']/ancestor::li//a[contains(@title, " + text + ")]";
        if (groupName.contains("Frequently")) {
            locator = "//*[@id='co_frequentlyUsed_listRoot']//a[contains(@title, " + text + ")]";
        }
		if (groupName.contains("Start")) {
			locator = "//*[@id='co_startPages_listRoot']//a[contains(@title, " + text + ")]";
		}
        try {
            findElement(By.xpath(locator));
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            return;
        }
        throw new RuntimeException("The page '" + pageName + "' is present in '" + groupName + "' group");
    }

	public void checkCategoryPagePresents(String pageName, String groupName) {
		String text = "'" + pageName + "'";
		if (pageName.contains("'")) {
			pageName = "\"" + pageName + "\"";
			text = pageName;
		}
		String locator = "//span[text()='" + groupName + "']/ancestor::li//a[contains(@title, " + text + ")]";
		if (groupName.contains("Frequently")) {
			locator = "//*[@id='co_frequentlyUsed_listRoot']//a[contains(@title, " + text + ")]";
		}
		if (groupName.contains("Start")) {
			locator = "//*[@id='co_startPages_listRoot']//a[contains(@title, " + text + ")]";
		}
		waitForExpectedElement(By.xpath(locator));
	}

    public WebElement openPage(String pageName) {
    	return waitForExpectedElement(By.xpath("//a[contains(@title, '" + pageName + "')]"));
    }

    public WebElement addGroupLink() {
        return waitForExpectedElement(By.id("co_favorites_addGroupLink"));
    }

    public WebElement organize() {
        return waitForExpectedElement(By.id("co_foldering_favorites_editLink"));
    }

    public WebElement doneOrganizing() {
        return waitForExpectedElement(By.id("co_foldering_favorites_doneEditLink"));
    }

    public void checkFavouriteGroupIsAbsent(String groupName) {
        try {
            findElement(By.xpath("(//*[@id='coid_website_favoritesWidget']//span[text()='" + groupName + "'])[1]"));
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            return;
        }
        throw new RuntimeException("The group '" + groupName + "' is present on Favourites page");
    }

    public WebElement favouriteGroup(String name) {
        return waitForExpectedElement(By.xpath("(//*[@id='coid_website_favoritesWidget']//span[text()='" + name + "'])[1]"));
    }
    
    public WebElement renameFavouriteGroupButton(String oldGroupName) {
        return waitForExpectedElement(By.xpath("//span[text()='" + oldGroupName + "']/ancestor::li//*[@class='co_favoriteRen']"));
    }
    
    public WebElement renameFavouriteGroupInput(String oldGroupName) {
        return waitForExpectedElement(By.xpath("//span[text()='" + oldGroupName + "']/ancestor::li//*[@class='cobalt_favorites_rename_textbox']"));
    }

    public WebElement renameFavouriteOKGroupButton(String oldGroupName) {
        return waitForExpectedElement(By.xpath("//span[text()='" + oldGroupName + "']/ancestor::li//*[@class='co_dropdownBox_ok']"));
    }
    
	public WebElement deleteFavouriteGroupButton(String name) {
		return waitForExpectedElement(By.xpath("//span[text()='" + name + "']/ancestor::li//a[@class='co_favoriteDel']"));
	}
    
    public WebElement pageInFavourite(String pageName) {
        return waitForExpectedElement(By.xpath("((//*[@id='coid_website_favoritesWidget']//*[contains(@title,'" + pageName + "')])[1]/ancestor::li)[last()]/label"));
    }
    
    public List<WebElement> pagesInFavouriteFroup() {
        return waitForExpectedElements(By.xpath("//li[contains(@class,'co_foldering_favorite')]//a[@class='co_foldering_frontpage_favorite']"));
    }
    
    public WebElement deletePageFromFavourite(String pageName) {
        return waitForExpectedElement(By.xpath("((//*[contains(@title,'" + pageName + "')])[1]/ancestor::li)[last()]//*[@class='co_favoriteDel']"));
    }

    public List<WebElement> favouriteGroupNames() {
        return waitForExpectedElements(By.xpath("//h3//label[contains(@for,'checkbox-')]//span"));
    }
    public WebElement renameGroupCancelButton(String groupName) {
        return waitForExpectedElement(By.xpath("//a[@class='co_dropdownBox_cancel']/ancestor::h3/label[@for='checkbox-" + groupName + "']"));
    }

	public boolean checkFavouriteGroupIsPresent(String groupName) {
		try {
			for (WebElement favGroup : favouriteGroupNames()) {
				if (favGroup.getText().trim().equalsIgnoreCase(groupName)) {
					return true;
				}
			}
		} catch (TimeoutException exc) {
			LOG.info("context");
			return false;
		}
		return false;
	}

    public WebElement favouriteStrickenThroughGroup(String groupNname) {
        return waitForExpectedElement(By.xpath("//*[@id='coid_website_favoritesWidget']//li[contains(@class,'co_deleted')]//span[text()='"+groupNname+"']"));
    }

    public WebElement favouriteGroupLink(String groupNname, String linkText) {
        return waitForExpectedElement(By.xpath("//span[text()='"+groupNname+"']/../../..//a[@class='co_foldering_frontpage_favorite' and normalize-space('"+linkText+"')]"));
    }

    public WebElement favouriteStrickenThroughGroupLink(String groupNname, String linkText) {
        return waitForExpectedElement(By.xpath("//span[text()='"+groupNname+"']/../../..//li[contains(@class,'co_deleted')]//a[@class='co_foldering_frontpage_favorite' and normalize-space('"+linkText+"')]"));
    }

    public By favouriteByGroup(String name) {
        return By.xpath("//*[@id='coid_website_favoritesWidget']//span[text()='" + name + "']");
    }

    public WebElement favGroupCancelButton(String groupNamne) {
        return waitForExpectedElement(By.xpath("//input[@value='" + groupNamne + "']/..//a[@class='co_dropdownBox_cancel']"));
    }
    
    public WebElement myStartPageLink() {
    	return waitForExpectedElement(By.xpath("//ul[@class='co_favorites_listSub co_start_pages_list']//a[@class='co_foldering_frontpage_favorite']"));
    }
    
    public WebElement myStartPageDeleteLink() {
    	return waitForExpectedElement(By.xpath("//ul[@class='co_favorites_listSub co_start_pages_list']//a[@class='co_favoriteDel']"));
    }
    
    public List<WebElement> frequentlyUsedItemsLinks() {
    	return waitForExpectedElements(By.xpath("//div[@id='co_frequentlyUsed_listRoot']//a[@class='co_foldering_frontpage_favorite']"));
    }

}