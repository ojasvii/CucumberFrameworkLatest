@register
Feature: User Signup and Account Deletion on Automation Exercise


#When User enters following user details
#| naveen | automation | nav@gmail.com | 99999 | Bangalore |
#| tom | peter | tom@gmail.com | 99999 | London |
#| lisa | dsouza | lisa@gmail.com | 8887777 | SFO |
#Then user registration should be successful



#When User enters following user details with columns
#| firstname | lastname | email | phone | city |
#| naveen | automation | nav@gmail.com | 99999 | Bangalore |
#| tom | peter | tom@gmail.com | 99999 | London |
#| lisa | dsouza | lisa@gmail.com | 8887777 | SFO |

  Scenario: Successful register the user
    Given the user launches the browser
    When the user navigates to the url "http://automationexercise.com"
    Then the home page should be visible successfully

    When the user clicks on 'Signup / Login' button
    Then 'New User Signup!' should be visible

    When Enter name and email address
    And Click signup 'Signup' button
    Then Verify that 'ENTER ACCOUNT INFORMATION' should be visible

    When Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox 'Sign up for our newsletter!'
    And Select checkbox 'Receive special offers from our partners!'
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    When Click 'Create Account button'
    Then Verify that 'ACCOUNT CREATED!' should be visible

    When Click on 'Continue' button after account created
    Then Verify that 'Logged in as username' should be visible
    When Click delete 'Delete Account' button
    Then Verify that 'ACCOUNT DELETED!' should be visible
    And click continue 'Continue' button after account deleted