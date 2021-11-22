package zul.android.chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPage extends Activity implements OnClickListener {
	TextView reset, register;
	EditText username, password, email, mobile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_page);

		username = (EditText) findViewById(R.id.user_register_login);
		password = (EditText) findViewById(R.id.user_register_password);
		email = (EditText) findViewById(R.id.user_register_mail);
		mobile = (EditText) findViewById(R.id.user_register_mobile_phone);

		reset = (TextView) findViewById(R.id.reset);
		register = (TextView) findViewById(R.id.register);

		reset.setOnClickListener(this);
		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View choose) {
		if (choose instanceof TextView) {
			String selected = (String) ((TextView) choose).getText();

			if (selected.equals("Reset")) {
				username.setText(" ");
				password.setText(" ");
				email.setText(" ");
				mobile.setText(" ");

			} else if (selected.equals("Register")) {
				Toast.makeText(getBaseContext(), "Register", Toast.LENGTH_SHORT)
						.show();
			}

		}
	}
}
