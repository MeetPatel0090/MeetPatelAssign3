// Meet Patel N01460090 Section:- RNB

package meet.patel.n01460090.a3;

import static android.Manifest.*;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class N01460090Tab extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_n01460090, container, false);

        TextView textView = view.findViewById(R.id.MeetTextViewFirstNameThirdFrag);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        getParentFragmentManager().setFragmentResultListener(getString(R.string.Passed_String), this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String pwd = result.getString(getString(R.string.Passed_String));
                TextView textView1 = view.findViewById(R.id.MeetTextViewPassedDataThirdFrag);
                textView1.setText(pwd);
            }
        });

        Button button = view.findViewById(R.id.MeetMakeCallButtonThirdFrag);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

        return view;

    }


    public void call()
    {
        if (ContextCompat.checkSelfPermission(getActivity(),permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{permission.CALL_PHONE}, 1);
        }

        else
        {
            Uri uri = Uri.parse(getString(R.string.CallNumber));
            Intent intent = new Intent(Intent.ACTION_CALL,uri);
            startActivity(intent);
        }
    }


    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == 1){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                call();
            }
            else
            {
                Snackbar snackbar = Snackbar.make(getView(), getString(R.string.PermissionDenied), Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        }
    }

}