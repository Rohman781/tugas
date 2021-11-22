package zul.android.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInPage extends Activity implements OnClickListener {
	TextView login, register;
	EditText username, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);

		login = (TextView) findViewById(R.id.login);
		register = (TextView) findViewById(R.id.register);

		username = (EditText) findViewById(R.id.user_login);
		password = (EditText) findViewById(R.id.user_password);

		login.setOnClickListener(this);
		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View choose) {
		if (choose instanceof TextView) {
			TextView selected_choose = (TextView) choose;

			if (selected_choose.getText().equals("Login")) {
				userLogin();
			} else if (selected_choose.getText().equals("Register")) {
				userRegister();
			}

		}
	}

	private void userLogin() {
		if (username.getText().toString().equals("zul")) {
			startActivity(new Intent(this, HomeActivity.class));
		} else {
			Toast.makeText(getBaseContext(), "Periksa user dan password Anda",
					Toast.LENGTH_SHORT).show();
		}
	}

	private void userRegister() {
		startActivity(new Intent(this, RegisterPage.class));
	}

}
