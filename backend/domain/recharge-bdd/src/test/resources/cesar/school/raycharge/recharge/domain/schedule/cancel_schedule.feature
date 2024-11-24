Feature: Cancel Schedule

  Scenario: Cancel schedule
    Given a driver with name "Driver 1"
    And a station with name "Station 1"
    And a vehicle with name "Vehicle 1" and license plate "ABC-1234"
    And a schedule already created
    When I cancel the schedule
    Then the schedule should be cancelled

  Scenario: Cancel schedule with invalid schedule
    Given a driver with name "Driver 1"
    And a station with name "Station 1"
    And a vehicle with name "Vehicle 1" and license plate "ABC-1234"
    When I cancel the schedule
    Then the schedule should not be cancelled