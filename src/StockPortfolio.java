public class StockPortfolio {
    private int sharePrice;
    private String shareName;
    private int numberOfShare;

    public StockPortfolio( int sharePrice, String shareName, int numberOfShare ) {
        this.sharePrice = sharePrice;
        this.shareName = shareName;
        this.numberOfShare = numberOfShare;
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public int getNumberOfShare() {
        return numberOfShare;
    }

    public void setNumberOfShare(int numberOfShare) {
        this.numberOfShare = numberOfShare;
    }

    @Override
    public String toString() {
        return "StockPortfolio{" +
                "sharePrice=" + sharePrice +
                ", shareName='" + shareName + '\'' +
                ", numberOfShare=" + numberOfShare +
                '}';
    }
}
