package dto;

public class TchDownload {

    private int stuId;
    private String stuName;
    private String stuState;

    private int deliveryId;
    private String deliveryType;
    private String deliveryTime;
    private String deliveryPath;
    private int deliveryState;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuState() {
        return stuState;
    }

    public void setStuState(String stuState) {
        this.stuState = stuState;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryPath() {
        return deliveryPath;
    }

    public void setDeliveryPath(String deliveryPath) {
        this.deliveryPath = deliveryPath;
    }

    public int getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(int deliveryState) {
        this.deliveryState = deliveryState;
    }

    @Override
    public String toString() {
        return "TchDownload{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuState='" + stuState + '\'' +
                ", deliveryId=" + deliveryId +
                ", deliveryType='" + deliveryType + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", deliveryPath='" + deliveryPath + '\'' +
                ", deliveryState=" + deliveryState +
                '}';
    }
}
