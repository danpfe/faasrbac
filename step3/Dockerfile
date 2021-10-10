FROM registry.hub.docker.com/library/maven:3-jdk-11 as builder

WORKDIR /build

COPY . ./

RUN mvn -B -s settings.xml package

FROM registry.hub.docker.com/library/openjdk:11

WORKDIR /opt/app

RUN chmod 777 /opt/app

COPY --from=builder /build/target/step3.jar ./

CMD [ "java", "-jar", "step3.jar" ]
