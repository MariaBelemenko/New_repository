//package com.thomsonreuters.askRewrite.step_definitions.usmanTesting;
//
//import com.thomsonreuters.askRewrite.step_definitions.BaseStepDef;
//import com.thomsonreuters.askRewrite.utils.AskReWriteUsers.AskReWriteUser;
//import com.thomsonreuters.askRewrite.utils.ExcelFileReader;
//import com.thomsonreuters.askRewrite.utils.Product;
//import com.thomsonreuters.askRewrite.utils.Routing;
//import cucumber.api.Transpose;
//import cucumber.api.java.en.Given;
//import org.openqa.selenium.TimeoutException;
//import org.springframework.util.StringUtils;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//public class UsmanJavaSteps extends BaseStepDef {
//
//    public static final String ROUTING = "routing";
//
//    @Given("^PL\\+ user is logged in$")
//    public void plUserIsLoggedIn() throws Throwable {
//        AskReWriteUser plPlusUser = new AskReWriteUser();
//        plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : currentUser.getUserName());
//
//        if ("false".equalsIgnoreCase(System.getProperty(ROUTING))) {
//            plPlusUser.setRouting(Routing.NONE);
//        } else {
//            plPlusUser.setRouting(Routing.DEFAULT);
//        }
//        plUserIsLoggedInWithFollowingDetails(Collections.singletonList(plPlusUser));
//    }
//
//    @Given("^PL\\+ user is logged in with following details$")
//    public void plUserIsLoggedInWithFollowingDetails(@Transpose List<AskReWriteUser> plPlusUserList) throws Throwable {
//        AskReWriteUser plPlusUser = AskReWriteUser.updateMissingFields(plPlusUserList.get(0));
//        if (StringUtils.isEmpty(plPlusUser.getUserName())) {
//            plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : ExcelFileReader.getDefaultUser());
//        }
//        String mandatoryRouting = plPlusUser.getMandatoryRouting();
//        if ("false".equalsIgnoreCase(System.getProperty(ROUTING)) && (StringUtils.isEmpty(mandatoryRouting) || mandatoryRouting.equals("NO"))) {
//            plPlusUser.setRouting(Routing.NONE);
//        }
//        loginUser(AskReWriteUser.updateMissingFields(plPlusUserList.get(0)));
//    }
//
//    private void loginUser(AskReWriteUser plPlusUser) throws InterruptedException, IOException {
//        if (currentUser != null && plPlusUser.equalTo(currentUser)) {
//            navigateToHomePage(plPlusUser.getProduct());
//        } else {
//            if (!isUserFirstUser(currentUser)) {
//                newSession(currentUser);
//                if (plPlusUser.getProduct().equals(Product.PLC_lEGACY)) {
//                    loginLegacySite(plPlusUser);
//                }
//            }
//            doRouting(plPlusUser);
//
//            if (plPlusUser.getProduct().equals(Product.PLC_lEGACY) && isUserFirstUser(currentUser)) {
//                loginLegacySite(plPlusUser);
//            }
//
//            if (null == plPlusUser.getUserName()) {
//                plPlusUser.setUserName(ExcelFileReader.getDefaultUser());
//            }
//
//            if (plPlusUser.getLoginRequired().equals("YES")) {
//                login(plPlusUser);
//            }
//
//            if (plPlusUser.getProduct().equals(Product.WLN)) {
//                try {
//                    clientId(plPlusUser.getClientId());
//                } catch (TimeoutException e) {
//                    LOG.info("Failed to find client id");
//                }
//                closeWelcomeDialog();
//            }
//        }
//        currentUser = plPlusUser;
//        setAnnotationUsers();
//    }
//
//    private void navigateToHomePage(Product product) {
//        switch (product) {
//            case WLN:
//                navigationCobalt.navigateToWestlawNext();
//                break;
//            case PLC:
//                navigationCobalt.navigateToPLUKPlus();
//                break;
//            case ANZ:
//                navigationCobalt.navigateToPLANZPlus();
//                break;
//            case PLC_lEGACY:
//                navigationCobalt.navigateToPLCLegacy();
//                break;
//            default:
//                break;
//        }
//    }
//
//}
