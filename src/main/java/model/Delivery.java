package model;

import java.util.Date;

public class Delivery {
    private Integer deliveryId;

    private Integer deliveryUserId;

    private Integer deliveryType;

    private String deliveryDesc;

    private String deliveryPath;

    private Date deliveryTime;

    private Integer deliveryState;

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Integer deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryDesc() {
        return deliveryDesc;
    }

    public void setDeliveryDesc(String deliveryDesc) {
        this.deliveryDesc = deliveryDesc == null ? null : deliveryDesc.trim();
    }

    public String getDeliveryPath() {
        return deliveryPath;
    }

    public void setDeliveryPath(String deliveryPath) {
        this.deliveryPath = deliveryPath == null ? null : deliveryPath.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", deliveryUserId=" + deliveryUserId +
                ", deliveryType=" + deliveryType +
                ", deliveryDesc='" + deliveryDesc + '\'' +
                ", deliveryPath='" + deliveryPath + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", deliveryState=" + deliveryState +
                '}';
    }
}