package dto;

import java.util.List;

public class Review {
    private int userId;
    private String lastDesc;
    private String userName;
    private int scoreId;
    private String topic;
    private List<DeliveryLite> deliveryLiteList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastDesc() {
        return lastDesc;
    }

    public void setLastDesc(String lastDesc) {
        this.lastDesc = lastDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<DeliveryLite> getDeliveryLiteList() {
        return deliveryLiteList;
    }

    public void setDeliveryLiteList(List<DeliveryLite> deliveryLiteList) {
        this.deliveryLiteList = deliveryLiteList;
    }
}
