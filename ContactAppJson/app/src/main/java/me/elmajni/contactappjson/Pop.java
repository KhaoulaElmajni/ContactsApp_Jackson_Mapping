package me.elmajni.contactappjson;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Pop extends Activity {
    private Button call;
    private TextView name,job, email,phone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_profile);
        setAllViews();

        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));
        job.setText(bundle.getString("job"));
        phone.setText(bundle.getString("phone"));
        email.setText(bundle.getString("email"));
    }

    private void setAllViews() {
        name = findViewById(R.id.name);
        job = findViewById(R.id.job);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
    }

    public void makeCall(View view) {
        setAllViews();
        call = findViewById(R.id.call);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phone.getText()));
        startActivity(intent);
    }
}
