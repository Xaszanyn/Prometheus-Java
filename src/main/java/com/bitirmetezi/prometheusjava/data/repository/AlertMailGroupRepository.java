package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.AlertMailGroup;
import com.bitirmetezi.prometheusjava.data.util.AlertMailGroupId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertMailGroupRepository extends JpaRepository<AlertMailGroup, AlertMailGroupId> {

}
