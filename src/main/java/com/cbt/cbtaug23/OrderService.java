package com.cbt.cbtaug23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService
{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderstatusRepository orderstatusRepository;

    @Autowired
    ProductofferRepository productofferRepository;

    @Autowired
    UserdetailRepository userdetailRepository;

    public List<FullOrder> getOrdersSellerwise(String sellername)
    {
        List<Order> orderList =  orderRepository.findAll(); // Highly Impractical

        List<Order> filteredOrderList =  orderList.stream().filter(order ->
                productofferRepository.findById(order.getOfferid()).get().getSellername().equals(sellername)).
                                        collect(Collectors.toList());

        return filteredOrderList.stream().map(order -> {

            FullOrder fullOrder = new FullOrder();

            Productoffer offer =  productofferRepository.findById(order.getOfferid()).get();

            fullOrder.setOrder(order);
            fullOrder.setBuyerdetails(userdetailRepository.findById(order.getBuyername()).get());
            fullOrder.setOffername(offer.getOffername());
            fullOrder.setTotalprice(offer.getQty()*offer.getUnitprice());

            return fullOrder;
        }).collect(Collectors.toList());


    }

}
