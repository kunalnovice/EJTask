Feature: feature Test 5

  @working
  Scenario: 1a Check that response by calling code- positive
    Given I invoke calling code API for calling code 372
    Then Response should contain name as "Estonia"

  @working
  Scenario: 1b Check that response by calling code- negative
    Given I invoke calling code API for calling code 371
    Then Response should not contain name as "Estonia"

  @working
  Scenario: 1c Check that response by capital city- positive
    Given I invoke calling code API for capital city "Tallinn"
    Then Response should contain name as "Estonia"

  @working
  Scenario: 1d Check that response by capital city- negative
    Given I invoke calling code API for capital city "Riga"
    Then Response should not contain name as "Estonia"

  @working
  Scenario: 2a find Countries in regions for example
    Given I invoke calling code API for Region "Asia"
    Then bordering countries matrix is calculated

  @working
  Scenario: 2b find Countries in regions for example
    Given I invoke calling code API for Region "Europe"
    Then bordering countries matrix is calculated

  @working
  Scenario: 3a check Country and Expected Bordering COuntry in given Region
    Given I invoke calling code API for Region "Europe"
    Then Get me bordering country for the Country "Germany"

  @testExamples
  Scenario: 4a Invoke Regional Bloc API to Identify Number of Countries in Given Bloc
    Given I Invoke Regional Bloc API
    Then I identify Count of returned Countries

  @testExamples
  Scenario: 4b Identify ALL NeighBouring Countries pair speaking same language in Given Region
    Given I Invoke Region API for Region "Europe"
    Then I identify neighbouring Countries pair which speak same language