package com.cbt.cbtaug23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class RestControllerTwo
{

    @Autowired
    CredentialRepository credentialRepository;

    @GetMapping("greet")
    public ResponseEntity<String> greet()
    {
        return new ResponseEntity<>("Hello this is Second Controller",HttpStatus.OK);
    }


    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Credential credential)
    {
        credentialRepository.save(credential);
        return new ResponseEntity<>("New Signup Successful", HttpStatus.OK);
    }

    @GetMapping("auth")
    public ResponseEntity<String> authenticate(@RequestBody Credential credential)
    {
        Optional<Credential> tempCredential;

        if( (tempCredential = credentialRepository.findById(credential.getUsername())).isPresent())
        {
            if(tempCredential.get().getPassword().equals(credential.getPassword()))
            {
                return new ResponseEntity<>("USER_AUTHENTICATED=TRUE",HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>("USER_AUTHENTICATED=FALSE",HttpStatus.NO_CONTENT);
            }
        }
        else
        {
            return new ResponseEntity<>("USER_AUTHENTICATED=FALSE",HttpStatus.NO_CONTENT);
        }
    }

}
