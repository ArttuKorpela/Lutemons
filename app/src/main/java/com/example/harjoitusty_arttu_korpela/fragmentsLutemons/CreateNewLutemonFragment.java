package com.example.harjoitusty_arttu_korpela.fragmentsLutemons;

import static com.example.harjoitusty_arttu_korpela.R.layout.fragment_create_new_lutemon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.harjoitusty_arttu_korpela.FragmentUpdater;
import com.example.harjoitusty_arttu_korpela.Home;
import com.example.harjoitusty_arttu_korpela.R;


public class CreateNewLutemonFragment extends Fragment{
    RadioGroup rgLutemons;
    EditText nickname;
    TextView kelabucks;
    Button addNewLutemon;

    FragmentUpdater fragmentUpdater;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUpdater = new ViewModelProvider(requireActivity()).get(FragmentUpdater.class);

        fragmentUpdater.getValue().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                kelabucks.setText(Integer.toString(Home.getInstance().getKela_bucks()));
            }

        });

        View view = inflater.inflate(fragment_create_new_lutemon, container, false);
        rgLutemons = view.findViewById(R.id.rgNewLutemon);
        nickname = view.findViewById(R.id.editTextNickname);
        kelabucks = view.findViewById(R.id.textViewKelaBucks);
        addNewLutemon = view.findViewById(R.id.btnNewLutemon);

        //kelabucks counter
        kelabucks.setText(Integer.toString(Home.getInstance().getKela_bucks()));

        addNewLutemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (rgLutemons.getCheckedRadioButtonId()) {

                    case R.id.rbMegabyte:
                        Home.getInstance().createLutemon(nickname.getText().toString(),"Cluster");
                        break;
                    case R.id.rbAmpere:
                        Home.getInstance().createLutemon(nickname.getText().toString(),"Satky");
                        break;
                    case R.id.rbDividend:
                        Home.getInstance().createLutemon(nickname.getText().toString(),"Enklaavi");
                        break;
                    case R.id.rbBussCard:
                        Home.getInstance().createLutemon(nickname.getText().toString(),"Pelletti");
                        break;
                    case R.id.rbMoped:
                        Home.getInstance().createLutemon(nickname.getText().toString(),"KRK");
                        break;
                    default:
                        System.out.println("Mistake in CreateNewLutemonFragment");
                }
                fragmentUpdater.update();


            }
        });







        return view;
    }

}