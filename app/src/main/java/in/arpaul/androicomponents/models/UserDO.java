package in.arpaul.androicomponents.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by aritrapal on 25/05/18.
 */
@Entity
public class UserDO implements Serializable {

    @NonNull
    @PrimaryKey
    public String id = "";

    @ColumnInfo(name = "fName")
    public String fName = "";

    @ColumnInfo(name = "lName")
    public String lName = "";

    public UserDO() {}

    public UserDO (String id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlName() {
        return lName;
    }
}
