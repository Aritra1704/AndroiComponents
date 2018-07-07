package in.arpaul.androicomponents.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class WordDO {

//    @PrimaryKey(autoGenerate = true)
//    private int id;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public WordDO(@NonNull String word) {
        this.mWord = word;
    }

    public String getWord(){
        return this.mWord;
    }
}
