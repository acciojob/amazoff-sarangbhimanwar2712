package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository ;

    public void addOrder(Order order){
        orderRepository.addOrder(order);
    }

    public void addDeliveyPartner(String id){
        orderRepository.addDeliveryPartner(id);
    }

    public void addPair(String orderId ,String partnerId){
        orderRepository.addPair(orderId,partnerId);
    }
    public Order getOrderById(String id){
         return orderRepository.getOrderById(id) ;
    }
    public DeliveryPartner getDeliveryParnterById(String id){
        return orderRepository.getDeliveryPartnerById(id) ;
    }

    public int getOrderCountByPartnerId(String partnerId){
        return orderRepository.getOrderCountByParnterId(partnerId) ;
    }

    public List<String> getAllOrder(){
        return orderRepository.getAllOrders() ;
    }
    public void deletePartnerById(String id){
       orderRepository.deleteParnterById(id);
    }

    public void deleteOrderById(String id){
        orderRepository.deleteOrderById(id) ;
    }


    public List<String> getOrdersByPartnerId(String id){
        return orderRepository.getOrdersByPartnerId(id) ;
    }
}
