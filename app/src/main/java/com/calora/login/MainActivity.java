package com.calora.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.util.TypedValue;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.UUID;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.CheckBox;
import android.os.Build;
import android.widget.CompoundButton;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;

public class MainActivity extends Activity {
	
	public String sGameActivity = "uk.lgl.modmenu.MainActivity";
	
    public String PASS = "PASS";
    public String USER = "USER";
    public EditText mPass;
    public EditText mUsername;
    public Prefs prefs;
	
	private native String Dialog();
	private native String Team();
	private native String Credits();
	private native String YTURL();
	

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        System.loadLibrary("SecurityCalora");
        alertaVendedores();
    }

    public final void alertaVendedores() {
        Builder Alerta = new Builder(this);
       
           
            String Titulo = ("Aviso!");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#123868"));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Titulo);
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, Titulo.length(), 33);
            Alerta.setTitle(spannableStringBuilder);
            String Mensagem = Dialog();
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-65536);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(Mensagem);
            spannableStringBuilder2.setSpan(foregroundColorSpan2, 0, Mensagem.length(), 33);
            Alerta.setMessage(spannableStringBuilder2);
            Alerta.setCancelable(false);
            Alerta.setPositiveButton("Ok", new OnClickListener() {
					public void onClick(DialogInterface dialog, int i) {
						dialog.cancel();
						MainActivity.this.TryLoginPHP();
					}
				});
        
        Alerta.create().show();
    }

    @SuppressLint({"SetTextI18n", "RtlHardcoded"})
    public final void TryLoginPHP() {
       
        RelativeLayout relative = new RelativeLayout(this);
        relative.setLayoutParams(new LayoutParams(-1, -1));
        relative.setGravity(17);
        GradientDrawable gd = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-12777012, -16777216});
        gd.setCornerRadius(0.0f);
        relative.setBackground(gd);
        LinearLayout main = new LinearLayout(this);
        LinearLayout.LayoutParams mainParam = new LinearLayout.LayoutParams(-1, -2);
        main.setLayoutParams(mainParam);
        main.setGravity(17);
        main.setOrientation(1);
        main.setPadding(30, 30, 30, 30);
        main.setBackgroundColor(0);
        TextView newMod = new TextView(this);
        newMod.setText(Team());
        newMod.setTextSize(26.0f);
        newMod.setTextColor(-1);
        newMod.setGravity(17);
        newMod.setPadding(0, 10, 0, 10);
        newMod.setBackgroundColor(0);
        main.addView(newMod);
        this.prefs = Prefs.with(this);
        String sUser = "";
        byte[] bUser = Base64.decode(sUser, 0);
        Drawable dUser = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bUser, 0, bUser.length));
        this.mUsername = new EditText(this);
        String str = "";
        this.mUsername.setText(this.prefs.read(this.USER, str));
        this.mUsername.setHint("Usuario");
		this.mUsername.setTextColor(Color.WHITE);
        this.mUsername.setCompoundDrawablesWithIntrinsicBounds(dUser, null, null, null);
        main.addView(this.mUsername);
        byte[] bPwd = Base64.decode("", 0);
        Drawable dPwd = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bPwd, 0, bPwd.length));
        this.mPass = new EditText(this);
        this.mPass.setText(this.prefs.read(this.PASS, str));
        this.mPass.setHint("Senha");
		this.mPass.setTextColor(Color.WHITE);
        this.mPass.setInputType(129);
        this.mPass.setCompoundDrawablesWithIntrinsicBounds(dPwd, null, null, null);
        main.addView(this.mPass);
		CheckBox mostrarSenha = new CheckBox(this);
        mostrarSenha.setTextColor(-16777216);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        }
		mostrarSenha.setText("Show Password");
		mostrarSenha.setTextColor(Color.WHITE);
        mostrarSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
					if (z) {
						mPass.setTransformationMethod(new SingleLineTransformationMethod());
					} else {
						mPass.setTransformationMethod(new PasswordTransformationMethod());
					}
				}
			});
		
        main.addView(mostrarSenha);
		GradientDrawable LoginDrawable = new GradientDrawable();
		TextView errorMsg = new TextView(this);
        errorMsg.setTextColor(-65536);
        errorMsg.setGravity(17);
        errorMsg.setVisibility(8);
		errorMsg.setText("Incorrect Username or Password");
        Button init = new Button(this);
        RelativeLayout.LayoutParams btnLoginLayout = new LayoutParams(-2, dp(50));
        btnLoginLayout.rightMargin = dp(5);
        init.setText("Entrar");
		init.setLayoutParams(btnLoginLayout);
        init.setTextColor(Color.WHITE);
		init.setPadding(dp(2), dp(2), dp(2), dp(2));
        init.setGravity(17);
        init.setBackground(LoginDrawable);
		init.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        init.setTextSize((float) dp(10));
        init.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					String Usuario = MainActivity.this.mUsername.getText().toString().trim();
					String Senha = MainActivity.this.mPass.getText().toString().trim();
					if (Usuario.isEmpty() || Senha.isEmpty()) {
						Context context = MainActivity.this;
						
						return;
					}
					MainActivity.this.prefs.write(MainActivity.this.USER, Usuario);
					MainActivity.this.prefs.write(MainActivity.this.PASS, Senha);
					new Auth(MainActivity.this).execute(new String[]{Usuario, Senha, MainActivity.rdStr()});
				}
			});
		main.addView(errorMsg);
        main.addView(init);
        TextView credits = new TextView(this);
        credits.setText(Credits());
        credits.setTextColor(-1);
        credits.setBackgroundColor(0);
        credits.setGravity(81);
        credits.setPadding(0, 40, 0, 0);
        main.addView(credits);
        relative.addView(main);
        setContentView(relative);
    }
	
	public final int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public static String rdStr() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

