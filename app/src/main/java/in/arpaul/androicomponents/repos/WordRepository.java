package in.arpaul.androicomponents.repos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import in.arpaul.androicomponents.dao.WordDao;
import in.arpaul.androicomponents.dataaccess.WordRoomDatabase;
import in.arpaul.androicomponents.models.WordDO;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<WordDO>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<WordDO>> getAllWords() {
        return mAllWords;
    }

    /**
     * Perfom in a non-UI thread
     */
    public void insert (WordDO word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<WordDO, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordDO... params) {
//            for (int i = 0; i < params.length; i++)
//                mAsyncTaskDao.insert(params[i]);
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
