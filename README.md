# QUERY DSL
+ Config
  + pom.xml
    + Plugin 추가 
      ```
            <plugin>
            <groupId>com.mysema.maven</groupId>
            <artifactId>apt-maven-plugin</artifactId>
            <version>1.1.3</version>
            <executions>
                <execution>
                    <goals>
                        <goal>process</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>target/generated-sources/java</outputDirectory>
                        <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                    </configuration>
                </execution>
            </executions>
            </plugin>
      ```
      <hr>
    + Dependency 추가
    ```
      <-- QueryDSL APT Config -->
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-apt</artifactId>
            <version>${querydsl.version}</version>
            <scope>provided</scope>
        </dependency>

        <!-- QueryDSL JPA Config -->
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-jpa</artifactId>
            <version>${querydsl.version}</version>
        </dependency>
    </dependencies>
    ```
    <hr>

  + Maven
    > mvn clean install 	  
       &rarr; QEntity 생성 확인
  
  + JPQL이 제공하는 모든 검색 조건 제공
  ```
  member.username.ne("member1") //username != 'member1'
  member.username.eq("member1").not() // username != 'member1'
  member.username.isNotNull() //이름이 is not null
  
  member.age.in(10, 20) // age in (10,20)
  member.age.notIn(10, 20) // age not in (10, 20)
  member.age.between(10,30) //between 10, 30
  
  member.age.goe(30) // age >= 30
  member.age.gt(30) // age > 30
  member.age.loe(30) // age <= 30
  member.age.lt(30) // age < 30
  
  member.username.like("member%") //like 검색
  member.username.contains("member") // like ‘%member%’ 검색
  member.username.startsWith("member") //like ‘member%’ 검색
  ```




