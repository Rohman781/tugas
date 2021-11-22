package zul.android.chat.room;

import java.util.ArrayList;

import zul.android.chat.R;
import zul.android.chat.adapter.ChatAdapter;
import zul.android.chat.adapter.PublicAdapter;
import zul.android.chat.model.ChatModel;
import zul.android.chat.model.PublicModel;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentPublicChat extends Fragment {
	PublicAdapter publicAdapter;
	ArrayList<PublicModel> publicData;

	public static FragmentPublicChat newInstance() {
		FragmentPublicChat mFragment = new FragmentPublicChat();
		return mFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_public_chat,
				container, false);

		publicData = new ArrayList<PublicModel>();
		PublicModel object = new PublicModel();

		for (int i = 0; i < 10; i++) {
			object.setName("John Almando");
			object.setDate("20/8/2015");
			object.setChatStatus("Hello Everybody");
			publicData.add(object);
		}

		publicAdapter = new PublicAdapter(publicData, getActivity()
				.getBaseContext());

		ListView publicList = (ListView) rootView
				.findViewById(R.id.public_list);

		publicList.setAdapter(publicAdapter);
		return rootView;
	}
}
