package com.sit.SoftwareProcess.SoftwareProcess.Controller;

import com.sit.SoftwareProcess.SoftwareProcess.Config.JWTService;
import com.sit.SoftwareProcess.SoftwareProcess.Model.User;
import com.sit.SoftwareProcess.SoftwareProcess.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class DogeCommerceController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users =  userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUserById(@RequestParam(name = "id") long id) {

        User user =  userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/users/username")
    public ResponseEntity<User> getUserByUsername(@RequestHeader(value="Authorization") String token,
                                                  @RequestAttribute String username) {
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/users/signin")
    public ResponseEntity<String> signInUsingUsername(@RequestBody(required = true) Map<String,Object> jsonBody,
                                                      HttpServletResponse response) {
        String username = jsonBody.get("username").toString();
        String password = jsonBody.get("password").toString();
        User user = userService.getUserByUsername(username);
        if(user != null) {
            String userPassword = user.getPassword();
            if(userPassword.equals(password)) {
                String token = jwtService.encodeUser(user);
                ResponseEntity<String> responseEntity = new ResponseEntity<String>("Sign in success", HttpStatus.OK);
                response.addCookie(new Cookie("_session", token));
                return new ResponseEntity<String>("Sign in success", HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Failed to signin", HttpStatus.OK);
    }
}
