package edu.miu.cs.cs489apsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489apsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {

    public static void main(String[] args) {

        Product product1 = new Product(3128874119L,"Banana", LocalDate.of(2023,01 ,24),125,0.55);
        Product product2 = new Product(2927458265L,"Apple",LocalDate.of(2022,12 ,9) ,18,1.09);
        Product product3 = new Product(9189927460L,"Carrot",LocalDate.of(2023,03,31),89,2.99);

        Product[] products = new Product[]{
                product1,product2,product3
        };


        // Sort the stream by name
        Arrays.sort(products, Comparator.comparing(Product::getName));


        printProducts(products);
    }




    public static void  printProducts(Product[] products){

        System.out.println("JSON-formatted list of all Products: ");

        for(Product p : products){

            System.out.println(p.toJSONString());

        }

        System.out.println("XML-formatted list of all Products: ");
        System.out.println("<Products>");
        for(Product p : products){
            System.out.println("  <product>");
            System.out.println("    <id>" + p.getProductId() + "</id>");
            System.out.println("    <name>" + p.getName() + "</name>");
            System.out.println("    <DateSupplied>" + p.getDateSupplied() + "</Date Supplied>");
            System.out.println("    <QuantityInStock>" + p.getQuantityInStock() + "</QuantityInStock>");
            System.out.println("    <UnitPrice>" + p.getUnitPrice() + "</UnitPrice>");
            System.out.println("  </product>");

        }
        System.out.println("</products>");



        System.out.println("Comma-Separated Values (CSV)-formatted list of all Products ");

        for (Product product : products) {
            System.out.println(product.getProductId() + "," + product.getName() + "," +
                     product.getDateSupplied() + "," +
                    product.getQuantityInStock() + "," +
                    product.getUnitPrice()


            );
        }


    }

}
