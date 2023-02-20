import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class StockServices {
    ArrayList<StockPortfolio> stockList = new ArrayList<>();
    ArrayList<String> purchaseHistory = new ArrayList<>();

    StockPortfolio stocks;
    Scanner sc = new Scanner(System.in);

    public void addStock(){

        System.out.println("Enter Share Name");
        String shareName = sc.next();

        System.out.println("Enter Number Of Shares Bought");
        int numberOfShare = sc.nextInt();

        System.out.println("Enter The Stock Price");
        int sharePrice = sc.nextInt();

        stocks = new StockPortfolio(sharePrice,shareName,numberOfShare);
        stockList.add(stocks);
        String stockAdd = "Stock Name : "+ shareName + " , Stock Added On : " + time() + " , Per Stock Price : " +sharePrice+ " , Number Of Share : " + numberOfShare;
        purchaseHistory.add(stockAdd);
    }

    public void stockReport(){

        int sum = 0;
        for (StockPortfolio stock : stockList){
            sum += stock.getNumberOfShare()*stock.getSharePrice();
        }
        System.out.println(stockList);
        System.out.println("Total Stock Bought : " +sum);
    }

    public void eachStockValue(){

        for(StockPortfolio stock : stockList){

            int eachValue = stock.getNumberOfShare() * stock.getSharePrice();
            System.out.println("Stock Name : " + stock.getShareName() +" "+ "Total Value : "+eachValue);
        }
    }

    public boolean debit(int noOfShare,String nameOsStock){

        for (int i = 0 ; i < stockList.size(); i++){
            if(stockList.get(i) != null && stockList.get(i).getShareName().equalsIgnoreCase(nameOsStock) &&  noOfShare < stockList.get(i).getNumberOfShare()){

                int credited = noOfShare * stockList.get(i).getSharePrice();
                stockList.get(i).setNumberOfShare(stockList.get(i).getNumberOfShare() - noOfShare);
                System.out.println("Shares Sold : " + noOfShare +" "+"Date And Time : " + time());
                System.out.println("credit Amount to Account : " +credited);
                String sellHistory = "Stock Name : " + stockList.get(i).getShareName() + " , Shares Sold : " + noOfShare + " , Date And Time : " + time();
                purchaseHistory.add(sellHistory);
                return true;
            }

        }
        return false;
    }

    public boolean credit(int noOfShare,String nameOsStock){

        for (int i = 0 ; i < stockList.size(); i++){
            if(stockList.get(i) != null && stockList.get(i).getShareName().equalsIgnoreCase(nameOsStock)){

                int debited = noOfShare * stockList.get(i).getSharePrice();
                stockList.get(i).setNumberOfShare(stockList.get(i).getNumberOfShare() + noOfShare);
                System.out.println("Shares Bought : " + noOfShare +" "+"Date And Time : " + time());
                System.out.println("Amount debited from account : " + debited);
                String buyHistory = "Stock Name : " + stockList.get(i).getShareName() + " , Shares Bought : " + noOfShare + " , Date And Time : " + time();
                purchaseHistory.add(buyHistory);
                return true;
            }

        }
        return false;
    }

    public void purchaseHistory() {

        for (int i = 0; i < purchaseHistory.size(); i++) {
            if (purchaseHistory.get(i) != null) {
                System.out.println(purchaseHistory.get(i));
            }
        }
    }

    public String time(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date);
    }
    public void stockbuyMethod(){
        System.out.println("Enter How Many Stock You Want To Buy: ");
        int noOfShare = sc.nextInt();
        System.out.println("Enter The Stock Name: ");
        String nameOfShare = sc.next();
        boolean update = credit(noOfShare,nameOfShare);
        if(update){
            System.out.println("Shares Credited Successfully");
        }
        else {
            System.out.println("Stock Not Present in Your Portfolio || Check Stock Name");
        }

    }

    public void stockSellMethod(){
        System.out.println("Enter How Many Stock You Want To Sell: ");
        int noOfShare = sc.nextInt();
        System.out.println("Enter The Stock Name: ");
        String nameOfShare = sc.next();
        boolean update = debit(noOfShare,nameOfShare);
        if(update){
            System.out.println("Shares sold Successfully");
        }
        else {
            System.out.println("Stocks Are Not Present in Your Portfolio");
        }
    }
}
