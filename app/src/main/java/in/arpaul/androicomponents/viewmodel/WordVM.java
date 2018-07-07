package in.arpaul.androicomponents.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import in.arpaul.androicomponents.models.WordDO;
import in.arpaul.androicomponents.repos.WordRepository;

public class WordVM extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<WordDO>> mAllWords;

    /**
     * Never pass context to the instances.
     * @param application
     */
    public WordVM (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<WordDO>> getAllWords() { return mAllWords; }

    public void insert(WordDO word) { mRepository.insert(word); }
}
