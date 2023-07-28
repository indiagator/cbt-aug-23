package com.cbt.cbtaug23;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService
{


    Logger logger = LoggerFactory.getLogger(PaymentService.class);


    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductofferRepository productofferRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    FullProductOfferService fullProductOfferService;

    public FullPaymentStatus composeFullPaymentStatus(String orderid)
    {
        FullPaymentStatus fullPaymentStatus = new FullPaymentStatus();
        Optional<Order> order = orderRepository.findById(orderid);
        fullPaymentStatus.setOffer(fullProductOfferService.
                composeFullProductOffer(order.get().getOfferid()));
        fullPaymentStatus.setBidamnt(order.get().getBid());
        return fullPaymentStatus;
    }

    public List<FullPaymentStatus>  getOrdersDuePayment(String buyername)
    {
        List<Payment> paymentList = paymentRepository.findAll();

        List<FullPaymentStatus> fullPaymentStatuses =  paymentList.stream().
            filter(payment3 -> payment3.getStatus().equals("DUE")).
            filter(payment4 ->  orderRepository.findById(payment4.getOrderid()).
                    get().getBuyername().equals(buyername) )
            .map(payment5 -> { return composeFullPaymentStatus(payment5.getOrderid());
            }).collect(Collectors.toList());

        return fullPaymentStatuses;

        //long dueCount =  paymentList.stream().
         //       filter(payment -> payment.getStatus().equals("DUE")).count();

        //logger.debug("this is the payment due count "+String.valueOf(dueCount));

       // List<Payment> paymentList1 = paymentList.stream().
         //       filter(payment -> payment.getStatus().equals("DUE")).collect(Collectors.toList());

        //List<Payment> paymentList2 = paymentList1.stream().filter(payment1 ->  orderRepository.findById(payment1.getOrderid()).
          //      get().getBuyername().equals(buyername) ).collect(Collectors.toList());

        //for (Payment payment2: paymentList2)
       // {
       //     logger.debug(String.valueOf(payment2));
       // }

    }


}
