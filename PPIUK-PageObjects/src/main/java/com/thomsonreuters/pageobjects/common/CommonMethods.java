package com.thomsonreuters.pageobjects.common;

import com.google.common.base.Function;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static junit.framework.Assert.assertTrue;

public class CommonMethods extends AbstractPage {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonMethods.class);

    private RemoteWebDriver driver;

    public CommonMethods() {
        this.driver = getDriver;
    }

    public String getAlertDialogMsg() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void acceptAlertDialogMsg() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void acceptDialogIfAppears() {
        try {
            Alert alert = null;
            alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            LOG.info("No Alert present", e);
        }
    }

    public void dismissDialogIfAppears() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public WebElement findElementByText(List<WebElement> eList, String text) {
        WebElement webElement = null;
        for (WebElement e : eList) {
            if (e.getText().equalsIgnoreCase(text)) {
                webElement = e;
                break;
            }
        }
        return webElement;
    }

    public WebElement findElementByAttribute(List<WebElement> eList, String attribute, String value) {
        WebElement webElement = null;
        for (WebElement e : eList) {
            if (e.getAttribute(attribute).equalsIgnoreCase(value)) {
                webElement = e;
                break;
            }
        }
        return webElement;
    }

    public WebElement waitFluentForElement(final By by) {
        WebElement element = null;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    public void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchOutFromIframe() {
        driver.switchTo().defaultContent();
    }

    public boolean waitForElement(WebElement element, int waitTime) {
        try {
            int i = 0;
            do {
                Thread.sleep(waitTime);
                try {
                    if (element.isDisplayed()) {
                        return true;
                    }
                } catch (Exception e) {
                    LOG.warn("Element not yet found", e);
                }
                i++;
            } while (i < 5);
        } catch (Exception e) {
            LOG.warn("Element not yet found", e);
        }
        return false;
    }

    public WebElement waitForElement(By by, int waitTime) {
        try {
            int i = 0;
            do {
                Thread.sleep(waitTime);
                try {
                    List<WebElement> elements = driver.findElements(by);
                    if (!elements.isEmpty()) {
                        return elements.get(0);
                    }
                } catch (Exception e) {
                    LOG.warn("Element not yet found", e);
                }
                i++;
            } while (i < 5);
        } catch (Exception e) {
            LOG.warn("Element not yet found", e);
        }
        return null;
    }

    public WebElement waitForElementToBeVisible(By by, int waitTime) {
        try {
            int i = 0;
            do {
                Thread.sleep(waitTime);
                try {
                    List<WebElement> elements = driver.findElements(by);
                    if (elements.get(0).isDisplayed()) {
                        return elements.get(0);
                    }
                } catch (Exception e) {
                    LOG.warn("Element not yet visible..!", e.getMessage());
                }
                i++;
            } while (i < 5);
        } catch (Exception e) {
            LOG.warn("Element not yet found", e);
        }
        return null;
    }

    public WebElement getElement(By by) {
        List<WebElement> elements = driver.findElements(by);
        if (!elements.isEmpty()) {
            return elements.get(0);
        }
        return null;
    }

    /**
     * Recreating the action of hovering over a particular HTML element on a
     * page.
     *
     * @param element
     */
    public void mouseOver(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("WebElement is required");
        }
        String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(code, element);
    }

    public void clickLink(String linkText) {
        try {
            driver.findElement(By.linkText(linkText)).click();
        } catch (Exception e) {
            LOG.info("context", e);
        }
    }

    public WebElement getElementByLinkText(String linkText) {
        try {
            return driver.findElement(By.linkText(linkText));
        } catch (Exception e) {
            LOG.info("context", e);
            return null;
        }
    }

    public WebElement waitElementByLinkText(String linkText) {
        return waitForElementToBeVisible(By.linkText(linkText), 2000);
    }

    public void clickElementUsingJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void moveToElementUsingJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void moveToElementUsingLocation(WebElement element) {
        Coordinates elementCoords = ((Locatable) element).getCoordinates();
        elementCoords.inViewPort();
    }

    /**
     * This is generic method to find out the given list of elements is given
     * expected order or not and returns the boolean value accordingly.
     *
     * @param listOfT
     * @param sortOptions
     * @param <T>
     * @return boolean
     */
    public <T extends Comparable> boolean isSorted(List<T> listOfT, SortOptions sortOptions) {
        T previous = null;
        String condition;
        if (SortOptions.DESC.equals(sortOptions)) {
            for (T t : listOfT) {
                if (previous != null && t.compareTo(previous) > 0)
                    return false;
                previous = t;
            }
        } else if (SortOptions.ASC.equals(sortOptions)) {
            for (T t : listOfT) {
                if (previous != null && t.compareTo(previous) < 0)
                    return false;
                previous = t;
            }
        }
        return true;
    }

    public boolean isDateInValidFormat(String s, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            sdf.setLenient(false);
            Date date = sdf.parse(s);
            LOG.info("Given date is in Valid format." + date);
            return true;
        } catch (ParseException e) {
            LOG.info("Given date is not in Valid format." + s);
            return false;
        }
    }

    /**
     * This method is to switch to new window found by given window name.
     *
     * @param newWindowTitle
     * @throws InterruptedException
     */
    public void switchDriverToAnotherWindow(String newWindowTitle) throws InterruptedException {
        Set<String> windowsHandles = driver.getWindowHandles();
        boolean windowFound = false;
        String currentWindowName = driver.getTitle();
        for (int i = 0; i < 20; i++) {
            for (String window : windowsHandles) {
                driver.switchTo().window(window);
                if (!driver.getTitle().equals(currentWindowName)
                        && driver.getTitle().toLowerCase().contains(newWindowTitle.toLowerCase())) {
                    windowFound = true;
                    break;
                }
            }
            if (windowFound) {
                break;
            } else {
                Thread.sleep(200);
            }
        }
        assertTrue(windowFound);
    }

    /**
     * This method is to find and close the given window name and stay back on
     * the current window.
     *
     * @param windowName
     */
    public void findAndCloseWindow(String windowName) {
        String currentHandle = driver.getWindowHandle();
        Set<String> windowsHandles = driver.getWindowHandles();
        boolean windowFound = false;
        String currentWindowName = driver.getTitle();
        for (String window : windowsHandles) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(windowName)) {
                driver.close();
            }
        }
        driver.switchTo().window(currentHandle);
    }

    /**
     * This is a pageobjects method to serve the execution of given regexp against
     * the given text and returns the boolean according to the finding.
     *
     * @param regExp
     * @param fullText
     * @return boolean
     */
    public boolean isRegExpFound(String regExp, String fullText) {
        try {
            Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
            return pattern.matcher(fullText).find();
        } catch (Exception e) {
            LOG.info("context", e);
            return false;
        }
    }

    public boolean isCurrentDocumentFromKnowHow() {
        return driver.getCurrentUrl().contains("KNOWHOW");
    }

