package zul.android.chat.room;

import java.util.ArrayList;

import zul.android.chat.R;
import zul.android.chat.adapter.ChatAdapter;
import zul.android.chat.model.ChatModel;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentPersonalChat extends Fragment {
	ChatAdapter chatAdapter;
	ListView listChat;

	public static FragmentPersonalChat newInstance() {
		FragmentPersonalChat mFragment = new FragmentPersonalChat();
		return mFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_personal_chat,
				container, false);

		ArrayList<ChatModel> chatData = new ArrayList<ChatModel>();
		ChatModel object = new ChatModel();

		for (int i = 0; i < 10; i++) {
			object.setChatWith("Joe Almando");
			object.setLastSentence("Jangan lupa deadline terakhir");
			object.setDate("10/04/2015");
			chatData.add(object);
		}

		chatAdapter = new ChatAdapter(chatData, getActivity().getBaseContext());
		listChat = (ListView) rootView.findViewById(R.id.chat_list);
		listChat.setAdapter(chatAdapter);
		return rootView;
	}
}
