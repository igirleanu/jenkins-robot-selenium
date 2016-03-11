*** Settings ***
Library     Selenium2Library
Suite Setup     Open Browser  ${HOMEPAGE}  ${BROWSER}
Test Setup      Go To  ${HOMEPAGE}
Suite Teardown      Close All Browsers
Documentation       Demonstrate silenium

*** Variables ***
${HOMEPAGE}     http://google.com
${BROWSER}      ie


*** Testcases ***
Cautam google si verificam rezultatele
    [Tags]     templated-tests
    [Template]     Google si verifica rezultatele
    devops      devops
    deveo       deveo
    robot framework     robotframework.org

*** Keywords ***
Google si verifica rezultatele
    [Arguments]     ${searchkey}        ${result}
    Input Text      id=lst-ib  ${searchkey}
    Click Button    name=btnG
    Wait Until Page Contains        ${result}