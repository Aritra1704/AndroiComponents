package in.arpaul.androicomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import in.arpaul.androicomponents.models.UserDO;

/**
 * Created by aritrapal on 28/05/18.
 */

public class UserVM extends ViewModel {
    private MutableLiveData<List<UserDO>> users;
    public LiveData<List<UserDO>> getUsers() {
        if(users == null) {
            users = new MutableLiveData<List<UserDO>>();
            loadUsers();
        }

        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
