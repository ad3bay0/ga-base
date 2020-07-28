FROM openjdk:13-jdk-alpine

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B
RUN ./mvnw clean package -DskipTests=true
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

COPY BOOT-INF/lib /gatest/lib
COPY META-INF /gatest/META-INF
COPY BOOT-INF/classes /gatest

ENTRYPOINT ["java","-cp","gatest:gatest/lib/*","com.ad3bay0.gatest.GaTestApp"]
