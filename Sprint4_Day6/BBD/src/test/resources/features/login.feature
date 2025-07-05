Feature: User Login

  As a registered user
  I want to log in with my credentials
  So that I can access the dashboard

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard

  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    And clicks the login button
    Then an error message should be displayed

    Examples:
      | username       | password    |
      | wronguser      | wrongpass   |
      | admin          | wrongpass   |
      | unknown@example.com | test123 |
