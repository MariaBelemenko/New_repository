package com.thomsonreuters.pageobjects.pages.widgets;

import com.thomsonreuters.pageobjects.utils.document.Document;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;


public class RecentHistoryWidget extends AbstractPage {
	
	private List<Document> documentsOnWidget = new ArrayList<Document>();
	

	Document document;
	
	public List<WebElement> documents() {
		return retryingFindElements(By
				.xpath("//li[@ng-repeat='recentDocument in recentlyViewedDocs']"));
	}
	
	public List<WebElement> documentsTitles() {
		return retryingFindElements(By
				.xpath("//li[@ng-repeat='recentDocument in recentlyViewedDocs']//a"));
	}

	public List<WebElement> documentsStatuses() {
		return retryingFindElements(By
				.xpath("//li[@ng-repeat='recentDocument in recentlyViewedDocs']//span[contains(@class,'metadata_status')]"));
	}
	
	public List<WebElement> documentsResourceTypes() {
		return retryingFindElements(By
				.xpath("//li[@ng-repeat='recentDocument in recentlyViewedDocs']//span[contains(@class,'metadata_resource')]"));
	}
	
	public List<Document> getAllDocumentsFromWidget() {
		List<WebElement> documents = documents();
		List<WebElement> documentsTitles = documentsTitles();
		List<WebElement> documentsStatuses = documentsStatuses();
		List<WebElement> documentsResourceTypes = documentsResourceTypes();
		for(int i = 0; i < documents.size(); i++){
			document = new Document();
			document.setTitle(documentsTitles.get(i).getText().trim());
			document.setStatus(documentsStatuses.get(i).getText().trim());
			document.setResourceType(documentsResourceTypes.get(i).getText().trim());
			documentsOnWidget.add(document);
		}
		return documentsOnWidget;	
	}
	
	public WebElement veiwAllButton(){
		return retryingFindElement(By.linkText("View all"));
	}
	
	public WebElement documentLink(String documentLinkText){
		return retryingFindElement(By.xpath(String.format("//li[@ng-repeat='recentDocument in recentlyViewedDocs']//a[text()='%s']", documentLinkText)));
		
	}
}
