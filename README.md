prosjekt5-uke9
==============

Fra prosjektets mappe:

Start Derby[1] (ignorer warnings om ``tabellen allerede eksisterer``):

``Mac/Linux:``

    export JAVA_HOME=/opt/java/7.0/
    export DERBY_HOME=/opt/glassfish/4.0/javadb
    java -Djava.security.manager -Djava.security.policy=src/main/resources/1010_server.policy -Dderby.security.port=1527 -Dderby.install.url=file:$DERBY_HOME/lib/ -jar $DERBY_HOME/lib/derbyrun.jar server start

``Windows:``

    set JAVA_HOME=c:\Program\ Files\Java
    set DERBY_HOME=c:\glassfish\4.0\javadb
    java -Djava.security.manager -Djava.security.policy=src/main/resources/1010_server.policy -Dderby.security.port=1527 -Dderby.install.url=file:%DERBY_HOME%/lib/ -jar %DERBY_HOME%/lib/derbyrun.jar server start


Tips: sjekk manuelt innholdet i derby databasen:

    $DERBY_HOME/javadb/bin/ij
    connect 'jdbc:derby://localhost:1527/sun-appserv-samples';
    show tables;
    select * from employee;
    select * from department;

For Windows bytt `$DERBY_HOME` med `%DERBY_HOME%`.



[1] må gjøres på denne måten pga endringene i java 7u51: https://issues.apache.org/jira/browse/DERBY-6438
