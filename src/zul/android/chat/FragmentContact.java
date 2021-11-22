package zul.android.chat;

import java.util.ArrayList;

import zul.android.chat.adapter.ContactAdapter;
import zul.android.chat.model.ContactModel;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentContact extends Fragment implements OnItemClickListener,
		OnItemLongClickListener {

	ContactAdapter mContactAdapter;
	ListView contact_list;
	LinearLayout contact_layout;

	public static FragmentContact newInstance() {
		FragmentContact mFragment = new FragmentContact();
		return mFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_contact, container,
				false);

		ArrayList<ContactModel> data = new ArrayList<ContactModel>();

		for (int i = 0; i < 10; i++) {
			ContactModel object_data = new ContactModel();
			object_data.setName("John Doe");
			object_data.setEmail("hello@gello.com");
			object_data.setMobile("+628570112489");
			data.add(object_data);
		}

		mContactAdapter = new ContactAdapter(data, getActivity()
				.getBaseContext());

		contact_list = (ListView) rootView.findViewById(R.id.contact_list);
		contact_list.setAdapter(mContactAdapter);
		contact_list.setOnItemClickListener(this);
		contact_list.setOnItemLongClickListener(this);

		return rootView;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.main_second, menu);
		menu.clear();

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(getActivity(), "onItemClick", Toast.LENGTH_SHORT).show();

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {

		DialogFragment newFragment = new ContactDialogFragment();
		newFragment.show(getFragmentManager(), "missiles");

		return true;
	}

	public class ContactDialogFragment extends DialogFragment {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {

			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			LayoutInflater inflater = getActivity().getLayoutInflater();

			builder.setView(
					inflater.inflate(R.layout.dialog_contact_fragment, null))
					// Add action buttons
					.setPositiveButton("Chat",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									Toast.makeText(getActivity(), "Start Chat",
											Toast.LENGTH_SHORT).show();

									new HomeActivity().mViewPager
											.setCurrentItem(1);
								}
							})
					.setNegativeButton("Block",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Toast.makeText(getActivity(),
											"Blocked User", Toast.LENGTH_SHORT)
											.show();

									/*
									 * ContactDialogFragment.this.getDialog()
									 * .cancel();
									 */
								}
							});
			return builder.create();
		}
	}

}
