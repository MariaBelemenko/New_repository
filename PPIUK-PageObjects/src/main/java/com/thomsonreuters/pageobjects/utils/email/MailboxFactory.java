package com.thomsonreuters.pageobjects.utils.email;

import com.thomsonreuters.pageobjects.common.ExcelFileReader;

public class MailboxFactory {

    public static Mailbox getMailboxByEmail(String email) {
        String[] parts = email.split("@");
        String password = ExcelFileReader.getEmailPassword(email);
        return new Mailbox(parts[0], parts[1], password);
    }

}
