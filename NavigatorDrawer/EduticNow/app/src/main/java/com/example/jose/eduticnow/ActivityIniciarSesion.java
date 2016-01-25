package com.example.jose.eduticnow;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityIniciarSesion extends AppCompatActivity {

    String cWhite = "#FFFFFFFF";
    String cMagenta = "#FF36BDC5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity_iniciar_sesion);

        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Relative Layout General
        RelativeLayout rlayoutG = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rlayoutG.setLayoutParams(params);
        rlayoutG.setBackgroundResource(R.drawable.afondo);

        LinearLayout.LayoutParams paramsLY = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        //Linear Layout sub-General
        LinearLayout layouSG = new LinearLayout(this);
        layouSG.setOrientation(LinearLayout.VERTICAL);
        layouSG.setLayoutParams(paramsLY);
        layouSG.setPadding(dptopx(35),dptopx(600),dptopx(35),dptopx(35));

        //Text View Login
        TextView textLogin = new TextView(this);
        textLogin.setText("Iniciar Sesión");
        textLogin.setTextColor(Color.parseColor(cWhite));
        textLogin.setTextSize(dptopx(18));
        layouSG.addView(textLogin);

        //Edit Text User
        final EditText editUsername = new EditText(this);
        editUsername.setHint("Usuario");
        editUsername.setBackgroundColor(Color.parseColor("#E0E0E0"));
        editUsername.getBackground().setAlpha(40);
        editUsername.setTextSize(dptopx(18));
        editUsername.setTextColor(Color.parseColor(cWhite));
        layouSG.addView(editUsername);

        //Edit Text PassWord
        EditText editPass = new EditText(this);
        editPass.setHint("Contraseña");
        editPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editPass.setBackgroundColor(Color.parseColor("#E0E0E0"));
        editPass.getBackground().setAlpha(40);
        editPass.setTextSize(dptopx(18));
        editPass.setTextColor(Color.parseColor(cWhite));
        layouSG.addView(editPass);

        //Linear Layout Botton, Change Pass
        LinearLayout layoutBtn = new LinearLayout(this);
        layoutBtn.setOrientation(LinearLayout.HORIZONTAL);
        layoutBtn.setLayoutParams(paramsLY);
        layoutBtn.setPadding(0, dptopx(50), 0, dptopx(10));
        layoutBtn.setGravity(Gravity.CENTER_HORIZONTAL);
        layoutBtn.setWeightSum(10);

        //Buttom Login
        Button btnLogin = new Button(this);
        btnLogin.setText("LOGIN");
        btnLogin.setTextColor(Color.parseColor(cWhite));
        btnLogin.setBackgroundColor(Color.parseColor(cMagenta));
        btnLogin.setTextSize(dptopx(20));
        LinearLayout.LayoutParams paramsbtn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        paramsbtn.weight = 5;
        paramsbtn.width = 0;
        btnLogin.setLayoutParams(paramsbtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goActitityNavigator(editUsername);
            }
        });
        layoutBtn.addView(btnLogin);

        layouSG.addView(layoutBtn);

        //LINEAR LAYOUT CHANGE
        LinearLayout layoutChange = new LinearLayout(this);
        layoutChange.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams paramslyChange = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        layoutChange.setLayoutParams(paramslyChange);
        layoutChange.setPadding(dptopx(20), 0, 0, 0);
        layoutChange.setGravity(Gravity.CENTER_HORIZONTAL);
        //layoutChange.setWeightSum(8);

        LinearLayout.LayoutParams paramslyF = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        /*paramslyF.weight = 4;
        paramslyF.height = 0;*/
        //Text View Forgot
        TextView textForgot = new TextView(this);
        textForgot.setText("FORGOT PASSWORD?");
        textForgot.setTextColor(Color.parseColor(cWhite));
        textForgot.setTextSize(dptopx(15));
        textForgot.setLayoutParams(paramslyF);
        layoutChange.addView(textForgot);

        //Text View Change
        TextView textChange = new TextView(this);
        textChange.setText("CHANGE");
        textForgot.setTextSize(dptopx(15));
        textChange.setLayoutParams(paramslyF);
        textChange.setTextColor(Color.parseColor(cMagenta));
        layoutChange.addView(textChange);

        layoutBtn.addView(layoutChange);

        rlayoutG.addView(layouSG);

        setContentView(rlayoutG);
    }

    //Convert dp to pixel
    public int dptopx(int dp){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
        return  px;
    }

    //Go to other activity : ActivityIniciarSesion
    public void goActitityNavigator(EditText ET){
        Toast mss = Toast.makeText(getApplicationContext(),"Cargando Perfil de " + ET.getText(),Toast.LENGTH_SHORT);
        mss.show();
        Intent myIntent = new Intent(ActivityIniciarSesion.this, NavigatorActivity.class);
        myIntent.putExtra("pk_username",ET.getText());//Paso de datos de un activity a otro
        ActivityIniciarSesion.this.startActivity(myIntent);
    }
}
