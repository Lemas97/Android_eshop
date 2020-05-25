package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "cost")
    private double cost;
    @ColumnInfo(name = "remaining")
    private int remaining;
    @ColumnInfo(name = "type")
    private int type;

    public Product(@NonNull String id, String name, String description, double cost, int remaining, int type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.remaining = remaining;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public int getRemaining() {
        return remaining;
    }

    public double getCost() {
        return cost;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", remaining=" + remaining +
                ", type="  + type +
                '}';
    }
}
