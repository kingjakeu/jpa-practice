package com.kingjakeu.springstudy.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
@NoArgsConstructor
public class ParticipantDto {
    private Long participantId;
    private Long teamId;
    private Long championId;
    private Long spell1Id;
    private Long spell2Id;
    private StatDto stats;
    private TimelineDto timeline;
}
