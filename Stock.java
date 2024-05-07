package Project.StockMarket;

import java.util.HashMap;

public class Stock {
    double Price;
    double PERatio;
    double ROE;
    long MarketCap;

    Stock(double price,double pe,double roe,long mc){
        Price=price;
        PERatio=pe;
        ROE=roe;
        MarketCap=mc;
    }
    Stock(){

    }

    double getPrice(){
        return Price;
    }
    double getPERatio(){
        return PERatio;
    }
    double getROE(){
        return ROE;
    }
    long getMarketCap(){
        return MarketCap;
    }
    void setPrice(double p){
        Price=p;
    }
    void setPERatio(double p){
        PERatio=p;
    }
    void setROE(double p){
        ROE=p;
    }
    void setMarketCap(long m){
        MarketCap=m;
    }

    void Details(){
        System.out.println("MarketCap:- "+MarketCap+"Cr");
        System.out.println("Price :- "+Price);
        System.out.println("PERatio :- "+PERatio);
        System.out.println("ROE :- "+ROE+"%");
    }

}
