package service;

import model.Delivery;
import model.User;

import java.util.List;

public interface DeliveryService {
    List<Delivery> getDeliveryByUser(User user);

    Delivery getDeliveryByUserIdAndType(int userId, int type);

    Delivery getDeliveryByDeliveryId(int deliveryId);

    int addDelivery(Delivery delivery);

    int updateDelivery(Delivery delivery);
}
