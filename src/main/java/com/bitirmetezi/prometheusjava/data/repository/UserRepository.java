package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.data.dto.UserOfMailGroupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "Select new com.bitirmetezi.prometheusjava.data.dto.UserOfMailGroupDto(u.id, u.name, u.email, u.organisation) From UserMailGroup ug inner join ug.user u Where ug.mailList.id =:mailListId")
    List<UserOfMailGroupDto> findUsersByMailListId(Long mailListId);
}
