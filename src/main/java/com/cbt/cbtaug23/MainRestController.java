package com.cbt.cbtaug23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class MainRestController
{

    @Autowired
    CredentialRepository credentialRepository; // CredentialRepoImpl*

    @Autowired
    UserdetailRepository userdetailRepository;

    @Autowired
    UsertypelinkRepository usertypelinkRepository;

    @Autowired
    ProductofferRepository productofferRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FullUserDetailService fullUserDetailService;

    @GetMapping("greet")
    public ResponseEntity<String> greet()
    {
        return new ResponseEntity<>("Hello this is Main Controller",HttpStatus.OK);
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

    @PostMapping("save/user/detail")
    public ResponseEntity<Userdetail> saveUserDetails(@RequestBody Userdetail userdetail)
    {
        userdetailRepository.save(userdetail);
        return new ResponseEntity<>(userdetail,HttpStatus.OK);
    }

    @PostMapping("save/user/type")
    public ResponseEntity<Usertypelink> saveUserType(@RequestParam String username, @RequestParam String type)
    {
        Usertypelink link = new Usertypelink();
        link.setLinkid(String.valueOf((int)(Math.random()*100000)));
        link.setUsername(username);
        link.setType(type);
        usertypelinkRepository.save(link);
        return new ResponseEntity<>(link,HttpStatus.OK);
    }

    @GetMapping("get/user/detail")
    public ResponseEntity<FullUserDetail> getUserDetail(@RequestParam String username)
    {
        return new ResponseEntity<>(fullUserDetailService.composeFullUserDetail(username),HttpStatus.OK);
    }

    @PostMapping("save/offer")
    public ResponseEntity<Productoffer> saveOffer(@RequestBody Productoffer offer)
    {
        offer.setId(String.valueOf((int)(Math.random()*100000)));
        productofferRepository.save(offer);
        return new ResponseEntity<>(offer,HttpStatus.OK);
    }

    @GetMapping("get/product/all")
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }


}
