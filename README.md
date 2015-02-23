Welcome to the main page of the Axon Address Book Sample.
=====

Goal
----

This is an updated version of [AxonFramework - Addressbook-Sample](https://github.com/AxonFramework/Addressbook-Sample).

This sample will show the basic features of the Axon framework. It will be done using multiple different client side applications, i.e.:

* a flex client, 
* a spring mvc client, 
* a REST client 
* and the start of a Vaadin client. 

The REST client is used in a node.js sample that can be found in another repository, [jettro - axon-addressbook-nodejs](https://github.com/jettro/axon-addressbook-nodejs).


Configuration
-----

Some tools are requires:

* Java (1.7&+), 
* Ant,
* Maven (3.0.5&+),
* Git.

The Flex module requires:

* Adobe Flex SDK (with Adobe AIR SDK and Player Global),
* **stand-alone** Flash Player.

Install
-----

For the last versions of Flex SDK, here the 4.14.0, Maven artifacts artifacts are not available from any m2 repository:

* Use Apache Flex SDK Mavenizer to generate these artifacts. 
* Copy them in your m2 repository (remote or local one, e.g. a Nexus server).

Run
----

First, from the parent folder:

>    mvn clean verify
    
Then from the folder of web-ui or vaadin-ui:

>    mvn jetty:run -Djetty-run

But from the folder of flex-ui/war:

>    mvn jetty:run-exploded -Djetty-run
    
Display
-----

Go on [http://localhost:8087](http://localhost:8087).

Note. The port can be changed from the aggregator pom file, see property "jetty.port".     

Issues
-----

The main one is about the address list view of each contact: the list is displayed when the contact is selected for the first time. But for any new attempt to select this contact, the list stays empty. 
  
        