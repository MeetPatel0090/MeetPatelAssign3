package meet.patel.n01460090.a3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MeetActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    MeetFragment meetFragment = new MeetFragment();
    PatelFragment patelFragment = new PatelFragment();
    N01460090Fragment n01460090Fragment = new N01460090Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        Toolbar toolbar = findViewById(R.id.MeetToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar();

        getSupportFragmentManager().beginTransaction().replace(R.id.MeetFrameLayout,meetFragment).commit();

        bottomNavigationView = findViewById(R.id.MeetBottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.MeetBottomMenuItem1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MeetFrameLayout,meetFragment).commit();
                        return true;

                    case R.id.MeetBottomMenuItem2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MeetFrameLayout,patelFragment).commit();
                        return true;

                    case R.id.MeetBottomMenuItem3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MeetFrameLayout,n01460090Fragment).commit();
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(R.string.ExitConfirmation);
        builder.setTitle(R.string.ExitAlertTitle);
        builder.setPositiveButton(R.string.ExitYes, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
        builder.setNegativeButton(R.string.ExitNo,new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meet_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        // Handle item selection
        if (menuitem.getItemId() == R.id.MeetMenuItem1)
        {
            gotoCamera();
        }
        else
        {
                return super.onOptionsItemSelected(menuitem);
        }
        return true;
    }


    public void gotoCamera(){

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);

    }
}
