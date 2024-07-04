Spring cloud open feign
Basically it is used for the communication between two microservices .
1.	Add the dependency  of SCOF
2.	@ENableFeignClient  add annotation on the application.main
3.	Create an interface feignclint or api client
4.	@FeignClient(url = "http://localhost:8080",value="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/getDepartment/{dcode}")
    DepartmentDto getbydepartmentcode(@PathVariable String dcode);

}
5.	Use this apiclient in the service method DepartmentDto departmentDto=apiClient.getbydepartmentcode(em.getDepartmentcode());
EmployeeDto employeeDto= new EmployeeDto(em.getId(),em.getFirstname(),em.getLastname(),em.getEmail(),em.getDepartmentcode());
//////////////////////////

SErvice Registry :
if m1 wants to communicate with any instace of m2 then m1 have to know the host and port of m2 and its instace s .
to remove this issue service registry comes into the picture .

m1 needs to know the name and the id of the m2 and then they can communicate

in cloud env , service instances may come up and go down anytime . so we need some automatic service registration and discovery machenaism .
----spring coud Netflix Eureka


we will make project of service registry as we do oither projects but we will not use it as a application.
we will use it only for communication between other services
in application .properties
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

this means we will not use service registry as a application

eureka.client.register-with-eureka=false:

Meaning: This setting tells the Eureka client not to register itself with the Eureka server.
Why Use It: You would use this setting if the application is not a service that needs to be discovered by other services. For example, it could be a standalone application, a configuration server, or some other client that simply needs to know about other services but does not need to be registered itself.
eureka.client.fetch-registry=false:

Meaning: This setting tells the Eureka client not to fetch the registry of services from the Eureka server.
Why Use It: This setting is useful if the application doesn't need to discover other services. For example, if it's a standalone service or it relies on static service URLs rather than dynamic discovery through Eureka.



eureka.client.register-with-eureka=false
eureka.client.fetch-registry=falsewhy we do this and what does it mean
ChatGPT
The properties eureka.client.register-with-eureka=false and eureka.client.fetch-registry=false are configurations for a Eureka client in a Spring Cloud application using Netflix Eureka for service discovery. Here's what they mean and why you might set them:

eureka.client.register-with-eureka=false:

Meaning: This setting tells the Eureka client not to register itself with the Eureka server.
Why Use It: You would use this setting if the application is not a service that needs to be discovered by other services. For example, it could be a standalone application, a configuration server, or some other client that simply needs to know about other services but does not need to be registered itself.
eureka.client.fetch-registry=false:

Meaning: This setting tells the Eureka client not to fetch the registry of services from the Eureka server.
Why Use It: This setting is useful if the application doesn't need to discover other services. For example, if it's a standalone service or it relies on static service URLs rather than dynamic discovery through Eureka.
Common Use Cases
These settings are commonly used in the following scenarios:

Eureka Server: When you are setting up a Eureka server, you usually do not want it to register itself or fetch the registry of services, because its purpose is to serve as a registry for other services. In this case, you would set both properties to false in the configuration of the Eureka server.

properties
Copy code
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
Standalone Applications: If you have a client application that does not act as a service itself and does not need to discover other services dynamically (e.g., it uses static service URLs or doesn't need to interact with other services), you might set these properties to false to reduce unnecessary network traffic and dependencies on the Eureka server.
