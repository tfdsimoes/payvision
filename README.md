# Introduction
Payvision test 

Note:
I do not inserted all the brandId available in the Payvision into the program so I inserted all the cards, all others will have brandName other.
The commands are for linux.

# Backend 
These part of the program was build using Java 1.8 with Springboot

## Tests
In the root of the project run the command:
```
./mvn tests
```
There was a test plan but did not had time to implement.

## Run 
There is two ways to run the backend one with mvnw other using docker

### MVNW
Running with mvnw is easey in the root of the project run the following command:
```
./mvnw spring-boot:run -Dpayvision.username=code-challenge -Dpayvision.password=payvisioner
```
These will start a server in the port 8080.
Note:
If you want to change the username, password, url of page or extension to the resource use the following parameters in the startup
```
-Dpayvision.url=https://url.to.com
-Dpayvision.endpoint.payments=/extension/url
-Dpayvision.username=username
-Dpayvision.password=password
```

### Docker
To run with doker is a three phase work.
First you need to package the project. In the root of the project run:
```
./mvnw clean package
```
These will clean any previous compilations and package the project into a jar file.

In the folder there is already a Dockerfile with the configurations, so now build the image of docker.
```
docker build -t payvision-backend:latest .
```
In the Dockerfile can be configured the same fields as in MVNW way to run

Finally to run the docker just do the following command
```
docker run -p 8080:8080 payvision-backend:latest
```

## Endpoints available
```
http://localhost:8080/payments
Paramenters:
    - action (payment, authorize, credit)
    - currencyCode (USD, EUR, GBP)
```

# Frontend
Created using Angular8 and boostrap

## Tests

## Run
Not implemented

### NG
To run using ng go to the folder src/main/webapp and run the command:
```
ng serve -o
```
These will start the app and open a web browser with the application.

Note: To use these method you need to have install in your machine Angular CLI

### Docker
Go to the folder in src/main/webapp and run the following command:
```
docker build -t payvision-frontend:latest .
```
These will compile and create an image with nginx to serve the application.

After complete the build just run the command:
```
docker run -p 4200:80 payvision-frontend:latest
```

## Access
The application can be access using the url
```
http://localhost:4200
```
