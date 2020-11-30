package com.kingjakeu.springstudy.domain.common;

import com.kingjakeu.springstudy.domain.common.dao.CommonCodeRedisRepository;
import com.kingjakeu.springstudy.domain.common.domain.CommonCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonCodeRedisTest {

    @Autowired
    private CommonCodeRedisRepository commonCodeRedisRepository;

    @Test
    public void createCommonCodeOnRedis(){
        String id = "nike";
        String message = "jordan";
        CommonCode commonCode = CommonCode.builder()
                .id(id)
                .message(message)
                .updateTime(LocalDateTime.now())
                .build();

        this.commonCodeRedisRepository.save(commonCode);

        Optional<CommonCode> optionalCommonCode = this.commonCodeRedisRepository.findById(id);
        if(!optionalCommonCode.isPresent()) throw new NoSuchElementException();
        final CommonCode savedCommonCode = optionalCommonCode.get();

        Assert.assertEquals(savedCommonCode.getId(), id);
        Assert.assertEquals(savedCommonCode.getMessage(), message);
        System.out.println(savedCommonCode.toString());
    }

    @Test
    public void deleteAllCommonCode(){
        this.commonCodeRedisRepository.deleteAll();;
    }
}
