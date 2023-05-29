package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.dto.MailGroupsOfAlertDto;
import com.bitirmetezi.prometheusjava.data.entity.MailList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MailListRepository extends JpaRepository<MailList, Long> {

    @Query(value = "Select new com.bitirmetezi.prometheusjava.data.dto.MailGroupsOfAlertDto(m.id, m.name) From AlertMailGroup amg inner join amg.mailList m where amg.alert.id =:alertId")
    List<MailGroupsOfAlertDto> findMailListsByAlertId(Long alertId);
}
