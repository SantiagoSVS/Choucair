Feature: Utest Registration

  Scenario: Santiago registers with his name
    Given Santiago is on the Utest homepage
    When Santiago clicks the Join Today button
    Then Santiago enters his name as "Santiago"
    Then Santiago should see the registration page