//	public boolean isTextPresent(By byElement, String expectedText, int waitTime) {
//		try {
//			int i = 0;
//			do {
//				Thread.sleep(waitTime);
//				try {
//
//					if (driver.findElement(byElement).getText().trim().contains(expectedText)) {
//						return true;
//					}
//				} catch (Exception e) {
//					LOG.warn("Text not yet found", e);
//				}
//				i++;
//			} while (i < 5);
//		} catch (Exception e) {
//			LOG.warn("Text not yet found", e);
//		}
//		return false;
//	}

    public void scrollUpOrDown(int y) {
        ((JavascriptExecutor) driver).executeScript("scroll(0," + y + ");");
    }

    public void scrollRightOrLeft(int x) {
        ((JavascriptExecutor) driver).executeScript("scroll(\"+x+\",0);");
    }

    public boolean isLinkTextPresent(String expectedLinkText, int waitTime) {
        try {
            int i = 0;
            do {
                Thread.sleep(waitTime);
                try {

                    if (driver.findElement(By.linkText(expectedLinkText)) != null) {
                        return true;
                    }
                } catch (Exception e) {
                    LOG.warn("Text not yet found", e);
                }
                i++;
            } while (i < 5);
        } catch (Exception e) {
            LOG.warn("Text not yet found", e);
        }
        return false;
    }

    /**
     * Method to find duplicate words in a Sentence or String
     *
     * @param input String
     * @return set of duplicate words
     */
    public static Set<String> duplicateWords(String input) {
        Set<String> duplicates = new HashSet<>();
        Set<String> set = new HashSet<>();

        if (input == null || input.isEmpty()) {
            return Collections.emptySet();
        }

        String[] words = input.split("\\s+");

        for (String word : words) {
            if (!set.add(word)) {
                duplicates.add(word);
            }
        }
        return duplicates;
    }

    public boolean isImageLoaded(WebElement image) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Object result = jse.executeScript("return arguments[0].complete && " + "typeof arguments[0].naturalWidth != \"undefined\" && "
                + "arguments[0].naturalWidth > 0", image);

        return (Boolean) result;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException ne) {
            return false;
        }
    }

    public String getTableCellByOtherColumnValueAndHeader(WebElement table, String referenceHeader, String referenceCellContains,
                                                          String header) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));
        int referenceHeaderIndex = -1;
        int headerIndex = -1;
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().trim().equals(referenceHeader)) {
                referenceHeaderIndex = i;
            }
            if (headers.get(i).getText().trim().equals(header)) {
                headerIndex = i;
            }
        }
        if (referenceHeaderIndex == -1 || headerIndex == -1) {
            return null;
        }

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.get(referenceHeaderIndex).getText().contains(referenceCellContains)) {
                return cells.get(headerIndex).getText();
            }
        }
        return null;
    }

    public String firstHundredChars(String text) {
        if (text.length() > 100) {
            return text.substring(0, 100) + "...";
        } else {
            return text;
        }
    }

    /**
     * This method is to create the random string with given length of chars
     *
     * @param length
     * @return String
     */
    public String getRandomStringWithGivenLength(final int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Get all numbers from string and return value as integer.
     * RegEx [^\d] is useing
     *
     * @param stringWithNumbers String which contains numbers
     * @return Integer from numbers from string
     */
    public int getIntFromString(String stringWithNumbers) {
        return Integer.parseInt(stringWithNumbers.replaceAll("[^\\d]", ""));
    }

    /**
     * Get list of each WebElement text from the given WebElement list.
     *
     * @param webElements  List of WebElements which text do you need {@link WebElement#getText()}.
     *                     Also, each string will be trimmed.
     * @param splitByRegex Regular expression for splitting string from each WebElement, if necessary.
     *                     Can be omitted by passing null or empty string
     * @return List with trimmed strings from each WebElement of list
     */
    public List<String> getTextsFromWebElements(List<WebElement> webElements, String splitByRegex) {
        List<String> result = new ArrayList<>();
        for (WebElement webElement : webElements) {
            if (splitByRegex != null && !splitByRegex.isEmpty()) {
                String[] splittedString = webElement.getText().trim().split(splitByRegex);
                result.addAll(Arrays.asList(splittedString));
            } else {
                result.add(webElement.getText().trim());
            }
        }
        return result;
    }

    /**
     * Get list of each WebElement text from the given WebElement list.
     *
     * @param webElements List of WebElements which text do you need {@link WebElement#getText()}.
     *                    Also, each string will be trimmed.
     * @return List with trimmed strings from each WebElement of list
     */
    public List<String> getTextsFromWebElements(List<WebElement> webElements) {
        return getTextsFromWebElements(webElements, null);
    }

    /**
     * Is one string contains another joined string
     *
     * @param source              String with source text, where expected text should be
     * @param target              Joined string which should be exists in source text
     * @param targetSplitterRegex RegEx splitter for target joined string. Target sub-strings will be obtained by it splitting
     *                            with this parameter.
     * @return True - if check passed, false - otherwise.
     */
    public boolean isStringContains(String source, String target, String targetSplitterRegex) {
        String[] targets = target.split(targetSplitterRegex);
        for (String str : targets) {
            if (!source.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
