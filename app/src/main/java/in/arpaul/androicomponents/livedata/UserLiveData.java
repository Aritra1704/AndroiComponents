package in.arpaul.androicomponents.livedata;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;

import in.arpaul.androicomponents.common.SampleListener;
import in.arpaul.androicomponents.common.UserListener;
import in.arpaul.androicomponents.models.UserDO;

/**
 * Created by aritrapal on 24/05/18.
 */

public class UserLiveData extends LiveData<UserDO> {

    private static UserLiveData sInstance;

    private UserListener mlistener = new UserListener() {

        @Override
        public void onDataChange(UserDO user) {
            setValue(user);
        }
    };

    public UserLiveData(UserDO data) {
        mlistener.onDataChange(data);
//        mStockManager = new StockManager(symbol);
    }

    @MainThread
    public static UserLiveData get(UserDO data) {
        if (sInstance == null) {
            sInstance = new UserLiveData(data);
        }
        return sInstance;
    }

    @Override
    protected void onActive() {
        super.onActive();
//        mStockManager.requestPriceUpdates(mListener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
//        mStockManager.removeUpdates(mListener);
    }
}
