package in.arpaul.androicomponents.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import in.arpaul.androicomponents.R;
import in.arpaul.androicomponents.models.UserDO;
import in.arpaul.androicomponents.viewmodel.SharedVM;

public class FirstFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private EditText edtFname, edtLname;
    private Button btnNext;

    private SharedVM model;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1) {
        FirstFragment fragment = new FirstFragment();
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

        model = ViewModelProviders.of(getActivity()).get(SharedVM.class);
        model.getSelected().observe(this, item -> {
            user = item;
            edtFname.setText(item.fName);
            edtLname.setText(item.lName);
        });
//        SharedVM model = ViewModelProviders.of(getActivity()).get(SharedVM.class);
//        model.getSelected().observe(this, item -> {
//            tvDetail.setText(item.fName + " " + item.lName);
//        });
    }

    private UserDO user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        edtFname = (EditText) view.findViewById(R.id.edtFname);
        edtLname = (EditText) view.findViewById(R.id.edtLname);
        btnNext = (Button) view.findViewById(R.id.btnNext);

        if(user == null) {
            edtFname.setText("Aritra");
            edtLname.setText("Pal");
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = model.getSelected().getValue();

                if(user == null)
                    user = new UserDO();

                user.fName = edtFname.getText().toString();
                user.lName = edtLname.getText().toString();

                model.select(user);
                mListener.onClickInteraction();
            }
        });
        return view;
    }

    private OnBtnClickListener mListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBtnClickListener) {
            mListener = (OnBtnClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnBtnClickListener");
        }
    }

    public interface OnBtnClickListener {
        void onClickInteraction();
    }

}
