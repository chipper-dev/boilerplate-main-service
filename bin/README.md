### BOILERPLATE OF TEMANKONDANGAN BACKEND SERVICE

Since the backend app of TemanKondangan is going to be migrated to Microservice from Monolithic Architecture,  
here is the boilerplate/template for creating new service if you are going to use the **Spring Boot** to create a new Service.

##### STACK
* Java 8
* Spring Boot
* Maven
* Postgresql
* Eureka Server as Service Discovery
* Zuul as API Gateway 

> ###### Note
> Before you start to develop the Service, please clone this repo into you local machine:
>   1. The API Gateway/Auth Service App, you can find the repo [here](https://github.com/chipper-dev/tk-be-auth-proxy-service).
>   2. The Service Discovery App, you can find the repo [here](https://github.com/chipper-dev/tk-be-discovery-service).
>
> And run them on your local machine. So you can develop this new service without problem.
> 
> ###### Or
> 
> You can use the `docker-compose` to run these services (API Gateway & Service Discovery Server).
> 
> You can this [docker-compose.yml](#) file.(PS: It's still not ready yet. Coming soon).

##### Naming
| Parts                        | Naming                                  | Example |
|------------------------------|-----------------------------------------|---------|
| artifact & project name      | {service name}-service                  |profile-service|
| package                      | com.mitrais.chipper.tk.be.{service name}|com.mitrais.chipper.tk.be.profileservice|
| image & container            | tk-be-{service name}-service            |tk-be-profile-service|
| database                     | tk_db_{service name}_service            |tk_db_profile_service|

##### Dependencies
Minimum requirements of the Dependencies that are needed on each services
* Spring Web
* Spring Security
* Spring Data JPA
* Postgres SQL Driver
* Eureka Client
* Hystrix
* Hystrix Dashborad
* Actuator
* Feign Client (Open Client if you search at sprint initializer)
* Swagger
* Jjwt
* Json-smart (I don't know why we need it, since the JSONObject in CustomResponseEntityExceptionHandler of existing application don't need it.)

Optional:
* Lombok
* Spring Boot Dev Tools

##### Setup
You can generate/setup new service/application through [start.spring.io](http://start.spring.io) by following this [link](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.1.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.mitrais.chipper.tk.be&artifactId=profile-service&name=profile-service&description=The%20Profile%20Service%20of%20TemanKondangan%20App&packageName=com.mitrais.chipper.tk.be.profileservice&dependencies=lombok,devtools,web,security,data-jpa,postgresql,cloud-eureka,cloud-hystrix,cloud-hystrix-dashboard)








