# pushbullet_notifications

a RESTful API to send push notifications via the Pushbullet API 

## Built With 
* [Spring](https://spring.io) - Web Framework 
* [Maven](https://maven.apache.org/) - Dependency Management
* [Pushbullet](https://www.pushbullet.com) - Push API

## Getting Started

Clone the repository
```
git clone https://github.com/amandakys/pushbullet_notifications.git
```

### Run the Maven Build 
navigate to uppermost /notifications folder 
```
./mvnw spring-boot:run
```

### To Register a User
use cURL terminal command.
replace "user1" with desired username string and "pushbullet_access_token" with relevant access token from pushbullet. 
```
curl -d '{"username":"user1", "accessToken":"pushbullet_access_token"}' -X POST http://localhost:8080/create -H "content-type: application/json"
```

### To Retrieve List of All Registered Users 
```
http://localhost:8080/users
```

### To Retrive Specific User
replace user1 with desired username
```
http://localhost:8080/users/user1
```

### To Send Notification 
use cURL terminal command. 
```
curl -d '{"username":"user1"}' -X POST http://localhost:8080/push -H "content-type: application/json"
```
