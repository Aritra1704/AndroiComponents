package in.arpaul.androicomponents.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import in.arpaul.androicomponents.models.UserDO;

@Dao
public interface UserDao {

    @Query("SELECT * FROM userdo")
    List<UserDO> getAll();

    @Query("SELECT * FROM userdo WHERE id IN (:userIds)")
    List<UserDO> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM userdo WHERE fName LIKE :first AND " + "lName LIKE :last LIMIT 1")
    UserDO findByName(String first, String last);

    @Insert
    void insertAll(UserDO... users);

    @Update
    int update(UserDO user);

    @Delete
    void delete(UserDO user);
}
