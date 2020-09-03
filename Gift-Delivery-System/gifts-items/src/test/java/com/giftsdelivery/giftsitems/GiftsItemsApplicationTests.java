package com.giftsdelivery.giftsitems;

import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.model.Books;
import com.giftsdelivery.giftsitems.model.Saree;
import com.giftsdelivery.giftsitems.model.Shops_Details;
import com.giftsdelivery.giftsitems.model.Watch;
import com.giftsdelivery.giftsitems.repository.BooksRepository;
import com.giftsdelivery.giftsitems.repository.SareeRepository;
import com.giftsdelivery.giftsitems.repository.ShopRepository;
import com.giftsdelivery.giftsitems.repository.WatchRepository;
import com.giftsdelivery.giftsitems.service.BooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class GiftsItemsApplicationTests {

    @Autowired
    WatchRepository watchRepository;
    @Autowired
    SareeRepository sareeRepository;
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    BooksService booksService;

    @Test
    void contextLoads() {
    }

    @Test
    void createWatchItems(){
        Watch watch1 =new Watch(458, "Casio G-stock","Casio",20_000,"Black");
        Watch result = watchRepository.save(watch1);
        Assertions.assertEquals(watch1,result);
        Watch watch2 =new Watch(984,"Reflex 2.0 Activity Tracker","Fastrack",1680,"Black");
        Watch result2 = watchRepository.save(watch2);
        Assertions.assertEquals(watch2,result2);
        Watch watch3 =new Watch(579,"Analog Silver Dial Womens's Watch","Titan",2395,"Golden");
        Watch result3 = watchRepository.save(watch3);
        Assertions.assertEquals(watch3,result3);
        Watch watch4 =new Watch(346,"Gen 5 Julianna Stainless Steel Touchscreen Smartwatch","Fossil",22_995,"White");
        Watch result4 = watchRepository.save(watch4);

        System.out.println(result4);

    }

    @Test
    void createSareeItems(){
        Saree saree1 =new Saree(1247,  "Banarasi Art Silk Saree ",12_350,"Banarasi","Baby Pink");
        Saree result = sareeRepository.save(saree1);
        Assertions.assertEquals(saree1,result);
        Saree saree2 =new Saree(1498,"Chiffon Saree",3890,"Chiffon","Lime");
        Saree result2 = sareeRepository.save(saree2);
        Assertions.assertEquals(saree2,result2);
        Saree saree3 =new Saree(579,"Color Art Silk Printed Saree",4500,"Silk ","Multi color");
        Saree result3 = sareeRepository.save(saree3);
        Assertions.assertEquals(saree3,result3);
        Saree saree4 =new Saree(346,"Blend Linen Saree",2850,"Linen","White and Black");
        Saree result4 = sareeRepository.save(saree4);

        System.out.println(result4);

    }
    @Test
    void createBookItems(){

        Books book3 =new Books(689,"The Day of the Jackal","Frederick Forsyth","G.P. Putnam's Sons","English Thrillers",1785);
        Books result3 = booksRepository.save(book3);
        Assertions.assertEquals(book3,result3);
        System.out.println(result3);
        Books book4 =new Books(127,"The World In My Hands","Kazi. Anis Ahmed","Random House","Fiction",538);
        Books result4 = booksRepository.save(book4);
        Assertions.assertEquals(book4,result4);
        System.out.println(result4);

        Books expected = new Books(131,"The World In My Hands","Kazi. Anis Ahmed","Random House","Fiction",538);
        try {
            Books result = booksService.create(expected);
            Assertions.assertEquals(expected, result);
        } catch (ResourceAlreadyExistsException e) {
            Assertions.assertEquals(new ResourceAlreadyExistsException().toString(), e.toString());
            System.out.println(e.toString());
        }

    }

    @Test
    void createShops(){

        Shops_Details shops_details1 =new Shops_Details(898,"All in one rooftop"," KA-244, Kuril, Progoti Shoroni, Dhaka");

        Books books1 = new Books(238,"This Is Me","Thomas Charlie","Random House","personal",897.58);
        booksRepository.save(books1);
        shops_details1.addBook(books1);

        Books books2 = new Books(88,"Uponnas Somogro-16 by Humayun Ahmed","Humayun Ahmed","Annesha","Uponnas",600);
        booksRepository.save(books2);
        shops_details1.addBook(books2);


        Shops_Details savedShop_Details1 = shopRepository.save(shops_details1);
        Optional<Books> storedBook2 = booksRepository.findById(689);
        if(storedBook2.isPresent()){
            shops_details1.addBook(storedBook2.get());
        }



//        Shops_Details shops_details2 =new Shops_Details(597,"Find All Here"," 9A-658, Middle Badda, Dhaka");

//        Shops_Details savedShop_Details2 = shopRepository.save(shops_details2);

//        System.out.println(savedShop_Details2);



    }





}
