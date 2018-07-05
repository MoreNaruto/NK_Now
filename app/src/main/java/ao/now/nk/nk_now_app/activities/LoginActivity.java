package ao.now.nk.nk_now_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ao.now.nk.nk_now_app.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private EditText textInputPassword;
    private EditText textInputEmail;
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        ImageView imageView = findViewById(R.id.nk_image_view);

        loginButton = findViewById(R.id.login_button);
        textInputLayoutEmail = findViewById(R.id.email_text_input);
        textInputLayoutPassword = findViewById(R.id.password_text_input);
        textInputPassword = findViewById(R.id.input_password);
        textInputEmail = findViewById(R.id.input_email);
    }

    @Override
    protected void onStart() {
        super.onStart();

        textInputLayoutEmail.setErrorEnabled(true);
        textInputLayoutPassword.setErrorEnabled(true);

        textInputEmail.setOnClickListener(v -> textInputLayoutEmail.setErrorEnabled(false));
        textInputPassword.setOnClickListener(v -> textInputLayoutPassword.setErrorEnabled(false));
        loginButton.setOnClickListener(view -> {
            if (!textInputEmail.getText().toString().equals(getString(R.string.valid_user))) {
                textInputLayoutEmail.setErrorEnabled(true);
                textInputLayoutEmail.setError("Please enter a valid e-mail");
            } else if (!textInputPassword.getText().toString().equals(getString(R.string.valid_password))) {
                textInputLayoutPassword.setErrorEnabled(true);
                textInputLayoutPassword.setError("Password is invalid");
            } else {
                Intent intent = new Intent(view.getContext().getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        textInputLayoutEmail.setErrorEnabled(false);
        textInputLayoutPassword.setErrorEnabled(false);
        textInputEmail.clearComposingText();
        textInputPassword.clearComposingText();
    }
}
