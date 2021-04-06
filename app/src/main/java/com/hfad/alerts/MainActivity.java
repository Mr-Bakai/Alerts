package com.hfad.alerts;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.alerts.dialog_language.adapters.GridSpacingItemDecoration;
import com.hfad.alerts.dialog_language.adapters.LangAdapter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button langBtn;
    private Button wellDoneBtn;
    private Button delete;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        langBtn = findViewById(R.id.langBtn);
        langBtn.setOnClickListener(v -> languageAlert());

        wellDoneBtn = findViewById(R.id.wellDoneBtn);
        wellDoneBtn.setOnClickListener(v -> wellDone());

        delete = findViewById(R.id.deleteBtn);
        delete.setOnClickListener(v ->  deletion());
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void deletion() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.delete_layout, null);

        Dialog alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.findViewById(R.id.yesBtn).setOnClickListener(v -> {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        });

        alertDialog.findViewById(R.id.noBtn).setOnClickListener(v -> {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        });

        alertDialog.show();
    }
    
    @RequiresApi(api = Build.VERSION_CODES.R)
    private void wellDone() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.well_done_layout, null);

        Dialog alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        
        alertDialog.findViewById(R.id.claimBtn).setOnClickListener(v -> {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        });
        alertDialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void languageAlert() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.lang_layout, null);

        Dialog alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        RecyclerView recyclerView;

        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.generateDefaultLayoutParams();

        List<String> cities = List.of(
                "English", "Русский", "Кыргызча", "Казакча", "German",
                "English", "Русский", "Кыргызча", "Казакча", "German");

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(gridLayoutManager);
        
        recyclerView.setAdapter(new LangAdapter(this, cities));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(45));
        alertDialog.show();
    }
}