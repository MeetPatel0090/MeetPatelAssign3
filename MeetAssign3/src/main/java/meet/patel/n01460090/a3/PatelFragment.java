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


public class PatelFragment extends Fragment {

    private CanvasView canvasView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patel, container, false);
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.canvas_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        // Handle item selection
        switch (menuitem.getItemId())
        {
            case R.id.MeetCanvasWidth6:
                canvasView.setStrokeWidth(6f);
                break;

            case R.id.MeetCanvasWidth8:
                canvasView.setStrokeWidth(8f);
                break;

            case R.id.MeetCanvasWidth10:
                canvasView.setStrokeWidth(10f);
                break;

            case R.id.MeetCanvasColourBlue:
                canvasView.setStrokeColor("Blue");
                break;

            case R.id.MeetCanvasColourGreen:
                canvasView.setStrokeColor("Green");
                break;

            case R.id.MeetCanvasColourRed:
                canvasView.setStrokeColor("Red");
                break;

            default:
                return super.onOptionsItemSelected(menuitem);
        }
        return true;

    }


}