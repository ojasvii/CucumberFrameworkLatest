package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_User_PO extends Base_PO{

    public Register_User_PO(){
        super();
    }

    private @FindBy(xpath = "text")
    WebElement username_TextField;



}
