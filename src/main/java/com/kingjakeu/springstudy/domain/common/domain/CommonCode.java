package com.kingjakeu.springstudy.domain.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString
@RedisHash("CommonCode")
public class CommonCode implements Serializable {

    @Id
    private String id;
    private String message;
    private LocalDateTime updateTime;

    @Builder
    public CommonCode(String id, String message, LocalDateTime updateTime){
        this.id = id;
        this.message = message;
        this.updateTime = updateTime;
    }

    public void refresh(String message, LocalDateTime updateTime){
        if(this.updateTime.isBefore(updateTime)){
            this.message = message;
            this.updateTime = updateTime;
        }
    }
}
