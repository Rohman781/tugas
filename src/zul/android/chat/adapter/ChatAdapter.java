package zul.android.chat.adapter;

import java.util.ArrayList;
import zul.android.chat.R;
import zul.android.chat.model.ChatModel;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class ChatAdapter extends BaseAdapter {

	ArrayList<ChatModel> chat_data;
	Context context;

	public ChatAdapter(ArrayList<ChatModel> chat_data, Context context) {
		this.chat_data = new ArrayList<ChatModel>(chat_data);
		this.context = context;
	}

	@Override
	public int getCount() {
		return chat_data.size();
	}

	@Override
	public Object getItem(int position) {
		return chat_data.get(position);
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
			converter = mInflater.inflate(R.layout.list_item_chat, null);
		}

		TextView chatDate = (TextView) converter.findViewById(R.id.chat_date);
		TextView chatWith = (TextView) converter.findViewById(R.id.chat_with);
		TextView sentence = (TextView) converter
				.findViewById(R.id.chat_last_sentence);

		chatDate.setText(chat_data.get(position).getDate());
		chatWith.setText(chat_data.get(position).getChatWith());
		sentence.setText(chat_data.get(position).getLastSentence());
		return converter;
	}

}
