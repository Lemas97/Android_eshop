package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Polisi {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "proionId")
    private String proionId;
    @ColumnInfo(name = "pelatidId")
    private String pelatisId;
    @ColumnInfo(name = "posotita")
    private int posotita;

    public Polisi(@NonNull String id, String proionId, String pelatisId, int posotita) {
        this.id = id;
        this.proionId = proionId;
        this.pelatisId = pelatisId;
        this.posotita = posotita;
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

    public int getPosotita() {
        return posotita;
    }

    @Override
    public String toString() {
        return "Polisi{" +
                "id='" + id + '\'' +
                ", proionId='" + proionId + '\'' +
                ", pelatisId='" + pelatisId + '\'' +
                ", posotita='" + posotita + '\'' +
                '}';
    }

    public static Polisi create(String pelatisId, String proionId, int posotitaId){
        return new Polisi(UUID.randomUUID().toString(), proionId, pelatisId, posotitaId);
    }
}
