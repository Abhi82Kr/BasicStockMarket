package Project.StockMarket;

import java.util.*;

public class Account {
    private String id;
    private String password;
    private double Balance;
    ArrayList<Double> transaction= new ArrayList<>();
    HashMap<String ,Integer> port=new HashMap<>();

    Account(String i,String p){
        Balance=0;
        id=i;
        password=p;
    }
    Account(){
        Balance=0;
    }
    double getBalance(){
        return Balance;
    }
    String getPassword(){
        return password;
    }
    String getId(){
        return id;
    }
    void setBalance(double b){
        Balance=b;
    }
    void updateBalance(double b){
        Balance+=b;
    }
    void setId(String s){
        id=s;
    }
    void setPassword(String s){
        password=s;
    }
}



