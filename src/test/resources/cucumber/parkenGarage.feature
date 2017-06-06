Feature: Parken
  As a user
  I want to park my car at the airport

  Scenario Outline: park my car for x min in the garage
    Given The parking lot is open
    When I park in the garage for <parkingTime>
    Then I pay <pay> Euro

    Examples:
     | parkingTime | pay  |
     |     30 min  |  2   |
     |     1 h     |  2   |
     |     3 h     |  6   |
     |     6 h     |  12  |
     |     7 h     |  12  |
     |    24 h     |  12  |
     |  1 day, 1h  |  14  |
     |  1 day, 3h  |  18  |
     |  1 day, 7h  |  24  |
     |    6 days   |  72  |
     |  6 days, 6h |  72  |
     |    7 days   |  72  |
     |1 week, 2days|  96  |
     |   3 weeks   | 216  |
