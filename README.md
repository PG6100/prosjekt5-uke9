prosjekt5-uke9
==============

Denne øvingen handler om å få litt innsikt i transaksjon api-et til JEE. Importer prosjektet som Maven prosjekt til IDEA (husk Auto-import flagget ved importering, ref oppslag på Its Learning). For gradle, bruk `gradle idea` kommando som genererer `IDEA` filene.

Bruk `F4_Transaksjon` foiler som hjelpemidler.

Fra prosjektets mappe bør man gjøre følgende (set riktig `JAVA_HOME` og `DERBY_HOME`).

Start Derby[1] (ignorer warnings om ``tabellen allerede eksisterer``):

``Mac/Linux:``

    export JAVA_HOME=/opt/java/7.0/
    export DERBY_HOME=/opt/glassfish/4.0/javadb
    java -Djava.security.manager -Djava.security.policy=src/main/resources/1010_server.policy -Dderby.security.port=1527 -Dderby.install.url=file:$DERBY_HOME/lib/ -jar $DERBY_HOME/lib/derbyrun.jar server start

``Windows:``

    set JAVA_HOME=c:\Program\ Files\Java
    set DERBY_HOME=c:\glassfish\4.0\javadb
    java -Djava.security.manager -Djava.security.policy=src/main/resources/1010_server.policy -Dderby.security.port=1527 -Dderby.install.url=file:%DERBY_HOME%/lib/ -jar %DERBY_HOME%/lib/derbyrun.jar server start

Se for [2] for eksempel oppsett.

1. Implementer metodene i `EJB`.
2. Bygg prosjektet: `mvn package` eller `gradle jar`
3. Deploy via admin-consollet: `http://localhost:4848/common/index.jsf` => `Applications` => `Deploy`. Velg `target/prosjekt5-uke9-0.1.jar` og `Force redeploy`.

Tips: sjekk manuelt innholdet i derby databasen (for Windows bytt `$DERBY_HOME` med `%DERBY_HOME%`):

    $DERBY_HOME/javadb/bin/ij
    connect 'jdbc:derby://localhost:1527/sun-appserv-samples';
    show tables;
    select * from employee;
    select * from department;


Container managed transaction
--------
`EmployeeEJB` og `DepartmentEJB` er to EJB-er vi jobber med i dette prosjektet. Utforsk domene modellen. Hvilke transaksjonsattributt brukes i disse to EJB-ene? Eksperimenter med forskjellige attributtene.
Sett attributten til `SUPPORTS` i `EmployeeEJB`. Hva skjer når du forsøker å lagre et `Employee` objekt? Prøv med andre attributtene også.


Bean managed transaction
--------
Gjør `EmployeeEJB` og `DepartmentEJB` om til BMT. Hvilke endringer innebærer det? F.eks. kast exception fra en metode der metoden kalles fra en annen bønne.


[1] må gjøres på denne måten pga endringene i java 7u51: https://issues.apache.org/jira/browse/DERBY-6438

[2]
Data source: http://pbrd.co/1jrKjuB

Pool: http://pbrd.co/1jrKDcI
