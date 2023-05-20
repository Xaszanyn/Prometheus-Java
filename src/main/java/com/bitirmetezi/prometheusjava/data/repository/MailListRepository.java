package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.MailList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailListRepository extends JpaRepository<MailList, Long> {
}
