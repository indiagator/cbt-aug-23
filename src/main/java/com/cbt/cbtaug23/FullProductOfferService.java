package com.cbt.cbtaug23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FullProductOfferService
{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductofferRepository productofferRepository;

    @Autowired
    UserdetailRepository userdetailRepository;

    public FullProductOffer  composeFullProductOffer(String offerId)
    {

        FullProductOffer offer = new FullProductOffer();

        Optional<Productoffer> productoffer;

        if((productoffer = productofferRepository.findById(offerId)).isPresent())
        {
            offer.setProductoffer(productoffer.get());
            offer.setProduct( productRepository.findById(productoffer.get().getHscode()).get());
            offer.setUserdetail(userdetailRepository.findById(productoffer.get().getSellername()).get());
            offer.setTotalPrice(productoffer.get().getQty()*productoffer.get().getUnitprice());
        }

        return offer;

    }
}
