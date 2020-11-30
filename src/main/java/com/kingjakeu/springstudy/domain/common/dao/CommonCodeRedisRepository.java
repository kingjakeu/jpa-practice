package com.kingjakeu.springstudy.domain.common.dao;

import com.kingjakeu.springstudy.domain.common.domain.CommonCode;
import org.springframework.data.repository.CrudRepository;

public interface CommonCodeRedisRepository extends CrudRepository<CommonCode, String> {
}
