///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pat.utils;
//
//import com.restaurant.pojo.Book;
//import java.math.BigDecimal;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// *
// * @author HP
// */
//public class Utils {
//
//    public static Map<String, BigDecimal> bookStats(Map<Integer, Book> book) {
//        BigDecimal priceService = new BigDecimal(0);
//        BigDecimal priceEvent = new BigDecimal(0);
//        BigDecimal total = new BigDecimal(0);
//        if (book != null) {
//            for (Book b: book.values()) {
//                priceService = b.getPriceService();
//                priceEvent = b.getPriceEvent();
//                total = priceEvent.add(priceService);
//            }
//        }
//        
//        Map<String, BigDecimal> re = new HashMap<>();
//        re.put("total", total);
////        re.put("totalService", new BigDecimal());
//        
//        return re;
//
//    }
//}
