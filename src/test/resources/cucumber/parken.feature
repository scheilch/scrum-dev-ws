Feature: Parken
  As a user
  I want to park my car at the airport

  Scenario Outline: park my car for x min
    Given The parking lot is open
    When I park for <parkingTime>
    Then I pay <pay> Euro

    Examples:
     | parkingTime | pay  |
     |     30 min  |  2   |
     |     1 h     |  2   |
     |     5 h     |  10  |
     |     6 h     |  10  |
     |    24 h     |  10  |
     |  1 day, 1h  |  12  |
     |  1 day, 3h  |  16  |
     |  1 day, 6h  |  20  |
     |    6 days   |  60  |
     |  6 days, 6h |  60  |
     |    7 days   |  60  |
     |1 week, 2days|  80  |
     |   3 weeks   | 180  |
