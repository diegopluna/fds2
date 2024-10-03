Feature: Create User

  Scenario: Successfully create a new user
    Given a user with login "testuser", password "password123", and role "DRIVER"
    When I create the user
    Then the user should be saved successfully
    And the user should have a hashed password

  Scenario: Fail to create a user with an existing login
    Given a user with login "existinguser", password "password123", and role "DRIVER"
    And a user already exists with login "existinguser"
    When I create the user
    Then the user creation should fail
