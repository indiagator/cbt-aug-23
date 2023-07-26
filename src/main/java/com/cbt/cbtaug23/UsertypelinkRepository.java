package com.cbt.cbtaug23;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsertypelinkRepository extends JpaRepository<Usertypelink, String>
{
    @Query(value = "select * from usertypelinks u where u.username=?1",nativeQuery = true)
     public Optional<List<Usertypelink>> findAllByUsername(String username);
}