Feature: Login into Application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://www.qaclickacademy.com/" site
    And click on login link in homepage to land on secure sign in page
    When User enters <username> and <password> and logs in
    Then Verify that user is successfully logged in
    And close browsers
    Examples:
      |username          |password  |
      |brohin@gmail.com  |12345678  |
      |test99@gmail.com  |12345     |

