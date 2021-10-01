# exchanges

1. Build
```
./mvnw spring-boot:build-image
```
2. Create the image
```
 docker build -t exchanges .
```
3. Execute
```
docker run -d -p 8080:8080 --name exchanges exchanges
```
4. To stop
```
docker stop exchanges
```
