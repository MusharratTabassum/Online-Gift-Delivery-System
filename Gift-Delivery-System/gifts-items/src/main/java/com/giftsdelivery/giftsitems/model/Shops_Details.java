package com.giftsdelivery.giftsitems.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shops_Details {
    @Id
    private int shop_no;
    private String shop_name;
    private String location;
    @ManyToMany
    private List<Books>booksList;
//    @ManyToMany
//    private List<Watch>watchList;
//    @ManyToMany
//    private List<Saree>sareeList;

    public Shops_Details(int shop_no,String shop_name,String location)
    {
        this.shop_no=shop_no;
        this.shop_name=shop_name;
        this.location=location;

    }
    public void addBook(Books books)
    {
        if(booksList==null)
            booksList=new ArrayList<>();

        booksList.add(books);
    }
//    public void addWatch(Watch watch)
//    {
//        if(watchList==null)
//            watchList=new ArrayList<>();
//
//         watchList.add(watch);
//    }
//    public void addSaree(Saree saree)
//    {
//       if(sareeList==null)
//           sareeList=new ArrayList<>();
//
//        sareeList.add(saree);
//    }





}
