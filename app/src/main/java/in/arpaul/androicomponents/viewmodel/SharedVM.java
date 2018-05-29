package in.arpaul.androicomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import in.arpaul.androicomponents.models.UserDO;

/**
 * Created by aritrapal on 28/05/18.
 */

public class SharedVM extends ViewModel {

    private final MutableLiveData<UserDO> selected = new MutableLiveData<UserDO>();

    public void select(UserDO user) {
        selected.setValue(user);
    }

    public LiveData<UserDO> getSelected() {
        return selected;
    }
}
