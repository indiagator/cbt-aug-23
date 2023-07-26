package com.cbt.cbtaug23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FullUserDetailService
{
    @Autowired
    UserdetailRepository userdetailRepository;

    @Autowired
    UsertypelinkRepository usertypelinkRepository;

    public FullUserDetail composeFullUserDetail(String username)
    {
        FullUserDetail fullUserDetail = new FullUserDetail();

        Optional<Userdetail> userdetail;
        if((userdetail = userdetailRepository.findById(username)).isPresent())
        {
            fullUserDetail.setDetail(userdetail.get());
        }

        Optional<List<Usertypelink>> usertypelinkList;
        if((usertypelinkList = usertypelinkRepository.findAllByUsername(username)).isPresent())
        {
            fullUserDetail.setLink(usertypelinkList.get());
        }
        return fullUserDetail;

    }
}
