package com.cbt.cbtaug23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    OrderRepository orderRepository;

    @Autowired
    OrderstatusRepository orderstatusRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PortRepository portRepository;

    @Autowired
    UserportlinkRepository userportlinkRepository;

    @Autowired
    OrderportlinkRepository orderportlinkRepository;

    @Autowired
    OfferportlinkRepository offerportlinkRepository;

    @Autowired
    FullUserDetailService fullUserDetailService;

    @Autowired
    FullProductOfferService fullProductOfferService;

    @Autowired
    OrderService orderService;

    @Autowired
    PaymentService paymentService;

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
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping("get/offer/all")
    public List<FullProductOffer> getAllOffers()
    {
         List<Productoffer> productofferList =  productofferRepository.findAll();

         return productofferList.stream().map(productoffer ->
                 { return fullProductOfferService.composeFullProductOffer(productoffer.getId());}
                        ).collect(Collectors.toList());

    }

    @PostMapping("save/order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order)
    {
        order.setOrderid(String.valueOf((int)(Math.random()*100000)));
        orderRepository.save(order);
        Orderstatus orderstatus = new Orderstatus();
        orderstatus.setId(String.valueOf((int)(Math.random()*100000)));
        orderstatus.setOrderid(order.getOrderid());
        orderstatus.setStatus("OPEN");
        orderstatusRepository.save(orderstatus);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @GetMapping("get/order/all/sellerwise/{sellername}")
    public ResponseEntity<List<FullOrder>> getAllOrderSellerwise(@PathVariable String sellername,
                                                       @RequestParam int count,
                                                       @RequestParam String status)
    {
        return new ResponseEntity<>(orderService.getOrdersSellerwise(sellername),HttpStatus.OK);
    }

    @PostMapping("save/order/status")
    public ResponseEntity<Orderstatus> saveOrderStatus(@RequestBody Orderstatus orderstatus)
    {
        orderstatus.setId(String.valueOf((int)(Math.random()*100000)));
        orderstatusRepository.save(orderstatus);

        Payment payment = new Payment();
        payment.setId(String.valueOf((int)(Math.random()*100000)));
        payment.setOrderid(orderstatus.getOrderid());
        payment.setOfferid(orderRepository.findById(orderstatus.getOrderid()).get().getOfferid());
        payment.setStatus("DUE");

        paymentRepository.save(payment);

        return new ResponseEntity<>(orderstatus,HttpStatus.OK);
    }

    @GetMapping("get/payment/buyerwise/{buyername}")
    public List<FullPaymentStatus> getPaymentStatusBuyerwise(@PathVariable String buyername)
    {
        return paymentService.getOrdersDuePayment(buyername);
    }


    @GetMapping("get/port/all")
    public List<Port> getAllPorts()
    {
        return portRepository.findAll();
    }

    @PostMapping("save/user/port")
    public ResponseEntity<Userportlink> saveUserPort(@RequestBody Userportlink userportlink)
    {
        userportlink.setLinkid(String.valueOf((int)(Math.random()*100000)));
        userportlinkRepository.save(userportlink);
        return new ResponseEntity<>(userportlink,HttpStatus.OK);
    }

    @PostMapping("save/order/port")
    public ResponseEntity<Orderportlink>  saveOrderPort(@RequestBody Orderportlink orderportlink)
    {
        orderportlink.setId(String.valueOf((int)(Math.random()*100000)));
        orderportlinkRepository.save(orderportlink);
        return new ResponseEntity<>(orderportlink,HttpStatus.OK);
    }

    @PostMapping("save/offer/port")
    public ResponseEntity<Offerportlink>  saveOfferPort(@RequestBody Offerportlink offerportlink)
    {
        offerportlink.setId(String.valueOf((int)(Math.random()*100000)));
        offerportlinkRepository.save(offerportlink);
        return new ResponseEntity<>(offerportlink,HttpStatus.OK);
    }



}
