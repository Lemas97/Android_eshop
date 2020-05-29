package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.UUID;

@Entity
public class Kalathi {

    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "proionId")
    private String proionId;
    @ColumnInfo(name = "posotita")
    private int posotita;


    public Kalathi(@NonNull String id, String proionId, int posotita) {
        this.id = id;
        this.proionId = proionId;
        this.posotita = posotita;
    }



    @NonNull
    public String getId() {
        return id;
    }

    public String getProionId() {
        return proionId;
    }

    public int getPosotita() {
        return posotita;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setProionId(String proionId) {
        this.proionId = proionId;
    }

    public void setPosotita(int posotita) {
        this.posotita = posotita;
    }

    @Override
    public String toString() {
        return "Kalathi{" +
                "id='" + id + '\'' +
                ", proionId='" + proionId + '\'' +
                ", posotita=" + posotita +
                '}';
    }
}
