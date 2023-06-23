package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.UserMailGroup;
import com.bitirmetezi.prometheusjava.data.util.UserMailGroupId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMailGroupRepository extends JpaRepository<UserMailGroup, UserMailGroupId> {

    @Query(value = "Select u From UserMailGroup u Where u.mailList =:mailListId")
    List<UserMailGroup> findByMailListId(Long mailListId);


}
