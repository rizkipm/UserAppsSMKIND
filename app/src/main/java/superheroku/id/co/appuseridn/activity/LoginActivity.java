package superheroku.id.co.appuseridn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import superheroku.id.co.appuseridn.MainActivity;
import superheroku.id.co.appuseridn.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnLupaPasswordLogin)
    TextView btnLupaPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogin, R.id.btnLupaPasswordLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                Intent a1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(a1);
                finish();
                break;

            case R.id.btnLupaPasswordLogin:
//                Intent a3 = new Intent(getApplicationContext(), DaftarActivity.class);
//                startActivity(a3);

                break;
        }
    }



}
