package com.renrenche.jqn.study.messagebus.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jiangqiaonan
 */
@Getter
@Setter
@ToString
public class CloseCarDTO {
    private long carId;

    private long operatorId;

    private String reasonDesc;

    private String remark;

}
