Feature: Login
    Perform UI checks for Login screen with email and password

    @login-feature @HappyFlow
    Scenario Outline: As a user I see success message by entering valid Email and password
        Given I start the application
        And I enter <email> in the email field
        And I enter <password> in the password field
        When I click submit button
        Then I see successful login <message>
        Examples:
            | email                | password                    | message  |
            | avalidemail@mail.com | 12345678                    | Success! |
            | testemail@gmail.com  | somePassWithVeryLongValue   | Success! |

    @login-feature @ErrorFlow
    Scenario: As a user I see error messages when entered email is invalid
        Given I start the application
        And I enter invalid.email.com in the email field
        And I enter 1234abcd in the password field
        When I click submit button
        Then I see error shown for email field as 'Please provide a valid email'

    @login-feature @ErrorFlow
    Scenario: As a user I see error messages when email field is empty
        Given I start the application
        And I enter empty in the email field
        And I enter 1234abcd in the password field
        When I click submit button
        Then I see error shown for email field as 'This is a required field'

    @login-feature @ErrorFlow
    Scenario: As a user I see error messages when email field is empty
        Given I start the application
        And I enter testemail@gmail.com in the email field
        And I enter 12ab in the password field
        When I click submit button
        Then I see error shown for password field as 'Password needs to be atleast 6 characters'
