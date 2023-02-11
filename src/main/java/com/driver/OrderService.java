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
        orderRepository.addPartner(id);
    }

    public void addPair(String orderId ,String partnerId){

        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }
    public Order getOrderById(String id){

        return orderRepository.getOrderById(id) ;
    }
    public DeliveryPartner getDeliveryParnterById(String id){
        return
                orderRepository.getPartnerById(id) ;
    }

    public int getOrderCountByPartnerId(String partnerId){
        return orderRepository.getOrderCountByPartnerId(partnerId) ;
    }

    public List<String> getAllOrder(){
        return orderRepository.getAllOrders() ;
    }
    public void deletePartnerById(String id){

        orderRepository.deletePartner(id);
    }

    public void deleteOrderById(String id){
        orderRepository.deleteOrder(id) ;
    }


    public List<String> getOrdersByPartnerId(String id){
        return orderRepository.getOrdersByPartnerId(id) ;

    }

    public int getCountOfUnassignedOrders(){
        return orderRepository.getCountOfUnassignedOrders() ;
    }

    public int getCountForLeftOrdersLeftAfterTime(String time , String parternId){
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(time,parternId) ;
    }

    public String getLastDeliveryTime(String partnerId){
        return orderRepository.getLastDeliveryTimeByPartnerId(partnerId) ;
    }
}
