package com.thomsonreuters.askRewrite.step_definitions;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.sql.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
                url = "jdbc:oracle:thin:@//c-10-52-207-222.int.cis.trcloud:1521/xe";
                user = "askplc_test";
                pwd = "asktest";
                break;

            case "DEMO":
                url = "jdbc:oracle:thin:@//c-10-52-207-222.int.cis.trcloud:1521/xe";
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
                System.out.println("***"+ record);
                assertEquals(record,Value);
            }else {
                softly.assertThat(rs.getObject("QUESTION_CATEGORY")).overridingErrorMessage("PLC_REF field is Empty for " + PLCref).isNotNull();
            }
        }
        softly.assertAll();
        conn.close();
    }

}