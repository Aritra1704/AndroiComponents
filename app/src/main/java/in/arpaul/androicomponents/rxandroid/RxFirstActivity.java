package in.arpaul.androicomponents.rxandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.arpaul.androicomponents.R;

public class RxFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_first);

        ((Button) findViewById(R.id.btnActivit1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RxFirstActivity.this, RxAndroidActivity1.class));
            }
        });

        ((Button) findViewById(R.id.btnActivit2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RxFirstActivity.this, RxAndroidActivity2.class));
            }
        });
    }
}
