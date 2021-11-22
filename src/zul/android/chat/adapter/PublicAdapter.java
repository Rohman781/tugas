package zul.android.chat.adapter;

import java.util.ArrayList;
import zul.android.chat.R;
import zul.android.chat.model.PublicModel;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class PublicAdapter extends BaseAdapter {
	ArrayList<PublicModel> public_data;
	Context context;

	public PublicAdapter(ArrayList<PublicModel> public_data, Context context) {
		this.public_data = public_data;
		this.context = context;
	}

	@Override
	public int getCount() {
		return public_data.size();
	}

	@Override
	public Object getItem(int position) {
		return public_data.get(position);
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
			converter = mInflater.inflate(R.layout.list_item_public, null);
		}

		TextView publicDate, publicName, publicStatus;

		publicDate = (TextView) converter.findViewById(R.id.public_date);
		publicName = (TextView) converter.findViewById(R.id.public_name);
		publicStatus = (TextView) converter.findViewById(R.id.public_status);

		publicDate.setText(public_data.get(position).getDate());
		publicName.setText(public_data.get(position).getName());
		publicStatus.setText(public_data.get(position).getChatStatus());
		return converter;
	}

}
