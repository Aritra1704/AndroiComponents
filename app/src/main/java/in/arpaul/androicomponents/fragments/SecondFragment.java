package in.arpaul.androicomponents.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import in.arpaul.androicomponents.R;
import in.arpaul.androicomponents.viewmodel.SharedVM;

public class SecondFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private TextView tvFname, tvLname;
    private Button btnBack;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String param1) {
        SecondFragment fragment = new SecondFragment();
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
            tvFname.setText(item.fName);
            tvLname.setText(item.lName);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvFname = (TextView) view.findViewById(R.id.tvFname);
        tvLname = (TextView) view.findViewById(R.id.tvLname);
        btnBack = (Button) view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onBackClick();
            }
        });
        return view;
    }

    private OnBackClickListener mListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackClickListener) {
            mListener = (OnBackClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnBackClickListener");
        }
    }

    public interface OnBackClickListener {
        void onBackClick();
    }
}
