package Project.StockMarket;


import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public  class Main {
    static Scanner sc= new Scanner(System.in);
    static HashMap<String,Stock> map=new HashMap<>();
    static HashMap<String ,String> account=new HashMap<>();
    static Stock[] stocks=new Stock[50];
    public static void market(){

        stocks[0]= new Stock(140.20,30.51,30.51,184201);
        map.put("IRFC",stocks[0]);

        stocks[1]=new Stock(151.80,0.0,0.78,189687);
        map.put("TATASTEEL",stocks[1]);

        stocks[2]=new Stock(85.05,22.99,9.98,85433);
        map.put("NHPC",stocks[2]);

        stocks[3]=new Stock(2197.80,39.02,11.59,29753);
        map.put("BSE",stocks[3]);

        stocks[4]=new Stock(288.80,11.02,14.57,6608);
        map.put("KRBL",stocks[4]);

        stocks[5]=new Stock(119.70,11.27,12.58,15880);
        map.put("CESC",stocks[5]);

        stocks[6]=new Stock(26.30,0.0,-12.28,10012);
        map.put("RPOWER",stocks[6]);

        stocks[7]=new Stock(11.790,0.0,11.94,298);
        map.put("RELCAPITAL",stocks[7]);

        stocks[8]=new Stock(979.80,16.78,28.58,358539);
        map.put("TATAMOTERS",stocks[8]);

        stocks[9]=new Stock(390.70,34.88,11.85,124842);
        map.put("TATAPOWER",stocks[9]);

        stocks[10]=new Stock(3910.90,31.56,44.35,1415794);
        map.put("TCS",stocks[10]);

        stocks[11]=new Stock(2910.05,28.14,9.12,1968748);
        map.put("RELIANCE",stocks[11]);

        stocks[13]=new Stock(135.85,35.39,37.57,12118);
        map.put("IEX",stocks[13]);

        stocks[14]=new Stock(277.35,0.0,-12.45,10979);
        map.put("RELINFRA",stocks[14]);

        stocks[15]=new Stock(23.90,66.42,2.51,68780);
        map.put("YESBANK",stocks[15]);

        stocks[16]=new Stock(746.70,10.44,18.25,666133);
        map.put("SBIN",stocks[16]);

        stocks[17]=new Stock(1501,80.81,12.89,150276);
        map.put("SBILIFE",stocks[17]);

        stocks[18]=new Stock(704.10,28.60,20.82,66977);
        map.put("SBICARD",stocks[18]);

        stocks[19]=new Stock(81.35,16.35,12.96,87385);
        map.put("IDBI",stocks[19]);

        stocks[20]=new Stock(1442.85,18.57,13.50,1096155);
        map.put("HDFCBANK",stocks[20]);



    }

    public static void main(String[] args) {
        market();
        Account p1=new Account();

        while (true){
            System.out.println("Press 1 -> New Account \nPress 2 -> Existing Account \nPress 0 -> Exit Program");
            System.out.println("Enter Your Choice ");
            int c=sc.nextInt();
            boolean exists=false;
            if(c==1){

                createAccount(p1);
                exists=true;
            } else if (c==2) {
                exists = checkAccount();
                if(exists==false){
                    System.out.println("No Account Found");
                    break;
                }
            }
            else{
                break;
            }
            if(exists==true){

                while(exists==true){
                    System.out.println("Press 1 -> Stock Details");
                    System.out.println("Press 2 -> View Balance");
                    System.out.println("Press 3 -> Deposit Money");
                    System.out.println("Press 4 -> Withdraw Money");
                    System.out.println("Press 5 -> To Buy Stock");
                    System.out.println("Press 6 -> To Sell Stock");
                    System.out.println("Press 7 -> Know Your Portfolio");
                    System.out.println("Press 8 -> Check Your Transactions History");
                    System.out.println("Press 0 -> Log Out");

                    int c1=sc.nextInt();
                    if(c1==1) {
                        String str;
                        System.out.println("Enter Company Symbol");
                        str = sc.next();
                        ViewStockDetails(str.toUpperCase());
                    } else if (c1==2) {
                        ViewBalance(p1);
                    }
                    else if(c1==3) {
                        System.out.println("Enter Amount for Deposit");
                        double b = sc.nextDouble();
                        DepositMoney(p1, b);
                    }
                    else if(c1==4) {
                        System.out.println("Enter Amount to Withdrew");
                        double b1 = sc.nextDouble();
                        WithdrawMoney(p1, b1);
                    }
                    else if(c1==5) {
                        buyStock(p1);
                    }
                    else if(c1==6) {
                        sellStock(p1);
                    }
                    else if(c1==7) {
                        knowyourPortfolio(p1);
                    } else if (c1==8) {
                        transcationHistory(p1);

                    } else if(c1==0) {
                        exists=false;
                        System.out.println("Log Out successfully");
                    }
                    else {
                        System.out.println("Enter valid Details");
                    }


                }
            }
        }





    }
    public static void ViewStockDetails(String s){

        if(map.containsKey(s)){
            System.out.println("Details of "+s);
            Stock temp=new Stock();
            temp=map.get(s);
            temp.Details();
        }
        else{
            System.out.println("Data not found!!");
        }
    }
    public static void createAccount(Account p1){
        System.out.println("Enter ID");
        String id= sc.next();
        System.out.println("Enter Password");
        String pass=sc.next();
        p1.setId(id);
        p1.setPassword(pass);
        account.put(id,pass);
        //return true;
    }
    public static boolean checkAccount(){
        System.out.println("Enter ID");
        String id= sc.next();
        if(account.containsKey(id)){
            return true;
        }
        return false;
    }

    public static void DepositMoney(Account p1,double b){
        p1.updateBalance(b);
        p1.transaction.add(b);
        System.out.println("Transaction Success Full");
    }
    public static void WithdrawMoney(Account p1, double b ){
        p1.updateBalance(-b);
        p1.transaction.add(-b);
        System.out.println("Transaction Success Full");
    }
    public static void ViewBalance(Account p1){

        System.out.println("Your Balance is:- "+p1.getBalance());
    }
    public static void buyStock(Account p1){
        System.out.println("Enter Stock to Buy");
        String stk= sc.next();
        stk=stk.toUpperCase();
        ViewStockDetails(stk);
        System.out.println("Press 1 -> To Buy Stock\nPress Any  -> To Return");
        int c;
        c=sc.nextInt();
        if(c==1){
            System.out.println("Enter Quantity ");
            int q=sc.nextInt();
            if(map.containsKey(stk)){
                Stock temp= map.get(stk);
                if(q*temp.Price <= p1.getBalance()){
                    addinPortfolio(p1,q,stk,temp.Price);
                    System.out.println("Transaction Completed");
                }
                else{
                    System.out.println("Sorry!!\nBalance Low");
                }
            }
        }
        else{
            return;
        }
    }
    public static void addinPortfolio(Account p1,int q,String s,double Price){
        if(p1.port.containsKey(s)){
            p1.port.put(s,p1.port.get(s)+q);
        }
        else{
            p1.port.put(s,q);
        }
        p1.updateBalance(-q*Price);
        p1.transaction.add(-q*Price);
    }

    public static void sellStock(Account p1){
        System.out.println("Enter Stock to sell ");
        String str=sc.next();
        str=str.toUpperCase();
        if(p1.port.containsKey(str)){
            ViewStockDetails(str);
            System.out.println("Stocks of "+str+" "+p1.port.get(str));
            System.out.println("Press 1 ->Sell Stock\nPress 0->Return");
            int c=sc.nextInt();
            if(c==1){
                System.out.println("Enter Quantity to sell");
                int q=sc.nextInt();
                if(p1.port.get(str)>=q){
                    Stock temp=map.get(str);
                    p1.transaction.add(temp.getPrice()*q);
                    removeinportfolio(p1,q,str,temp.Price);

                }
                else{
                    System.out.println("You don't have this much quantity of stocks ");
                }
            }
            else {
                return;
            }

        }
        else{
            System.out.println("You didn't have this stock");
        }

    }
    public static void removeinportfolio(Account p1,int q,String str,double p){
        p1.port.put(str,p1.port.get(str)-q);
        p1.updateBalance(+p*q);
        if(p1.port.get(str)==0){
            p1.port.remove(str);
        }

    }

    public static void knowyourPortfolio(Account p1){
        System.out.println("Customer Id "+p1.getId());
        Set<String> keys= p1.port.keySet();
        for(String key:keys){
            System.out.println(key+"->"+p1.port.get(key));
        }

    }

    public static void transcationHistory(Account p1){
        for(int i=0;i<p1.transaction.size();i++){
            System.out.println(p1.transaction.get(i));
        }

    }

    public static void account(){
        Account p1=new Account();
        p1.setId("Abhi123");
        p1.setPassword("12345");
    }
}
