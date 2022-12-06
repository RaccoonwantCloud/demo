package com.fcshop.study.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupComponentLocalMain {

    public static void getWeatherList(){
        // 크롤링 할 페이지 불러오기
        final String weatherList = "https://weather.naver.com/today/09680531?cpName=KMA";
        Connection conn = Jsoup.connect(weatherList);

        try {
            Document document = conn.get();
            // 이곳에 불러올 데이터 함수 만들어서 불러오기
            String weatherLocationDiv = getWeatherLocation(document);
            String weatherHeader = getWeatherHeader(document);
            String weatherBody = getWeatherBody(document);
            System.out.println(weatherLocationDiv);
            System.out.println(weatherHeader);
            System.out.println(weatherBody);
        } catch ( IOException ioException){
            System.out.println("오류");
        }
    }
    // weather 위치 가져오기
    public static String getWeatherLocation(Document document){
        //불러올 특정 Div 선택
        Elements weatherLocationDiv = document.select("div.location_area");
        StringBuilder sb = new StringBuilder();
        for (Element element: weatherLocationDiv) {
           for(Element span: element.select("span")){
               sb.append(span.text());
               sb.append(" ");
           }
           Elements strong = element.select("strong");
           sb.append(strong.text());
           break;
        }
        return sb.toString();
    }

    public static String getWeatherHeader(Document document){
        //불러올 특정 Div 선택
        Elements weatherLocationDiv = document.select("div.weather_table_wrap table thead tr");
        StringBuilder sb = new StringBuilder();
        for (Element element: weatherLocationDiv) {
            for(Element th: element.select("th")){
                sb.append(" ");
                sb.append(th.text());
                sb.append("|");

            }
            break;
        }
        return sb.toString();
    }

    public static String getWeatherBody(Document document){
        //불러올 특정 Div 선택
        Elements weatherLocationDiv = document.select("div.weather_table_wrap table tbody tr");
        StringBuilder sb = new StringBuilder();
        for (Element element: weatherLocationDiv) {
            for(Element td: element.select("td")){
                sb.append(" ");
                sb.append(td);
                sb.append("|");

            }
            break;
        }
        return sb.toString();
    }


    public static void main(String[] args){
        getWeatherList();
    }


}
