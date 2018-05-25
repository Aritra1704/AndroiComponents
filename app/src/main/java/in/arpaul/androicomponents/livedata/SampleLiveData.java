package in.arpaul.androicomponents.livedata;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;

import in.arpaul.androicomponents.common.SampleListener;

/**
 * Created by aritrapal on 24/05/18.
 */

public class SampleLiveData extends LiveData<String> {

    private static SampleLiveData sInstance;

    private SampleListener mlistener = new SampleListener() {
        @Override
        public void onDataChange(String change) {
            setValue(change + "1");
        }
    };

    public SampleLiveData(String data) {
        mlistener.onDataChange(data);
//        mStockManager = new StockManager(symbol);
    }

    @MainThread
    public static SampleLiveData get(String data) {
        if (sInstance == null) {
            sInstance = new SampleLiveData(data);
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
