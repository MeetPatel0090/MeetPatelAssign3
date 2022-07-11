package meet.patel.n01460090.a3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MeetFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meet, container, false);



        EditText password = view.findViewById(R.id.MeetPassword);
        Button btn = view.findViewById(R.id.MeetButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(password.length() < 4)
                {
                    Snackbar snackbar = Snackbar.make(v, getString(R.string.PasswordError), Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

                else
                {
                    Snackbar snackbar = Snackbar.make(v, getString(R.string.PassDataMessage), Snackbar.LENGTH_SHORT);
                    snackbar.show();

                    String pwd = password.getText().toString();

                    Bundle result = new Bundle();
                    result.putString(getString(R.string.Passed_String),pwd);
                    getParentFragmentManager().setFragmentResult(getString(R.string.Passed_String),result);

                }
            }
        });
        return view;
    }
}