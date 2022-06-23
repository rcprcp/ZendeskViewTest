# ZendeskViewTest

This program is used for testing the View support in the Cloudbees zendesk-java-client 

## Build: 

* Clone the repo.
* `cd` into the directory 
* If necessary, update the pom.xml to set the Zendesk Java Client library version as needed.
* Build the runnable jar - `mvn package` 


## Run: 
In order to authenticate - please set these environment variables:
```shell
export ZENDESK_ID=<email>
export ZENDESK_TOKEN=<token>
```
Run it:
```shell
java -jar target/ZendeskViewTest-1.0-SNAPSHOT-jar-with-dependencies.jar
```
