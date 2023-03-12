package rest.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartSessionController {
    @GetMapping("/start-session")
    public ResponseEntity<String> startSession(HttpSession session) {
        // Generate a session ID
        String sessionId = session.getId();

        // Associate a session object with the session ID
       // session.setAttribute("mySessionData", new MySessionData());

        // Set the session ID in a response header
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Session-Id", sessionId);

        // Return the response with the session ID in the header
        return new ResponseEntity<>("Session started", responseHeaders, HttpStatus.OK);
    }


}
