package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(foreignKeys = {
        @ForeignKey(entity = Pelatis.class,
                parentColumns = "id",
                childColumns = "pelatidId",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Proion.class,
                parentColumns = "id",
                childColumns = "proionId",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)
})
public class Polisi {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "proionId")
    private String proionId;
    @ColumnInfo(name = "pelatidId")
    private String pelatisId;
    @ColumnInfo(name = "apothema")
    private int apothema;

    public Polisi(@NonNull String id, String proionId, String pelatisId, int apothema) {
        this.id = id;
        this.proionId = proionId;
        this.pelatisId = pelatisId;
        this.apothema = apothema;
    }

    public String getId() {
        return id;
    }

    public String getProionId() {
        return proionId;
    }

    public String getPelatisId() {
        return pelatisId;
    }

    public int getApothema() {
        return apothema;
    }

    @Override
    public String toString() {
        return "Polisi{" +
                "id='" + id + '\'' +
                ", proionId='" + proionId + '\'' +
                ", pelatisId='" + pelatisId + '\'' +
                ", apothema='" + apothema + '\'' +
                '}';
    }

    public static Polisi create(String pelatisId, String proionId, int posotitaId){
        return new Polisi(UUID.randomUUID().toString(), proionId, pelatisId, posotitaId);
    }
}
