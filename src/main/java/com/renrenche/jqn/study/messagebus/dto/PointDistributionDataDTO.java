package com.renrenche.jqn.study.messagebus.dto;

import lombok.Data;

/**
 * 驻点派单对算法的通知
 *
 * @author jiangqiaonan
 */
@Data
public class PointDistributionDataDTO {
    /**
     * 车辆id
     */
    private Long carId;

    /**
     * 工单id
     */
    private String workOrderId;

    private String rrcId;

    private String city;

    /**
     * 驻地id
     */
    private Long pointId;

    /**
     * 包id
     */
    private String packageId;

    /**
     * 评估师经度
     */
    private Double inspectorLng;

    /**
     * 评估师纬度
     */
    private Double inspectorLat;

    /**
     * 驻点经度
     */
    private Double pointLng;

    /**
     * 驻点纬度
     */
    private Double pointLat;

    /**
     * authid
     */
    private Long mainAuthId;

    /**
     * 合伙人id
     */
    private Long partnerId;

    /**
     * 评估师id
     */
    private Long inspectorId;

    /**
     * 距离
     */
    private Double distance;

    private Double centerOrderDistanceOrigin;

    /**
     * 算法唯一id
     */
    private String batchId;

    /**
     * 1：优质
     * 2：普通
     */
    private Integer workOrderType;

    /**
     * 超区单子标记（1：超区单；2：非超区单；0：默认值；11：重复单标记）
     */
    private Integer exceedRegion;

}
