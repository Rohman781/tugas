package zul.android.chat.adapter;

import java.util.ArrayList;

import zul.android.chat.R;
import zul.android.chat.model.NavDrawerModel;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<NavDrawerModel> navDrawerItem;

	public NavDrawerAdapter(Context context,
			ArrayList<NavDrawerModel> navDrawerItem) {
		this.context = context;
		this.navDrawerItem = navDrawerItem;
	}

	@Override
	public int getCount() {
		return navDrawerItem.size();
	}

	@Override
	public Object getItem(int position) {
		return navDrawerItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.list_navigation_drawer,
					null);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
		TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

		imgIcon.setImageResource(navDrawerItem.get(position).getIcon());
		txtTitle.setText(navDrawerItem.get(position).getTitle());

		// displaying count
		// check whether it set visible or not
		if (navDrawerItem.get(position).getCounterVisibility()) {
			txtCount.setText(navDrawerItem.get(position).getCount());
		} else {
			// hide the counter view
			txtCount.setVisibility(View.GONE);
		}

		return convertView;
	}

}
