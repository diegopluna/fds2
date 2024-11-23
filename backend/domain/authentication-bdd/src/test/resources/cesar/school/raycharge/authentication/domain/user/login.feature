Feature: Login
    Scenario: User login with valid credentials
        Given a user with login "user" and password "password"
        When the user logs in with login "user" and password "password"
        Then the user is logged in

    Scenario: User login with invalid credentials
        Given a user with login "user" and password "password"
        When the user logs in with login "user" and password "wrong"
        Then the user is not logged in