package com.thomsonreuters.pageobjects.common;

import com.thomsonreuters.driver.exception.PageOperationException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class ExcelFileReader {

    private final static Logger LOG = LoggerFactory.getLogger(ExcelFileReader.class);
    private static final String IOEXCEPTION = "IOException while getting value from excel ";
    private final static String COBALT_USERS_XLSX = System.getProperty("cobalt.users.xls.path");
    private static final int USERS_EMAIL_COLUMN_NUMBER = 6;
    private static final int USERS_PASSWORD_COLUMN_NUMBER = 1;
    private static final int EMAILS_PASSWORD_COLUMN_NUMBER = 1;

    private static final String USERS_SHEET_NAME = "Users";
    private static final String EMAILS_SHEET_NAME = "Emails";

    private static RandomAccessFile raf = null;

    private static FileLock acquireLock() throws IOException, InterruptedException {
        FileLock fileLock;
        int counter = 0;
        raf = new RandomAccessFile(COBALT_USERS_XLSX, "rw");
        FileChannel fileChannel = raf.getChannel();
        do {
            fileLock = fileChannel.tryLock();
            counter++;
            Thread.sleep(1000);
        }
        while (null != fileLock && counter > 10);
        return fileLock;
    }

    private static void releaseLock(FileLock fileLock) throws IOException {
        if (null != fileLock) {
            fileLock.release();
        }
    }

    public static String getCobaltEmail(String username) {
        return getDataFromCobaltUSers(USERS_SHEET_NAME, username, USERS_EMAIL_COLUMN_NUMBER);
    }

    public static String getCobaltPassword(String username) {
        return getDataFromCobaltUSers(USERS_SHEET_NAME, username, USERS_PASSWORD_COLUMN_NUMBER);
    }

    public static String getEmailPassword(String email) {
        return getDataFromCobaltUSers(EMAILS_SHEET_NAME, email, EMAILS_PASSWORD_COLUMN_NUMBER);
    }

    private static String getDataFromCobaltUSers(String sheetName, String firstColumnValue, int columnNumber) {
        String dataFromCell = null;
        try {
            FileInputStream file = new FileInputStream(COBALT_USERS_XLSX);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowsCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowsCount; i++) {
                Row row = sheet.getRow(i);
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(firstColumnValue)) {
                    dataFromCell = row.getCell(columnNumber).toString();
                    return dataFromCell;
                }
            }
        } catch (IOException e) {
            LOG.error(IOEXCEPTION, e);
        }
        return dataFromCell;
    }

    public static String getDefaultUser() /*throws IOException, InterruptedException*/ {
        return "topsecret1234";
        /*try {
            FileInputStream file = new FileInputStream(COBALT_USERS_XLSX);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowsCount; i++) {
                Row row = sheet.getRow(i);
                if (row.getCell(3).getStringCellValue().equalsIgnoreCase("DEFAULT_USER") && !row.getCell(5).getStringCellValue().equalsIgnoreCase("Y")) {
                    row.getCell(5).setCellValue("Y");
                    String username = row.getCell(0).toString();
                    file.close();

                    FileOutputStream outFile = new FileOutputStream(COBALT_USERS_XLSX);
                    workbook.write(outFile);
                    outFile.close();

                    return username;
                }
            }
        } catch (IOException e) {
            throw new IOException("Unable to find Default user \n" + e.getMessage());
        }
        throw new IOException("Unable to find Default user");*/
    }

    public static void unlockUser(String username) /*throws IOException, InterruptedException*/ {
        LOG.debug("Unlock user code commented out");
       /* if (null != username) {
            try {
                FileInputStream file = new FileInputStream(COBALT_USERS_XLSX);
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);
                int rowsCount = sheet.getLastRowNum();
                for (int i = 0; i <= rowsCount; i++) {
                    Row row = sheet.getRow(i);
                    if (row.getCell(0).getStringCellValue().equalsIgnoreCase(username)) {
                        row.getCell(5).setCellValue("N");
                        file.close();

                        FileOutputStream outFile = new FileOutputStream(COBALT_USERS_XLSX);
                        workbook.write(outFile);
                        outFile.close();
                    }
                }
            } catch (IOException e) {
                throw new IOException("Unable to unlock Default user " + username + "\n " + e.getMessage());
            }
        } else {
            LOG.info("UserName is null. No need to update the ExcelSheet");
        }*/
    }

    public void setBrowserCounts() {
        for (int i = 0; i < 5; i++) {
            try {
                setBrowserCount();
            } catch (Exception e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void reduceBrowserCounts() {
        for (int i = 0; i < 5; i++) {
            try {
                removeBrowserCount();
            } catch (Exception e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void getBrowserCounts() {
        for (int i = 0; i < 5; i++) {
            try {
                getBrowserCount();
            } catch (Exception e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private synchronized int getBrowserCount() {
        try {
            FileInputStream file = new FileInputStream(COBALT_USERS_XLSX);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(2);
            return sheet.getLastRowNum();
        } catch (IOException e) {
            return 0;
        }
    }

    private synchronized void removeBrowserCount() {
        try {
            FileInputStream file = new FileInputStream(COBALT_USERS_XLSX);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(2);
            int rowsCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowsCount; i++) {
                Row row = sheet.getRow(rowsCount + 1);
                row.getCell(0).setCellValue("");

                FileOutputStream outFile = new FileOutputStream(COBALT_USERS_XLSX);
                workbook.write(outFile);
                outFile.close();

            }
        } catch (IOException e) {
            throw new PageOperationException("Unable to write to excel file \n" + e.getMessage());
        }
    }

    private synchronized void setBrowserCount() throws FileNotFoundException {
        try {
            FileInputStream file = new FileInputStream(COBALT_USERS_XLSX);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(2);
            int rowsCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowsCount; i++) {
                Row row = sheet.getRow(rowsCount + 1);
                row.getCell(0).setCellValue("Y");

                FileOutputStream outFile = new FileOutputStream(COBALT_USERS_XLSX);
                workbook.write(outFile);
                outFile.close();

            }
        } catch (IOException e) {
            throw new PageOperationException("Unable to write to excel file \n" + e.getMessage());
        }
    }

}