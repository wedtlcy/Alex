package drools;

/**
 * @author chuanyin.li
 * @create 2019-01-24 15:19
 **/
import java.math.BigDecimal;

public class ItemCity {
    public enum City {
        SHENZHEN, GUANGZHOU
    }

    public enum Type {
        GROCERIES, MEDICINES, WATCHES, LUXURYGOODS
    }

    private City purchaseCity;
    private BigDecimal sellPrice;
    private Type typeofItem;
    private BigDecimal localTax;

    public City getPurchaseCity() {
        return purchaseCity;
    }

    public void setPurchaseCity(City purchaseCity) {
        this.purchaseCity = purchaseCity;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Type getTypeofItem() {
        return typeofItem;
    }

    public void setTypeofItem(Type typeofItem) {
        this.typeofItem = typeofItem;
    }

    public BigDecimal getLocalTax() {
        return localTax;
    }

    public void setLocalTax(BigDecimal localTax) {
        this.localTax = localTax;
    }
}
