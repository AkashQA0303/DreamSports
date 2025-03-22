Feature: Validate Task Completion for FanCode City Users

  @Fancode
  Scenario Outline: Validate Users in FanCode City have completed more than 50% tasks
    Given User has the todo tasks
    And User belongs to the city "<City>"
    Then User Completed task percentage should be greater than <Percentage>%
    
  Examples:
    | City    | Percentage |
    | FanCode | 50         |