package zul.android.chat.adapter;

import java.util.ArrayList;

import zul.android.chat.R;
import zul.android.chat.model.ContactModel;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class ContactAdapter extends BaseAdapter {
	ArrayList<ContactModel> contact_data;
	Context context;

	public ContactAdapter(ArrayList<ContactModel> contact_data, Context context) {
		this.contact_data = new ArrayList<ContactModel>(contact_data);
		this.context = context;
	}

	@Override
	public int getCount() {
		return contact_data.size();
	}

	@Override
	public Object getItem(int position) {
		return contact_data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View converter, ViewGroup parent) {
		if (converter == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			converter = mInflater.inflate(R.layout.list_item_contact, null);
		}

		TextView txtName = (TextView) converter.findViewById(R.id.contact_name);
		TextView txtMail = (TextView) converter.findViewById(R.id.contact_mail);

		txtName.setText(contact_data.get(position).getName());
		txtMail.setText(contact_data.get(position).getEmail());
		return converter;
	}

}
