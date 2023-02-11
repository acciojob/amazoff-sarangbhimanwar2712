package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap<String ,Order> orderMap = new HashMap<>() ;
    HashMap<String,DeliveryPartner> partnerMap = new HashMap<>() ;  //id,noOfOrder

    HashMap<String,List<String>> pair = new HashMap<>() ; //partner id , List<String> of order

    public void addOrder (Order order){
        String id = order.getId() ;
        orderMap.put(id,order) ;
    }

    public void addDeliveryPartner(String id){
        if(!partnerMap.containsKey(id)){
            partnerMap.put(id,new DeliveryPartner(id,1))  ;
        }
        else{
            int noOfOrder = getDeliveryPartnerById(id).getNumberOfOrders();
            partnerMap.put(id , new DeliveryPartner(id,noOfOrder+1)) ;
        }

    }

    public void addPair(String orderId ,String partnerId){
        if(orderMap.containsKey(orderId) && partnerMap.containsKey(partnerId)){
            if(pair.containsKey(partnerId)){
                pair.get(partnerId).add(orderId) ;
            }else{
                List<String> arr = new ArrayList<>() ;
                arr.add(orderId) ;
                pair.put(partnerId,arr) ;
            }
        }
    }

    public Order getOrderById(String Id) {
        return orderMap.get(Id);
    }

    public DeliveryPartner getDeliveryPartnerById(String id){
        return partnerMap.get(id) ;
    }

    public int getOrderCountByParnterId(String partnerId){
        int count = getDeliveryPartnerById(partnerId).getNumberOfOrders() ;
        return count ;
    }

    public List<String> getOrdersByPartnerId(String id){
        List<String> order = new ArrayList<>() ;

        if(pair.containsKey(id)){
            order =pair.get(id) ;
        }
        return order ;
    }

    public List<String> getAllOrders(){
        List<String> orders = new ArrayList<>() ;
        for(String s : orderMap.keySet()){
            orders.add(s) ;
        }
        return orders ;
    }

    public void deleteParnterById(String id){
        if(partnerMap.containsKey(id)){
            if(pair.containsKey(id)){
                pair.remove(id) ;
            }
            partnerMap.remove(id) ;
        }
    }

    public void deleteOrderById(String id){
        if(orderMap.containsKey(id)){
            orderMap.remove(id) ;
        }
    }
}
