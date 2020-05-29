package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Proion {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "perigrafi")
    private String perigrafi;
    @ColumnInfo(name = "kostos")
    private double kostos;
    @ColumnInfo(name = "apothema")
    private int apothema;
    @ColumnInfo(name = "type")
    private int type;

    public Proion(@NonNull String id, String name, String perigrafi, double kostos, int apothema, int type) {
        this.id = id;
        this.name = name;
        this.perigrafi = perigrafi;
        this.kostos = kostos;
        this.apothema = apothema;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPerigrafi() {
        return perigrafi;
    }

    public String getId() {
        return id;
    }

    public int getApothema() {
        return apothema;
    }

    public double getKostos() {
        return kostos;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Proion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", perigrafi='" + perigrafi + '\'' +
                ", kostos=" + kostos +
                ", apothema=" + apothema +
                ", type=" + type +
                '}';
    }
}
