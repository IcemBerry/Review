package mapper;

import model.Delivery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryMapper {
    int deleteByPrimaryKey(Integer deliveryId);

    int insert(Delivery record);

    int insertSelective(Delivery record);

    Delivery selectByPrimaryKey(Integer deliveryId);

    List<Delivery> selectByUserId(Integer userId);

    Delivery selectByUserIdAndType(@Param("deliveryUserId") int deliveryUserId, @Param("deliveryType") int deliveryType);

    int updateByPrimaryKeySelective(Delivery record);

    int updateByPrimaryKey(Delivery record);
}