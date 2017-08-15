package com.example.notifications;

/**
 * Created by andikoh on 13/08/2017.
 */
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    //create user
    /*curl -d '{"username":"bbcUser1", "accessToken":"o.2jOld5V1c5qGYg4KDPEPrUROdcDUBMtr"}'
    -X POST http://localhost:8080/create -H "content-type: application/json"*/
    @RequestMapping(value = "/create", method = RequestMethod.POST, headers={"content-type=application/json"})
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Application.users.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //request list of users
    //http://localhost:8080/users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        if (Application.users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(Application.users, HttpStatus.OK);
        }
    }

    //request info of specific user
    //http://localhost:8080/user/bbcUser1
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = Application.findUser(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //send notification
    //curl -d '{"username":"bbcUser1"}' -X POST http://localhost:8080/push/ -H "content-type: application/json"
    @RequestMapping(value = "/push", method = RequestMethod.POST, headers={"content-type=application/json"})
    public void sendNotification(@RequestBody User username) {
        User target = Application.findUser(username.getUsername());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Access-Token", target.getAccessToken());

        Notification notification = new Notification();
        HttpEntity<Notification> request = new HttpEntity<>(notification, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation("https://api.pushbullet.com/v2/pushes", request);

        target.incrementNumOfNotificationsPushed();
    }

}
