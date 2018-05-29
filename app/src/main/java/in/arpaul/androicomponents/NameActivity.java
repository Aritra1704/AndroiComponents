package in.arpaul.androicomponents;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.arpaul.androicomponents.fragments.DetailFragment;
import in.arpaul.androicomponents.fragments.MasterFragment;
import in.arpaul.androicomponents.fragments.SampleFragment;
import in.arpaul.androicomponents.models.UserDO;

public class NameActivity extends AppCompatActivity implements MasterFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        showMasterFrag("Aritra");
        showDetailFrag("Pal");
    }

    private void showMasterFrag(final String data){

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        MasterFragment trackFragment = new MasterFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA",data);
        trackFragment.setArguments(bundle);

//        fragTransaction.add(R.id.flcontainer, tourFragment);
        fragTransaction.replace(R.id.flMaster, trackFragment);
        fragTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragTransaction.addToBackStack(null);
        fragTransaction.commit();
    }

    private void showDetailFrag(final String data){

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        DetailFragment trackFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA",data);
        trackFragment.setArguments(bundle);

//        fragTransaction.add(R.id.flcontainer, tourFragment);
        fragTransaction.replace(R.id.flDetail, trackFragment);
        fragTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragTransaction.addToBackStack(null);
        fragTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(UserDO item) {

    }
}
