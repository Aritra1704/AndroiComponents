package in.arpaul.androicomponents.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import in.arpaul.androicomponents.R;
import in.arpaul.androicomponents.models.UserDO;
import in.arpaul.androicomponents.viewmodel.SharedVM;

public class Detail1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private EditText edtDetail;

    public Detail1Fragment() {
        // Required empty public constructor
    }

    public static Detail1Fragment newInstance(String param1) {
        Detail1Fragment fragment = new Detail1Fragment();
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
    }

    private UserDO user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail1, container, false);
        edtDetail = (EditText) view.findViewById(R.id.edtDetail);

        SharedVM model = ViewModelProviders.of(getActivity()).get(SharedVM.class);
        user = model.getSelected().getValue();
        model.getSelected().observe(this, item -> {
            user = item;
            edtDetail.setText(item.fName + " " + item.lName);
        });

        edtDetail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                user.lName = edtDetail.getText().toString();
//                model.select(user);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return view;
    }

}
