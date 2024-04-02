Feature: Validation of Place API's

Scenario Outline: Validate Add Place API
  Given Add place Payload with "<name>" "<language>" "<address>"
  When User hit "AddplaceAPI" with Post HTTP Request
  Then Place should be added successfully with Status code "200"
  And "Status" is "OK" in response body
  
 Examples:
 |name  |language| address|
 |my House| English| gurgaon sector 15|
  |your House| English| Noida sector 15|
 