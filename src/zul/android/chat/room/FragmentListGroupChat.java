package zul.android.chat.room;

import java.util.ArrayList;

import zul.android.chat.R;
import zul.android.chat.adapter.ListGroupAdapter;
import zul.android.chat.model.ListGroupModel;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentListGroupChat extends Fragment {
	ListGroupAdapter listGroupAdapter;
	ArrayList<ListGroupModel> listGroupData;
	ListView mListView;

	public static FragmentListGroupChat newInstance() {
		FragmentListGroupChat mFragment = new FragmentListGroupChat();
		return mFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_list_group_chat,
				container, false);

		listGroupData = new ArrayList<ListGroupModel>();

		for (int i = 0; i < 10; i++) {
			ListGroupModel object = new ListGroupModel();
			object.setGroupName("Alumni AKAKOM 2009");
			object.setGroupDescription("Share dan Chat untuk semua Alumni khusus 2009");
			listGroupData.add(object);
		}

		listGroupAdapter = new ListGroupAdapter(listGroupData, getActivity()
				.getBaseContext());
		mListView = (ListView) rootView.findViewById(R.id.listGrup_list);
		mListView.setAdapter(listGroupAdapter);

		return rootView;
	}
}
