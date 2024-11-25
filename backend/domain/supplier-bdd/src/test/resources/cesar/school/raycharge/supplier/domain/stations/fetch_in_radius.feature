Feature: Fetch Stations in Radius

  Scenario: Fetch stations in radius
    Given a station with name "Station 1", latitude -8.1473317, and longitude -34.9078105
    And a station with name "Station 2", latitude -8.1477035, and longitude -34.9088834
    And a station with name "Station 3", latitude -8.1485637, and longitude -34.9112437
    When I fetch stations in radius 5 kilometers from latitude -8.1479902 and longitude -34.9065338
    Then I should get 3 stations

  Scenario: Fetch stations in radius with some stations out of range
    Given a station with name "Station 1", latitude -8.1473317, and longitude -34.9078105
    And a station with name "Station 2", latitude -8.1477035, and longitude -34.9088834
    And a station with name "Station 3", latitude 37.6879, and longitude -122.4702
    When I fetch stations in radius 5 kilometers from latitude -8.1479902 and longitude -34.9065338
    Then I should get 2 stations

  Scenario: Fetch stations in radius with no stations in range
    Given a station with name "Station 1", latitude 38.5816, and longitude -121.4944
    And a station with name "Station 2", latitude 37.3382, and longitude -121.8863
    And a station with name "Station 3", latitude 36.7783, and longitude -119.4179
    When I fetch stations in radius 5 kilometers from latitude -8.1479902 and longitude -34.9065338
    Then I should get 0 stations