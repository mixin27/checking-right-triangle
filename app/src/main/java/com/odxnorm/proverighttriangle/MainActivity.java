package com.odxnorm.proverighttriangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Zayar Tun(ODxNorm) at 25/1/2019
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    EditText txt_point_one_x, txt_point_one_y;
    EditText txt_point_two_x, txt_point_two_y;
    EditText txt_point_three_x, txt_point_three_y;

    TextView tv_status;

    int[] a = null;
    int[] b = null;
    int[] c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_point_one_x = findViewById(R.id.txt_point_one_x);
        txt_point_one_y = findViewById(R.id.txt_point_one_y);

        txt_point_two_x = findViewById(R.id.txt_point_two_x);
        txt_point_two_y = findViewById(R.id.txt_point_two_y);

        txt_point_three_x = findViewById(R.id.txt_point_three_x);
        txt_point_three_y = findViewById(R.id.txt_point_three_y);

        tv_status = findViewById(R.id.tv_status);

    }

    public void btnIsRightTriangle(View view) {

        getPoints();

        // AB = [(bx-ax), (by-ay)]
        int[] ab = new int[] {
                b[0] - a[0],
                b[1] - a[1]
        };
        Log.d(TAG, "\nAB = [" + ab[0] + ", " + ab[1] + "]");


        // BC = [(cx-bx), (cy-by)]
        int[] bc = new int[] {
                c[0] - b[0],
                c[1] - b[1]
        };
        Log.d(TAG, "\nBC = [" + bc[0] + ", " + bc[1] + "]");

        // AC = [(cx-ax), (cy-ay)]
        int[] ac = new int[] {
                c[0] - a[0],
                c[1] - a[1]
        };
        Log.d(TAG, "\nAC = [" + ac[0] + ", " + ac[1] + "]");

        // AB.BC = [ABx, ABy].[BCx, BCy]
        int abbc = (ab[0] * bc[0]) + (ab[1] * bc[1]);
        Log.d(TAG, "AB.BC = " + abbc);

        // BC.AC = [BCx, BCy].[ACx, ACy]
        int bcac = (bc[0] * ac[0]) + (bc[1] * ac[1]);
        Log.d(TAG, "BC.AC = " + bcac);

        // AB.AC = [ABx, ABy].[ACx, ACy]
        int abac = (ab[0] * ac[0]) + (ab[1] * ac[1]);
        Log.d(TAG, "ABAC = " + abac);

        // Check AB.BC == 0 | BC.AC == 0 | AB.AC == 0
        if(isRightTriangle(abbc, bcac, abac)) {
            Log.d(TAG, "Right Triangle = true");
            tv_status.setText("Status : It is a right triangle.");
        } else {
            Log.d(TAG, "Right Triangle = false");
            tv_status.setText("Status : It is not a right triangle.");
        }

    }

    private boolean isRightTriangle(int abbc, int bcac, int abac) {
        return abbc == 0 || bcac == 0 ||abac == 0;
    }

    private void getPoints() {

        int ax, ay;
        int bx, by;
        int cx, cy;

        if (txt_point_one_x.getText().toString().isEmpty()) {
            txt_point_one_x.requestFocus();
            txt_point_one_x.setError("Required");
        }

        if (txt_point_one_y.getText().toString().isEmpty()) {
            txt_point_one_y.requestFocus();
            txt_point_one_y.setError("Required");
        }

        if (txt_point_two_x.getText().toString().isEmpty()) {
            txt_point_two_x.requestFocus();
            txt_point_two_x.setError("Required");
        }

        if (txt_point_two_y.getText().toString().isEmpty()) {
            txt_point_two_y.requestFocus();
            txt_point_two_y.setError("Required");
        }

        if (txt_point_three_x.getText().toString().isEmpty()) {
            txt_point_three_x.requestFocus();
            txt_point_three_x.setError("Required");
        }

        if (txt_point_three_y.getText().toString().isEmpty()) {
            txt_point_three_y.requestFocus();
            txt_point_three_y.setError("Required");
        }

        ax = strToInt(txt_point_one_x.getText().toString());
        ay = strToInt(txt_point_one_y.getText().toString());

        // set points x and y to A
        // A = (ax, ay)
        a = new int[] {
                ax, ay
        };
        Log.d(TAG, "\nAx = " + ax + "\nAy = " + ay);

        bx = strToInt(txt_point_two_x.getText().toString());
        by = strToInt(txt_point_two_y.getText().toString());

        // set points x and y to B
        // B = (bx, by)
        b = new int[] {
                bx, by
        };
        Log.d(TAG, "\nBx = " + bx + "\nBy = " + by);

        cx = strToInt(txt_point_three_x.getText().toString());
        cy = strToInt(txt_point_three_y.getText().toString());

        // set points x and y to C
        // C = (cx, cy)
        c = new int[] {
                cx, cy
        };
        Log.d(TAG, "\nCx = " + cx + "\nCy = " + cy);
    }

    private int strToInt(String value) {
        return Integer.parseInt(value);
    }
}
