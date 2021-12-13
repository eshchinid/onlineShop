package ru.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Product {
    private Integer id;
    private Integer counter = 0;
    private String name;
    private String description;
    private Integer price;
    private ProductCategory productCategory;
    private Date date;

    private void nextId() {
        this.id=counter++;
    }

    private void addProduct (String name, String description, Integer price, ProductCategory productCategory) {
        this.name=name;
        this.description=description;
        this.price=price;
        setProductCategory(productCategory);
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Product (String name, String description, Integer price, ProductCategory productCategory) {
        nextId();
        addProduct(name, description, price, productCategory);
        this.date = new Date();
    }


//    public Product (String name){
//        this.name = name;
//        this.date= new Date();
//    }

//    public static String getTime() {
//        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//        Date now = new Date();
//        String strDate = sdfDate.format(now);
//        return strDate;
//    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Наименование='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", Цена=" + price +
                ", Категория=" + productCategory +
                ", Дата=" + date +
                '}';
    }
}
