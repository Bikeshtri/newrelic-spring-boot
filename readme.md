```xml
<dependency>
    <groupId>com.newrelic.agent.java</groupId>
    <artifactId>newrelic-java</artifactId>
    <version>8.1.0</version>
    <scope>provided</scope>
    <type>zip</type>
</dependency>


<!-- Unzip --->
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-dependency-plugin</artifactId>
  <version>3.1.1</version>
  <executions>
      <execution>
          <id>unpack-newrelic</id>
          <phase>package</phase>
          <goals>
              <goal>unpack-dependencies</goal>
          </goals>
          <configuration>
              <includeGroupIds>com.newrelic.agent.java</includeGroupIds>
              <includeArtifactIds>newrelic-java</includeArtifactIds>
              <!-- you can optionally exclude files -->
              <excludes>
                  **/newrelic.yml,**/extension.xsd,**/extension-example.xml,**/LICENSE,**/newrelic-api.jar,**/newrelic-api-javadoc.jar,**/newrelic-api-sources.jar,**/THIRD_PARTY_NOTICES.md
              </excludes>

              <overWriteReleases>false</overWriteReleases>
              <overWriteSnapshots>false</overWriteSnapshots>
              <overWriteIfNewer>true</overWriteIfNewer>
              <outputDirectory>${project.build.directory}</outputDirectory>
          </configuration>
      </execution>
  </executions>
</plugin>

<!-- Move rerelic yml file to the app root/start  loation -->

<plugin>
    <artifactId>maven-resources-plugin</artifactId>
    <executions>
        <execution>
            <id>copy-resources</id>
            <phase>validate</phase>
            <goals>
                <goal>copy-resources</goal>
            </goals>
            <configuration>
                <outputDirectory>${project.build.directory}</outputDirectory>
                <resources>
                    <resource>
                        <directory>./</directory>
                        <filtering>true</filtering>
                        <include>**/*.yml</include>
                    </resource>
                </resources>
            </configuration>
        </execution>
    </executions>
</plugin>
          
          
```

```shell
// run from terminal

$ java -javaagent:target/newrelic/newrelic.jar -jar  target/newrelic-sample-0.0.1-SNAPSHOT.jar
Note:- newrelic.yml file should be in the root/current directry 

or
$ cd target
$ java -javaagent:newrelic/newrelic.jar -jar newrelic-sample-0.0.1-SNAPSHOT.jar
Note:- newrelic.yml file should be in the target directry 
```