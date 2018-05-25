package in.arpaul.androicomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import in.arpaul.androicomponents.livedata.NameViewModel;
import in.arpaul.androicomponents.livedata.SampleLiveData;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, SampleFragment.OnFragmentInteractionListener {

    private LifecycleRegistry lifeRegistry;
    private NameViewModel mModel;

    private TextView tvName;
    private Button btnTest;

    public static final String FRAGMENT_TRACK = "FRAGMENT_TRACK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifeRegistry = new LifecycleRegistry(this);
        lifeRegistry.markState(Lifecycle.State.CREATED);

        // Other code to setup the activity...
        tvName = (TextView) findViewById(R.id.tvName);
        btnTest = (Button) findViewById(R.id.btnTest);
        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(NameViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                tvName.setText(newName);
            }
        };

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anotherName = "John Doe";
                mModel.getCurrentName().setValue(anotherName);
            }
        });

        LiveData<String> mLiveData = new SampleLiveData("Aritra");
        mLiveData.observe(this, data -> {
            Toast.makeText(this, "Data: " + data, Toast.LENGTH_SHORT).show();
        });

        showFragment("Aritra");
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this, nameObserver);
    }

    private void showFragment(final String data){

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        SampleFragment trackFragment = new SampleFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA",data);
        trackFragment.setArguments(bundle);

//        fragTransaction.add(R.id.flcontainer, tourFragment);
        fragTransaction.replace(R.id.flcontainer, trackFragment);
        fragTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragTransaction.addToBackStack(FRAGMENT_TRACK);
        fragTransaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        lifeRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifeRegistry.markState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifeRegistry.markState(Lifecycle.State.DESTROYED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifeRegistry;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
