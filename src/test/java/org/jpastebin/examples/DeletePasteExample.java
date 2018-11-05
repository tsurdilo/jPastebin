package org.jpastebin.examples;

import org.jpastebin.exceptions.PasteException;
import org.jpastebin.pastebin.PastebinLink;
import org.jpastebin.pastebin.account.PastebinAccount;
import org.jpastebin.pastebin.exceptions.LoginException;
import org.jpastebin.pastebin.exceptions.ParseException;

/**
 * Example on how to remove your last pasted paste
 * @author Brian B
 */
public class DeletePasteExample {

    public static void main(String[] args) throws LoginException, ParseException, PasteException {
        String[] credentials = {"YOUR USERNAME HERE", "YOUR PASSWORD HERE"};
        String developerKey = "INSERT DEVELOPER KEY HERE";

        PastebinAccount account = new PastebinAccount(developerKey,
                                                      credentials[0],
                                                      credentials[1]);
        // fetches an user session id
        account.login();

        PastebinLink[] pastes = account.getPastes(1); // get only 1 paste (latest)
        if (pastes == null) {
            System.out.println("You don't have any pastes!");
            return;
        }

        PastebinLink lastPaste = pastes[0];
        System.out.println("Deleting: " + lastPaste.getLink());
        lastPaste.delete();
        System.out.println("Done.");
    }
}
