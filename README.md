# camel-app

## configuration files
- config/application.yml
- config/camel-context.xml
- config/log4j2.xml

## application.yml
Need to configure following parameters:
```
spring:
  datasource:
    url: jdbc:postgresql://<host>:<port>/<database>
    username: <login>
    password: <password>
  rabbitmq:
    host: <host>
    port: <port>
    username: <login>
    password: <password>
    exchange: <exchange name>
    queue: <queue name>
camel:
  directories:
    input:  <directory for input files>
    output: <directory for output files>
    error:  <directory for files processed with exception>
```
