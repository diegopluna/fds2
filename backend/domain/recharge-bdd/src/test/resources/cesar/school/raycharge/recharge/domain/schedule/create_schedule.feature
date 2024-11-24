Feature: Create Schedule

  Scenario: Create schedule
    Given a driver with name "Driver 1"
    And a station with name "Station 1"
    And a vehicle with name "Vehicle 1" and license plate "ABC-1234"
    When I create the schedule in an available time slot
    Then the schedule should be created

  Scenario: Create schedule with driver already scheduled
    Given a driver with name "Driver 1"
    And a station with name "Station 1"
    And a vehicle with name "Vehicle 1" and license plate "ABC-1234"
    And a schedule already created
    When I create the schedule in an available time slot
    Then the schedule should not be created