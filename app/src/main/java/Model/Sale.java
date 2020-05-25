package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(foreignKeys = {
        @ForeignKey(entity = Customer.class,
                parentColumns = "id",
                childColumns = "customerId",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Product.class,
                parentColumns = "id",
                childColumns = "productId",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)
})
public class Sale {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "productId")
    private String productId;
    @ColumnInfo(name = "customerId")
    private String customerId;
    @ColumnInfo(name = "quantity")
    private int quantity;

    public Sale(@NonNull String id, String productId, String customerId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id='" + id + '\'' +
                ", productid='" + productId + '\'' +
                ", customerid='" + customerId + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public static Sale create(String customerId, String productId, int quantity){
        String id = UUID.randomUUID().toString();


        return new Sale(id, productId, customerId, quantity);
    }
}
