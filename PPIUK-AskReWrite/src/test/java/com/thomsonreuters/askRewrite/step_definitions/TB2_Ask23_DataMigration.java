package com.thomsonreuters.askRewrite.step_definitions;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import static org.hamcrest.MatcherAssert.assertThat;
import java.sql.*;

import static org.junit.Assert.*;


public class TB2_Ask23_DataMigration extends BaseStepDef {

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = null;
    String user = null;
    String pwd = null;
    Connection conn = null;
    String baselegacyUrl = System.getProperty("base.legacy.url");

    @Given("^a user connects to the Ask Database$")
    public void auserconnectstotheAskDatabase() throws Throwable {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading driver: " + e);
        }
        switch (baselegacyUrl) {

            case "102":
                url = "jdbc:oracle:thin:@//ask-rewrite-dev.emea1.cis.trcloud:1521/xe";
                user = "askplc_test";
                pwd = "asktest";
                break;

            case "DEMO":
                url = "jdbc:oracle:thin:@//ask-rewrite-dev.emea1.cis.trcloud:1521/xe";
                user = "askplc_test";
                pwd = "asktest";
                break;

        }

    }

    @Then("^queries for the PLCreference Then a record should appear$")
    public void queriesforthePLCreferenceThenarecordshouldappear(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select PLC_REF from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("PLC_REF");
                assertEquals(PLCref,record );
            }else {
                softly.assertThat(record = null).overridingErrorMessage("PLC_REF field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }


    @Then("^queries for the PLCreference Then the TEXT field should not be null$")
    public void queriesforthePLCreferenceThentheTEXTfieldshouldnotbenull(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select TEXT from SUBMISSION_DATA where QUESTION_ID like(select ID from QUESTION where PLC_REF='" + PLCref + "')");

            String record=null;
            if (rs.next()) {
                record=rs.getString("TEXT");
            }else {
                softly.assertThat(record = null).overridingErrorMessage("TEXT field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the Email Then the Email field should not be null$")
    public void queriesfortheEmailThentheEmailfieldshouldnotbenull(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select S1.EMAIL from SUBMISSION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select S2.EMAIL from SUBSCRIBER S2 where S2.ID=(select Q1.SUBSCRIBER_ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record1=null;
            String record2=null;
            if (rs1.next()) {
                rs2.next();
                record1 = rs1.getString("EMAIL");
                record2 = rs2.getString("EMAIL");
                if (record1.equals(record2)) {
                    assertEquals(record1,record2);
                } else {
                    softly.assertThat(record1 != record2).overridingErrorMessage("EMAIL fields are not equal for " + PLCref + ". SUBMISSION_DATA Email : "+ record1 + ". SUBSCRIBER Email : " + record2).isEqualTo(record1);
                }
            }else{
                softly.assertThat(record1 != record2).overridingErrorMessage("EMAIL fields are not equal for " + PLCref).isEqualTo(record1);
            }
        }
        softly.assertAll();
        conn.close();
    }


    @Then("^queries for the FirstName Then the FirstName field should not be null$")
    public void queriesfortheFirstNameThentheFirstNamefieldshouldnotbenull(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select S1.FIRST_NAME from SUBMISSION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select S2.FIRST_NAME from SUBSCRIBER S2 where S2.ID=(select Q1.SUBSCRIBER_ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record1=null;
            String record2=null;
            if (rs1.next()) {
                rs2.next();
                record1 = rs1.getString("FIRST_NAME");
                record2 = rs2.getString("FIRST_NAME");
                if (record1.equals(record2)) {
                    assertEquals(record1,record2);
                } else {
                    softly.assertThat(record1 != record2).overridingErrorMessage("FIRST_NAME fields are not equal for " + PLCref + ". SUBMISSION_DATA FIRST_NAME : "+ record1 + ". SUBSCRIBER FIRST_NAME : " + record2).isEqualTo(record1);
                }
            }else{
                softly.assertThat(record1 != record2).overridingErrorMessage("FIRST_NAME fields are not equal for " + PLCref).isEqualTo(record1);
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the LastName Then the LastName field should not be null$")
    public void queriesfortheLastNameThentheLastNamefieldshouldnotbenull(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select S1.LAST_NAME from SUBMISSION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select S2.LAST_NAME from SUBSCRIBER S2 where S2.ID=(select Q1.SUBSCRIBER_ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record1=null;
            String record2=null;
            if (rs1.next()) {
                rs2.next();
                record1 = rs1.getString("LAST_NAME");
                record2 = rs2.getString("LAST_NAME");
                if (record1.equals(record2)) {
                    assertEquals(record1,record2);
                } else {
                    softly.assertThat(record1 != record2).overridingErrorMessage("LAST_NAME fields are not equal for " + PLCref + ". SUBMISSION_DATA FIRST_NAME : "+ record1 + ". SUBSCRIBER FIRST_NAME : " + record2).isEqualTo(record1);
                }
            }else{
                softly.assertThat(record1 = null).overridingErrorMessage("LAST_NAME fields are not equal for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the QuestionCategory Then the QuestionCategory field should match the Value$")
    public void queriesfortheQuestionCategoryThentheQuestionCategoryfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select QUESTION_CATEGORY from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("QUESTION_CATEGORY");
                if(record==null){
                    record="";
                }
                    assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("QUESTION_CATEGORY")).overridingErrorMessage("QUESTION_CATEGORY field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the QuestionSource Then the QuestionSource field should match the Value$")
    public void queriesfortheQuestionSourceThentheQuestionSourcefieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select QUESTION_SOURCE from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("QUESTION_SOURCE");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("QUESTION_SOURCE")).overridingErrorMessage("QUESTION_SOURCE field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the Position Then the Position field should not be null$")
    public void queriesforthePositionThenthePositionfieldshouldnotbenull(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select S1.POSITION from SUBMISSION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select S2.POSITION from SUBSCRIBER S2 where S2.ID=(select Q1.SUBSCRIBER_ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record1=null;
            String record2=null;
            if (rs1.next()) {
                rs2.next();
                record1 = rs1.getString("POSITION");
                record2 = rs2.getString("POSITION");
                if (record1.equals(record2)) {
                    assertEquals(record1,record2);
                } else {
                    softly.assertThat(record1 != record2).overridingErrorMessage("POSITION fields are not equal for " + PLCref + ". POSITION1 : "+ record1 + ". POSITION2  : " + record2).isEqualTo(record1);
                }
            }else{
                softly.assertThat(record1 != record2).overridingErrorMessage("POSITION fields are not equal for " + PLCref).isEqualTo(record1);
            }
        }
        softly.assertAll();
        conn.close();
    }


    @Then("^queries for the EditorUsername Then the EditorUsername field should match the Value$")
    public void queriesfortheEditorUsernameThentheEditorUsernameshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select USER_NAME from EDITOR where ID=(select ASSIGNED_TO from QUESTION where PLC_REF='" + PLCref + "')");
            String record=null;
            if (rs.next()) {
                record=rs.getString("USER_NAME");
                assertEquals(record, Value);
            }else{
                assertEquals("", Value);
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the AskName and FormName Then the fields should match the Value$")
    public void queriesfortheAskNameThentheAskNamefieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from PRACTICE_AREA where ID=(select QUESTION.PRACTICE_AREA_ID from QUESTION where PLC_REF='" + PLCref + "')");
            String record1=null;
            String record2=null;
            if (rs.next()) {
                record1=rs.getString("ASK_NAME");
                assertEquals(record1, Value);
                record2=rs.getString("FORM_NAME");
                assertEquals(record2, Value);
            }else {
                softly.assertThat(rs.getObject("ASK_NAME")).overridingErrorMessage("ASK_NAME field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the OrganisationName Then the OrganisationName should match the Value$")
    public void queriesfortheOrganisationNameThentheOrganisationNamefieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select S2.ORGANISATION_NAME from SUBSCRIBER S2 where S2.ID=(select Q1.SUBSCRIBER_ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record=null;
            if (rs.next()) {
                record=rs.getString("ORGANISATION_NAME");
                if(record==null){
                    record="";
                }
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("ORGANISATION_NAME")).overridingErrorMessage("ORGANISATION_TYPE field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the OrganisationType Then the OrganisationType should match the Value$")
    public void queriesfortheOrganisationTypeThentheOrganisationTypefieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select S1.ORGANISATION_TYPE from SUBMISSION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record=null;
            if (rs.next()) {
                record=rs.getString("ORGANISATION_TYPE");
                if(record==null){
                    record="";
                }
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("ORGANISATION_TYPE")).overridingErrorMessage("ORGANISATION_TYPE field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }


    @Then("^queries for the Status Then the Status field should match the Value$")
    public void queriesfortheStatusThentheStatusfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select STATUS from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("STATUS");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("STATUS")).overridingErrorMessage("STATUS field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the FinalDateofResponse Then the FinalDateofResponse should match the Value$")
         public void queriesfortheFinalDateofResponseThentheFinalDateofResponsefieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select FINAL_DATE_OF_RESPONSE from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("FINAL_DATE_OF_RESPONSE");
                if(record==null){
                    record="";
                }
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("FINAL_DATE_OF_RESPONSE")).overridingErrorMessage("FINAL_DATE_OF_RESPONSE field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the Contentsearch Then the Contentsearch should match the Value$")
    public void queriesfortheContentsearchThentheContentsearchfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select CONTENT_SEARCH from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("CONTENT_SEARCH");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("CONTENT_SEARCH")).overridingErrorMessage("CONTENT_SEARCH field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }


    @Then("^queries for the DateCreatedOn Then the DateCreatedOn should match the Value$")
    public void queriesfortheDateCreatedOnThentheFinalDateCreatedOnfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select DATE_CREATED_ON_ASK from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("DATE_CREATED_ON_ASK");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("DATE_CREATED_ON_ASK")).overridingErrorMessage("DATE_CREATED_ON_ASK field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the LastModifiedOn Then the LastModifiedOn should match the Value$")
    public void queriesfortheLastModifiedOnThentheFinalLastModifiedOnfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select LAST_MODIFIED_ON from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("LAST_MODIFIED_ON");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("LAST_MODIFIED_ON")).overridingErrorMessage("LAST_MODIFIED_ON field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the Title Then the Title should match the Value$")
    public void queriesfortheTitleThentheTitlefieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select TITLE from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("TITLE");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("TITLE")).overridingErrorMessage("TITLE field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the SubscriberRef Then the SubscriberRef should match the Value$")
    public void queriesfortheSubscriberRefThentheSubscriberReffieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select S2.SUBSCRIBER_REF from SUBSCRIBER S2 where S2.ID=(select Q1.SUBSCRIBER_ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record=null;
            if (rs.next()) {
                record=rs.getString("SUBSCRIBER_REF");
                if(record==null){
                    record="";
                }
                assertEquals(record, Value);
            }//else {
               // softly.assertThat(rs.getObject("SUBSCRIBER_REF")).overridingErrorMessage("SUBSCRIBER_REF field is Empty for " + PLCref).isNotNull();
           // }
        }
        //softly.assertAll();
        conn.close();
    }

    @Then("^queries for the PromotedFrom Then the PromotedFrom should match the Value$")
    public void queriesforthePromotedFromThenthePromotedFromfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select PROMOTED_FROM from QUESTION where PLC_REF='" + PLCref + "'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("PROMOTED_FROM");
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("PROMOTED_FROM")).overridingErrorMessage("PROMOTED_FROM field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the ReasonforPublishing Then the ReasonforPublishing should match the Value$")
    public void queriesfortheReasonforPublishingThentheReasonforPublishingfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select S1.REASON_FOR_NOT_PUBLISHING from PUBLICATION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record=null;
            if (rs.next()) {
                record=rs.getString("REASON_FOR_NOT_PUBLISHING");
                if(record==null){
                    record="";
                }
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("REASON_FOR_NOT_PUBLISHING")).overridingErrorMessage("REASON_FOR_NOT_PUBLISHING field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the Text Then the Text should match the Value$")
    public void queriesfortheTextThentheTextfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value = PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            int counter=0;
            ResultSet rs = stmt.executeQuery("select count(*) from NOTE S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            rs.next();
            counter=rs.getInt(1);

            rs = stmt.executeQuery("select S1.TEXT from NOTE S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record = null;
            String[] EachValue = Value.split(":");

            for (int i = 0; i < counter; i++) {
                if(rs.next()) {
                    record = rs.getString("TEXT");
                    if (record == null) {
                        record = "";
                    }
                    assertThat("Actual Value for PL ref:" +PLCref +" is :" + record + "Expected Value is :" + EachValue[i], record.contains(EachValue[i]));
                }
            }
        }
        conn.close();
    }

    @Then("^queries for the DateAdded Then the DateAdded should match the Value$")
    public void queriesfortheDateAddedThentheDateAddedfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value = PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            int counter=0;
            ResultSet rs = stmt.executeQuery("select count(*) from NOTE S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            rs.next();
            counter=rs.getInt(1);

            rs = stmt.executeQuery("select S1.DATE_ADDED from NOTE S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record = null;
            String[] EachValue = Value.split(";");

            for (int i = 0; i < counter; i++) {
                if(rs.next()) {
                    record = rs.getString("DATE_ADDED");
                    if (record == null) {
                        record = "";
                    }
                    assertThat("Actual Value for PL ref:" +PLCref +" is :" + record + "Expected Value is :" + EachValue[i], record.contains(EachValue[i]));
                }
            }
        }
        conn.close();
    }

    @Then("^queries for the FollowupText Then the FollowupText should match the Value$")
    public void queriesfortheFollowupTextThentheFollowupTextfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value = PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();

            int counter=0;
            ResultSet rs = stmt.executeQuery("select count(*) from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            rs.next();
            counter=rs.getInt(1);

            rs = stmt.executeQuery("select TEXT from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record = null;
            String[] EachValue = Value.split(";");

            for (int i = 0; i < counter; i++) {
                if(rs.next()) {
                    record = rs.getString("TEXT");
                    if (record == null) {
                        record = "";
                    }
                    assertThat("Actual Value for PL ref:" +PLCref +" is :" + record + ".Expected Value is :" + EachValue[i], record.contains(EachValue[i]));
                }
            }
        }
        conn.close();
    }

    @Then("^queries for the Direction Then the Direction should match the Value$")
    public void queriesfortheDirectionThentheDirectionfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value = PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();

            int counter=0;
            ResultSet rs = stmt.executeQuery("select count(*) from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            rs.next();
            counter=rs.getInt(1);


            rs = stmt.executeQuery("select S1.DIRECTION from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record = null;
            String[] EachValue = Value.split(";");

            for (int i = 0; i < counter; i++) {
                if(rs.next()) {
                    record = rs.getString("DIRECTION");
                    if (record == null) {
                        record = "";
                    }
                    assertThat("Actual Value for PL ref:" +PLCref +" is :" + record + "Expected Value is :" + EachValue[i], record.contains(EachValue[i]));
                }
            }
        }
        conn.close();
    }
    @Then("^queries for the FollowupStatus Then the FollowupStatus should match the Value$")
    public void queriesfortheFollowupStatusThentheFollowupStatusfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value = PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();

            int counter=0;
            ResultSet rs = stmt.executeQuery("select Count(*) from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            rs.next();
            counter=rs.getInt(1);

            rs = stmt.executeQuery("select S1.STATUS from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "')");
            String record = null;
            String[] EachValue = Value.split(";");

            for (int i = 0; i < counter; i++) {
                 if(rs.next()) {
                    record = rs.getString("STATUS");
                    if (record == null) {
                        record = "";
                    }
                     assertThat("Actual Value for PL ref:" +PLCref +" is :" + record + "Expected Value is :" + EachValue[i], record.contains(EachValue[i]));

                }
            }
        }
        conn.close();
    }

    @Then("^queries for the FollowupDateReeived Then the FollowupDateReeived should match the Value$")
    public void queriesfortheFollowupDateReeivedThentheFollowupDateReeivedfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select S1.DATE_RECEIVED from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "') and S1.DIRECTION='Inbound'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("DATE_RECEIVED");
                if (record == null) {
                    record = "";
                }
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("DATE_RECEIVED")).overridingErrorMessage("DATE_RECEIVED field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries for the FollowupDateSent Then the FollowupDateSent should match the Value$")
    public void queriesfortheFollowupDateSentThentheFollowupDateSentfieldshouldmatchthealuel(DataTable PLCreference) throws Throwable {

        conn = DriverManager.getConnection(url, user, pwd);
        SoftAssertions softly = new SoftAssertions();
        for (int dataRow = 0; dataRow < PLCreference.asMaps(String.class, String.class).size(); dataRow++) {
            String PLCref = PLCreference.asMaps(String.class, String.class).get(dataRow).get("PLCreference");
            String Value=PLCreference.asMaps(String.class, String.class).get(dataRow).get("Value");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select S1.DATE_SENT from FOLLOWUP S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='" + PLCref + "') and S1.DIRECTION='Outbound'");
            String record=null;
            if (rs.next()) {
                record=rs.getString("DATE_SENT");
                if (record == null) {
                    record = "";
                }
                assertEquals(record, Value);
            }else {
                softly.assertThat(rs.getObject("DATE_SENT")).overridingErrorMessage("DATE_SENT field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

    @Then("^queries the data rules from different tables they should be as expected$")
    public void queriesthedatarulesfromdifferenttablestheyshouldbeasexpected() throws Throwable {

        SoftAssertions softly = new SoftAssertions();
        conn = DriverManager.getConnection(url, user, pwd);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) from NOTE where QUESTION_ID is null or QUESTION_ID=0");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).overridingErrorMessage("Rule: There aren’t  any NOTE records that aren’t associated with QUESTION records FAILS. Expected : 0, Actual : " + rs.getInt(1)).isEqualByComparingTo(0);
        rs = stmt.executeQuery("select count(*) from SUBMISSION_DATA where QUESTION_ID is null or QUESTION_ID=0");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).isEqualByComparingTo(0).overridingErrorMessage("Rule: There aren’t  any SUBMISSION_DATA records that aren’t associated with QUESTION records FAILS. Expected : 0, Actual : " +rs.getInt(1));
        rs = stmt.executeQuery("select count(*) from PUBLICATION_DATA where QUESTION_ID is null or QUESTION_ID=0");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).isEqualByComparingTo(0).overridingErrorMessage("Rule: There aren’t  any PUBLICATION_DATA records that aren’t associated with QUESTION records FAILS. Expected : 0, Actual : " +rs.getInt(1));
        rs = stmt.executeQuery("select count(*) from FOLLOWUP where QUESTION_ID is null or QUESTION_ID=0");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).isEqualByComparingTo(0).overridingErrorMessage("Rule: There aren’t  any FOLLOWUP records that aren’t associated with QUESTION records FAILS. Expected : 0, Actual : " +rs.getInt(1));
        rs = stmt.executeQuery("select count(*) from PUBLICATION_EVENT where QUESTION_ID is null or QUESTION_ID=0");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).isEqualByComparingTo(0).overridingErrorMessage("Rule: There aren’t  any PUBLICATION_EVENT records that aren’t associated with QUESTION records FAILS. Expected : 0, Actual : " + rs.getInt(1));
        rs = stmt.executeQuery("select count(*)from subscriber where id not in (select distinct(subscriber_id) from question where subscriber_id is not null and subscriber_id != 0)");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).isEqualByComparingTo(0).overridingErrorMessage("Rule: All Subscriber records should be associated with at least one Question record FAILS. Expected : 0, Actual : " + rs.getInt(1));
        rs = stmt.executeQuery("select count(*)from question where id not in (select sd.question_id from question q, submission_data sd where sd.question_id = q.id)");
        rs.next();
        //assertEquals(0, rs.getInt(1));
        softly.assertThat(rs.getInt(1)).overridingErrorMessage("Rule: All Questions have one submission_data record,there should be none that do not exist as question_id in the subscriber_data table FAILS. Expected : 0, Actual : " +rs.getInt(1)).isEqualByComparingTo(0);
        softly.assertAll();
        conn.close();
    }
}