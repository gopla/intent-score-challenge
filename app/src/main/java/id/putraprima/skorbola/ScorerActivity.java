package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScorerActivity extends AppCompatActivity {
    private EditText playerName;
    private boolean isHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);

        playerName = findViewById(R.id.editText);
        Bundle bundle = getIntent().getExtras();
        isHome = bundle.getBoolean("isHome");
    }

    public void handlePlayerName(View view) {
        String name = playerName.getText().toString();
        if(!name.isEmpty()){
            Intent i = new Intent();
            if (isHome){
                i.putExtra("homeScorer", name);
                setResult(1, i);
            }else{
                i.putExtra("awayScorer", name);
                setResult(2, i);
            }
            finish();
        }else{
            Toast.makeText(this, "Fill player name!", Toast.LENGTH_SHORT).show();
        }
    }
}
