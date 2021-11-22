package zul.android.chat.adapter;

import java.util.ArrayList;
import zul.android.chat.R;
import zul.android.chat.model.ListGroupModel;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class ListGroupAdapter extends BaseAdapter {
	ArrayList<ListGroupModel> listGroupData;
	Context context;

	public ListGroupAdapter(ArrayList<ListGroupModel> listGroupData,
			Context context) {
		this.listGroupData = new ArrayList<ListGroupModel>(listGroupData);
		this.context = context;
	}

	@Override
	public int getCount() {
		return listGroupData.size();
	}

	@Override
	public Object getItem(int position) {
		return listGroupData.get(position);
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
			converter = mInflater.inflate(R.layout.list_item_group, null);
		}

		TextView nameGroup, description;
		nameGroup = (TextView) converter.findViewById(R.id.group_name);
		description = (TextView) converter.findViewById(R.id.group_description);

		nameGroup.setText(listGroupData.get(position).getGroupName());
		description.setText(listGroupData.get(position).getGroupDescription());

		return converter;
	}

}
