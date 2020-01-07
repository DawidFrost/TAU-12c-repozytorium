*** Settings ***
Documentation     A resource file with reusable keywords and variables.
Library           Process

*** Variables ***
${COMMAND} 	dotnet ./netcoreapp3.0/DetectGeometricalFigure.dll

*** Keywords ***
Run Shapes App And Test Triangle
    [Arguments]   ${a}   ${b}   ${c}   ${expected}
    ${result}=   Start Process     ${COMMAND}   ${a}   ${b}   ${c}
    Should Be Equal   ${result.stdout}      ${expected}

Run Shapes App And Test Quadrangle
    [Arguments]   ${a}   ${b}   ${c}   ${d}     ${expected}
    ${result}=   Start Process     ${COMMAND}   ${a}   ${b}   ${c}    ${d}
    Should Be Equal   ${result.stdout}      ${expected}


