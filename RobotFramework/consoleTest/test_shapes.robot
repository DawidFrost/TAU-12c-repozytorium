*** Settings ***
Documentation     Test shapes.
...
...               This test has a workflow that is created using keywords in
...               the imported resource file.
Resource          resource.robot


*** Test Cases ***
Check Triangle Nierozpoznano     
    ${result}=   Run Process     ./Shell/T_Nierozpoznano.sh
    Should Be Equal   ${result.stdout}      nierozpoznano

Check Triangle Rownoboczny     
    ${result}=   Run Process     ./Shell/T_Rownoboczny.sh
    Should Be Equal   ${result.stdout}      trojkat_rownoboczny  
Check Triangle Rownoramienny     
    ${result}=   Run Process     ./Shell/T_Rownoramienny.sh
    Should Be Equal   ${result.stdout}      trojkat_rownoramienny 

Check Triangle Roznoramienny     
    ${result}=   Run Process     ./Shell/T_Roznoramienny.sh
    Should Be Equal   ${result.stdout}      trojkat_roznoramienny 

Check Quadrangle Nierozpoznano     
    ${result}=   Run Process     ./Shell/Q_Nierozpoznano.sh
    Should Be Equal   ${result.stdout}      nierozpoznano

Check Quadrangle Kwadrat     
    ${result}=   Run Process     ./Shell/Q_Kwadrat.sh
    Should Be Equal   ${result.stdout}      kwadrat 

Check Quadrangle Prostokat     
    ${result}=   Run Process     ./Shell/Q_Prostokat.sh
    Should Be Equal   ${result.stdout}      prostokat 

Check Quadrangle Czworobok     
    ${result}=   Run Process     ./Shell/Q_Czworobok.sh
    Should Be Equal   ${result.stdout}      czworobok 
