FROM java:8

ENV SERVICE_PORT 8080
ENV SERVICE_WORKDIR /opt/email
ENV security_jwt_verifierKeyPath https://staging.decipher-lab.com/security/oauth/token_key
ENV database_driverClass com.mysql.jdbc.Driver
ENV database_url jdbc:mysql://localhost/email
ENV database_username test
ENV database_password test
ENV hibernate_dialect org.hibernate.dialect.MySQLDialect
ENV cors_allowedHeaders *
ENV cors_allowedOrigins *
ENV cors_allowedMethods GET,POST,PUT,DELETE,OPTIONS
ENV springfox_documentation_swagger_v2_path /swagger
ENV defaultLanguage en
ENV logging_level_ INFO
ENV spring_main_banner_mode off
ENV spring_rabbitmq_port=5672
ENV spring_rabbitmq_username=decipher-lab
ENV spring_rabbitmq_password=d3c!ph3r
ENV email_username=gateway
ENV email_password=gateway
ENV translation_url=https://translate:8443

EXPOSE ${SERVICE_PORT}
WORKDIR ${SERVICE_WORKDIR}

RUN apt-get update

COPY service/target/email.service-1.0.0-SNAPSHOT.jar ${SERVICE_WORKDIR}/

CMD java -jar ${SERVICE_WORKDIR}/email.service-1.0.0-SNAPSHOT.jar ${SERVICE_PORT}
