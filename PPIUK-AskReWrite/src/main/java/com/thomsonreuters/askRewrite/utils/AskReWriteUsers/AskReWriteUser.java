//package com.thomsonreuters.askRewrite.utils.AskReWriteUsers;
//
//import com.thomsonreuters.askRewrite.utils.ExcelFileReader;
//import com.thomsonreuters.askRewrite.utils.Product;
//import com.thomsonreuters.askRewrite.utils.Routing;
//import org.slf4j.Logger;
//
//public class AskReWriteUser {
//
//    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(AskReWriteUser.class);
//
//    private Product product;
//    private String userName;
//    private String role;
//    private Routing routing;
//    private String clientId;
//    private boolean newSession;
//    private String loginRequired;
//    private String mandatoryRouting;
//    private String email;
//
//    public AskReWriteUser() {
//        this.product = Product.PLC;
//        this.role = "DEFAULT_USER";
//        this.userName = null;
//        this.routing = Routing.DEFAULT;
//        this.clientId = "TEST01";
//    }
//
//    public static AskReWriteUser firstUser() {
//        AskReWriteUser askReWriteUser = new AskReWriteUser();
//        askReWriteUser.setRole(null);
//        askReWriteUser.setProduct(null);
//        askReWriteUser.setUserName(null);
//        askReWriteUser.setRouting(null);
//        askReWriteUser.setClientId(null);
//        askReWriteUser.setEmail(null);
//        return askReWriteUser;
//    }
//
//    public static AskReWriteUser updateMissingFields(AskReWriteUser scenarioUser) {
//        if (null == scenarioUser.getProduct()) {
//            scenarioUser.setProduct(Product.PLC);
//        }
//        if (null == scenarioUser.getEmail()) {
//            scenarioUser.setEmail("" != ExcelFileReader.getAskReWriteEmail(scenarioUser.getUserName())
//                    ? ExcelFileReader.getAskReWriteEmail(scenarioUser.getUserName()) : "test_user@mailinator");
//        }
//        if(null == scenarioUser.role){
//            scenarioUser.setRole("DEFAULT_USER");
//        }
//        if (null == scenarioUser.getRouting()) {
//            scenarioUser.setRouting(Routing.DEFAULT);
//        }
//        if (null == scenarioUser.getClientId()) {
//            scenarioUser.setClientId("TEST01");
//        }
//        if (null == scenarioUser.getLoginRequired()) {
//            scenarioUser.setLoginRequired("YES");
//        }
//        if(null == scenarioUser.getMandatoryRouting()){
//            scenarioUser.setMandatoryRouting("NO");
//        }
//        return scenarioUser;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(final Product product) {
//        this.product = product;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(final String userName) {
//        this.userName = userName;
//    }
//
//    public Routing getRouting() {
//        return routing;
//    }
//
//    public void setRouting(final Routing routing) {
//        this.routing = routing;
//    }
//
//    public String getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(final String clientId) {
//        this.clientId = clientId;
//    }
//
//    public boolean isNewSession() {
//        return newSession;
//    }
//
//    public void setNewSession(final boolean newSession) {
//        this.newSession = newSession;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(final String role) {
//        this.role = role;
//    }
//
//    public static boolean isUserFirstUser(AskReWriteUser that) {
//        return null == that.getUserName() && null == that.getProduct() && null == that.getClientId() && that.role == null;
//    }
//
//    public String getLoginRequired() {
//        return loginRequired;
//    }
//
//    public void setLoginRequired(String loginRequired) {
//        this.loginRequired = loginRequired;
//    }
//
//    public String getMandatoryRouting() {
//        return mandatoryRouting;
//    }
//
//    public void setMandatoryRouting(String mandatoryRouting) {
//        this.mandatoryRouting = mandatoryRouting;
//    }
//
//    public boolean equalTo(AskReWriteUser that) {
//        LOG.info("Current Scenario User = " + this.toString());
//        LOG.info("Previous Scenario User = " + that.toString());
//        if (isUserFirstUser(that)) {
//            LOG.info("User is First Time User");
//            return false;
//        }
//        if(!this.role.equalsIgnoreCase(that.getRole())){
//            LOG.info("Users Roles don't match");
//            return false;
//        } else {
//            if(null == this.getUserName()) {
//                this.setUserName(that.getUserName());
//            }
//        }
//        if (!this.getUserName().equalsIgnoreCase(that.getUserName())) {
//            LOG.info("Users don't match");
//            return false;
//        }
//        if (this.getProduct() != that.getProduct()) {
//            LOG.info("Users Products don't match");
//            return false;
//        }
//        if (this.routing != that.routing) {
//            LOG.info("Users routing don't match");
//            return false;
//        }
//        if (!this.getClientId().equalsIgnoreCase(that.getClientId())) {
//            LOG.info("Users ClientId don't match");
//            return false;
//        }
//        return !that.isNewSession();
//    }
//
//    public String toString() {
//        StringBuilder user = new StringBuilder();
//        String NEW_LINE = System.getProperty("line.separator");
//        user.append("{" + NEW_LINE)
//                .append("product: " + product + NEW_LINE)
//                .append("userName: " + userName + NEW_LINE)
//                .append("role: " + role + NEW_LINE)
//                .append("routing: " + routing + NEW_LINE)
//                .append("clientId: " + clientId + NEW_LINE)
//                .append("email: " + email + NEW_LINE)
//                .append("newSession: " + newSession + NEW_LINE)
//                .append("loginRequired: " + loginRequired + NEW_LINE)
//                .append("mandatoryRouting" + mandatoryRouting + NEW_LINE)
//                .append("}");
//        return user.toString();
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//}
