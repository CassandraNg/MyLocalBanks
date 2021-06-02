package sg.edu.rp.c346.id20017476.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView ivDBS, ivOCBC, ivUOB;
    TextView tvDBS, tvOCBC, tvUOB;
    String select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivDBS = findViewById(R.id.imageViewDBS);
        ivOCBC = findViewById(R.id.imageViewOCBC);
        ivUOB = findViewById(R.id.imageViewUOB);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
        registerForContextMenu(ivDBS);
        registerForContextMenu(ivOCBC);
        registerForContextMenu(ivUOB);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.englishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        } else if (item.getItemId() == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");


        if(v == tvDBS){
            select = "DBS";
        }else if (v == tvOCBC){
            select = "OCBC";
        } else if(v == tvUOB){
            select = "UOB";
        }else if (v == ivDBS){
            select = "DBS";
        } else if(v == ivOCBC){
            select = "OCBC";
        }else if(v == ivUOB){
            select = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0){
            if (select.equalsIgnoreCase("DBS")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);
            } else if (select.equalsIgnoreCase("OCBC")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);
            }else if (select.equalsIgnoreCase("UOB")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);
            }
        } else if (item.getItemId() == 1){
            if (select.equalsIgnoreCase("DBS")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18001111111"));
                startActivity(i);
            }else if (select.equalsIgnoreCase("OCBC")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18003633333"));
                startActivity(i);
            }else if (select.equalsIgnoreCase("UOB")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18002222121"));
                startActivity(i);
            }
        }else if(item.getItemId() == 2){
            if (select.equalsIgnoreCase("DBS")){
                if(tvDBS.getCurrentTextColor() == Color.RED){
                    tvDBS.setTextColor(Color.WHITE);
                }else{
                    tvDBS.setTextColor(Color.RED);
                }
            }else if (select.equalsIgnoreCase("OCBC")){
                if(tvOCBC.getCurrentTextColor() == Color.RED){
                    tvOCBC.setTextColor(Color.WHITE);
                }else{
                    tvOCBC.setTextColor(Color.RED);
                }
            }else if (select.equalsIgnoreCase("UOB")){
                if(tvUOB.getCurrentTextColor() == Color.RED){
                    tvUOB.setTextColor(Color.WHITE);
                }else{
                    tvUOB.setTextColor(Color.RED);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}