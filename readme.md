
download agent : newrelic-java.zip
https://docs.newrelic.com/docs/release-notes/agent-release-notes/java-release-notes/

unzip
copy [newrelic.jar](newrelic.jar) [newrelic.yml](newrelic.yml) files to root folder

update [newrelic.yml](newrelic.yml) with key and app names

clean install

java -javaagent:newrelic.jar -jar target/newrelic-sample-0.0.1-SNAPSHOT.jar