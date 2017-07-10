package service.impl;

import mapper.DeliveryMapper;
import model.Delivery;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.DeliveryService;

import javax.annotation.Resource;
import java.util.List;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

    @Resource
    private DeliveryMapper deliveryMapper;

    @Override
    public List<Delivery> getDeliveryByUser(User user) {
        return deliveryMapper.selectByUserId(user.getUserId());
    }

    @Override
    public Delivery getDeliveryByUserIdAndType(int userId, int type) {
        return deliveryMapper.selectByUserIdAndType(userId,type);
    }

    @Override
    public Delivery getDeliveryByDeliveryId(int deliveryId) {
        return deliveryMapper.selectByPrimaryKey(deliveryId);
    }

    @Override
    public int addDelivery(Delivery delivery) {
        return deliveryMapper.insertSelective(delivery);
    }

    @Override
    public int updateDelivery(Delivery delivery) {
        return deliveryMapper.updateByPrimaryKeySelective(delivery);
    }
}
