package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pelatis {

    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "address")
    private String diefthinsi;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "telephoneNumber")
    private String tilifono;

    public Pelatis(@NonNull String id, String name, String diefthinsi, String email, String tilifono) {
        this.id = id;
        this.name = name;
        this.diefthinsi = diefthinsi;
        this.email = email;
        this.tilifono = tilifono;
    }

    public String getEmail() {
        return email;
    }

    public String getTilifono() {
        return tilifono;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiefthinsi() {
        return diefthinsi;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pelatis{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", diefthinsi='" + diefthinsi + '\'' +
                ", email='" + email + '\'' +
                ", tilifono='" + tilifono + '\'' +
                '}';
    }


}
