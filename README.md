## Deploy to local k8s

1. `minikube start` To start a local k8s environment
2. `mvn clean package -P build-docker-image` without `@EnableEurekaClient` and `eureka.client.enabled=false` for all
   microservices. apigw and eureka-server microservice is not needed on k8s
3. `cd k8s/minikube/bootstrap/`
4. `kubectl apply -f bootstrap/postgres` Starting database
5. `kubectl apply -f bootstrap/rabbitmq` Starting message queue
6. `kubectl apply -f bootstrap/zipkin` Starting zipkin
7. `kubectl apply -f services/customer` Starting customer microservice
8. `kubectl apply -f services/fraud` Starting fraud microservice
9. `kubectl apply -f services/notification` Starting notification microservice

---

## Deploy to local docker with docker compose.

If you want to use service discovery (eureka-server) and apigw. Make sure to:

1. comment in eureka-server and apigw services in `docker-compose.yml` file
2. set `eureka.client.enabled=true` in `application.yml` file for customer, fraud, notification
3. `@EnableEurekaClient` in Application class for customer, fraud, notification
4. Build new docker image with `mvn clean package -P build-docker-image` to get action 2. and 3. in image
5. `docker compose up -d`

## Deploy to local docker with docker compose without service discovery

Since all ports are opened in docker compose file. You can simply comment out apiqw and eureka service and use
microservice ports 
