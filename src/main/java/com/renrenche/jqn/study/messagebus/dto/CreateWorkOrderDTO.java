package com.renrenche.jqn.study.messagebus.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jiangqiaonan
 */
@Getter
@Setter
@ToString
public class CreateWorkOrderDTO {
    private Long carId;

    private String workOrderId;

    private String rrcId;

    private Long ts;

    public boolean isValidate() {
        return carId != null && carId > 0 && StringUtils.isNotEmpty(workOrderId);
    }
}
