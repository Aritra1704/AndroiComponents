package in.arpaul.androicomponents.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.arpaul.androicomponents.R;
import in.arpaul.androicomponents.viewmodel.SharedVM;

public class DetailFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private TextView tvDetail;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

        SharedVM model = ViewModelProviders.of(getActivity()).get(SharedVM.class);
        model.getSelected().observe(this, item -> {
            tvDetail.setText(item.fName + " " + item.lName);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvDetail = (TextView) view.findViewById(R.id.tvDetail);
        return view;
    }

}
