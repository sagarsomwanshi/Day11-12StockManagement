import java.util.Scanner;
public class StockManageMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockServices stocks = new StockServices();
        int input;

        do{
            System.out.println("\nEnter 1 to Add Stocks\nEnter 2 To Display Stocks\nEnter 3 To buy Shares\nEnter 4 To sell Stocks\nEnter 5 For Purchase History\nEnter 6 To close");

            input = sc.nextInt();

            switch(input){

                case 1:{

                    stocks.addStock();
                    break;

                }

                case 2:{

                    stocks.stockReport();
                    stocks.eachStockValue();
                    break;
                }

                case 3:{
                    stocks.stockbuyMethod();
                    break;
                }
                case 4: {
                    stocks.stockSellMethod();
                    break;
                }

                case 5:{
                    stocks.purchaseHistory();
                    break;
                }

                case 6:{

                    System.out.println("Closed");
                }

            }
        }while (input != 6);
    }
}
