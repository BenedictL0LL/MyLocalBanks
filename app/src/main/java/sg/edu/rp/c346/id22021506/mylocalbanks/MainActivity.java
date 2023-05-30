package sg.edu.rp.c346.id22021506.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView bank1;
    TextView bank2;
    TextView bank3;
    ToggleButton language;
    String wordClicked="";
    boolean isEnglish = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bank1 = findViewById(R.id.bank1);
        bank2 = findViewById(R.id.bank2);
        bank3 = findViewById(R.id.bank3);
        language = findViewById(R.id.language);

        registerForContextMenu(bank1);
        registerForContextMenu(bank2);
        registerForContextMenu(bank3);

        language.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchToChinese();
                } else {
                    switchToEnglish();
                }
            }
        });
    }
    private void switchToChinese() {
        bank1.setText("星展银行");
        bank2.setText("华侨银行");
        bank3.setText("大华银行");
        isEnglish = false;
        Toast.makeText(this, "Language switched to Chinese", Toast.LENGTH_SHORT).show();
    }

    private void switchToEnglish() {
        bank1.setText("DBS");
        bank2.setText("OCBC");
        bank3.setText("UOB");
        isEnglish = true;
        Toast.makeText(this, "Language switched to English", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact The Bank");

        if (v==bank1)
        {
            wordClicked="dbs";
        }else if (v==bank2)
        {
            wordClicked="ocbc";
        }else if (v==bank3)
        {
            wordClicked="uob";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800111111));
                startActivity(intentcall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc"))
        {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800363333));
                startActivity(intentcall);
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("uob"))
        {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800222212));
                startActivity(intentcall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}







