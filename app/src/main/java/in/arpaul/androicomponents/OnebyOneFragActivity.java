package in.arpaul.androicomponents;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import in.arpaul.androicomponents.fragments.DetailFragment;
import in.arpaul.androicomponents.fragments.FirstFragment;
import in.arpaul.androicomponents.fragments.MasterFragment;
import in.arpaul.androicomponents.fragments.SecondFragment;
import in.arpaul.androicomponents.models.UserDO;

public class OnebyOneFragActivity extends AppCompatActivity implements FirstFragment.OnBtnClickListener, SecondFragment.OnBackClickListener {

//    private FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneby_one_frag);

//        container = (FrameLayout) findViewById(R.id.flFrag);

        showFirstFrag();
    }

    private void showFirstFrag(){

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        FirstFragment trackFragment = new FirstFragment();

        Bundle bundle = new Bundle();
//        bundle.putSerializable("DATA",data);
        trackFragment.setArguments(bundle);

//        fragTransaction.add(R.id.flcontainer, tourFragment);
        fragTransaction.replace(R.id.flFrag, trackFragment);
        fragTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragTransaction.addToBackStack(null);
        fragTransaction.commit();
    }

    private void showSecondFrag(){

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        SecondFragment trackFragment = new SecondFragment();

        Bundle bundle = new Bundle();
//        bundle.putSerializable("DATA", item);
        trackFragment.setArguments(bundle);

//        fragTransaction.add(R.id.flcontainer, tourFragment);
        fragTransaction.replace(R.id.flFrag, trackFragment);
        fragTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragTransaction.addToBackStack(null);
        fragTransaction.commit();
    }

    @Override
    public void onClickInteraction() {
        showSecondFrag();
    }

    @Override
    public void onBackClick() {
        showFirstFrag();
    }
}
