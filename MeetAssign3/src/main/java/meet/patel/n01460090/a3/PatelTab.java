// Meet Patel N01460090 Section:- RNB

package meet.patel.n01460090.a3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class PatelTab extends Fragment {

    private CanvasView canvasView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_patel, container, false);

        // The code for the Bitmap Image and Thumbnail is in CanvasView.java File

        canvasView = view.findViewById(R.id.MeetCanvas);

        ImageButton imgBtn = view.findViewById(R.id.MeetImageButton);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasView.resetDrawing();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.meet_canvas_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        // Handle item selection
        switch (menuitem.getItemId())
        {
            case R.id.MeetCanvasWidth14:
                canvasView.setStrokeWidth(14f);
                break;

            case R.id.MeetCanvasWidth18:
                canvasView.setStrokeWidth(18f);
                break;

            case R.id.MeetCanvasWidth22:
                canvasView.setStrokeWidth(22f);
                break;

            case R.id.MeetCanvasColourPink:
                canvasView.setStrokeColor(getString(R.string.PinkColorMenu));
                break;

            case R.id.MeetCanvasColourGreen:
                canvasView.setStrokeColor(getString(R.string.GreenColorMenu));
                break;

            case R.id.MeetCanvasColourRed:
                canvasView.setStrokeColor(getString(R.string.RedColorMenu));
                break;

            default:
                return super.onOptionsItemSelected(menuitem);
        }
        return true;

    }
}