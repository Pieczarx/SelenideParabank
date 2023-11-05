package parabank.model;

import org.openqa.selenium.By;

import java.util.List;

public class PageElements {
    private String completeBillPayTitle = "Bill Payment Complete";
    private String completeFindLoginInfoMessage = "Your login information was located successfully. You are now logged in.";
    private String completeUpdateContactInfoTitle = "Profile Updated";
    private String registerAccountTitle(String username) {
        return "Welcome " + username;
    }
    public String getRegisterAccountTitle(String username) {
        return registerAccountTitle(username);
    }
    private String loginAccountTitle() {
        return "Accounts Overwiew";
    }
    public String transferFundsTitle() {
        return "Transfer Complete!";
    }
    public String findTransactionsResultTitle() {
        return "Transaction Results";
    }

    public String getLoginConfirmationTitle() {
        return loginAccountTitle();
    }
    public String getAccountOpenedTitle() { return "Account Opened!"; }
    public String getFindLoginInfoMessage() { return completeFindLoginInfoMessage; }
    public String getBillPayTitle() { return completeBillPayTitle; }
    public String getEmptyFieldError(String field) {
        return field + " is required.";
    }
    public String getUpdateProfileInfoTitle() { return completeUpdateContactInfoTitle; }
    public String getSuccesfulRequestLoanMessage() { return "Congratulations, your loan has been approved."; }
}
