package sg.edu.rp.c346.p10_ps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    Button btnChange;
    TextView tv;

    int tap = 1;


    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        btnChange = getView().findViewById(R.id.btnChange);
        tv = getView().findViewById(R.id.tv);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tap % 2 == 0) {
                    tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                } else {
                    tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                tap++;
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

}
