package com.giftsdelivery.order_info;

import com.giftsdelivery.order_info.exception.ResourceAlreadyExistsException;
import com.giftsdelivery.order_info.model.DeliveryMan;
import com.giftsdelivery.order_info.model.OrderDetail;
import com.giftsdelivery.order_info.repository.DeliverymanRepository;
import com.giftsdelivery.order_info.repository.OrderdetailsRepository;
import com.giftsdelivery.order_info.service.OrderdetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class OrderInfoApplicationTests {

    @Autowired
    OrderdetailsService orderdetailsService;
    @Autowired
    DeliverymanRepository deliverymanRepository;
    @Autowired
    OrderdetailsRepository orderdetailsRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void orderCreateTest(){
//        OrderDetail orderDetail = new OrderDetail(1234,
//                3550.00, 98765321,
//                "TestCust", "Banani, Dhaka",
//                LocalDate.of(2020, 6, 5), 0214254);
//
//
//        try {
//            OrderDetail result = orderdetailsService.create(orderDetail);
//            System.out.println(result.toString());
//        } catch (ResourceAlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }

    }
    @Test
    void createDeliveryman(){

        DeliveryMan deliveryMan =new DeliveryMan(2024,"Selim Khan",01556L);
       OrderDetail orderDetail1 =new OrderDetail(12264,
               3650.00, 987655641,
               "TestCust", "Mirpur, Dhaka",
               LocalDate.of(2020, 6, 5), 0214254);
       orderdetailsRepository.save(orderDetail1);
        deliveryMan.addOrderDeliveryInfo(orderDetail1);
        DeliveryMan savedDelivery_Details1 = deliverymanRepository.save(deliveryMan);

        System.out.println(savedDelivery_Details1);
        OrderDetail orderDetail2 =new OrderDetail(37264,
                5080.00, 574522454,
                "TestCust2", "Mirpur, Dhaka",
                LocalDate.of(2020, 6, 15), 054157);
        orderdetailsRepository.save(orderDetail2);
        deliveryMan.addOrderDeliveryInfo(orderDetail2);
        DeliveryMan savedDelivery_Details2 = deliverymanRepository.save(deliveryMan);

        System.out.println(savedDelivery_Details2);
        OrderDetail orderDetail3 =new OrderDetail(954264,
                2080.00, 454522454,
                "TestCust3", "Shiddheshwari, Dhaka",
                LocalDate.of(2020, 6, 15), 0454157);
        orderdetailsRepository.save(orderDetail3);
        deliveryMan.addOrderDeliveryInfo(orderDetail3);
        DeliveryMan savedDelivery_Details3 = deliverymanRepository.save(deliveryMan);

        System.out.println(savedDelivery_Details3);


        DeliveryMan deliveryMan2 =new DeliveryMan(2025,"Habul",57556L);
        DeliveryMan savedDelivery_Details4 = deliverymanRepository.save(deliveryMan2);

        System.out.println(savedDelivery_Details4);




    }


}
