package zul.android.chat.adapter;

import zul.android.chat.FragmentContact;
import zul.android.chat.R;
import zul.android.chat.room.FragmentListGroupChat;
import zul.android.chat.room.FragmentPersonalChat;
import zul.android.chat.room.FragmentPublicChat;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	Activity activity;
	TypedArray fragment_icon;
	String fragment_title[];

	public ViewPagerAdapter(Activity activity, FragmentManager fm) {
		super(fm);
		this.activity = activity;
		fragment_icon = activity.getResources().obtainTypedArray(
				R.array.sliding_tab_icon);
		fragment_title = activity.getResources().getStringArray(
				R.array.fragment_title);
	}

	@SuppressWarnings("deprecation")
	@Override
	public CharSequence getPageTitle(int position) {
		Drawable image = activity.getResources().getDrawable(
				fragment_icon.getResourceId(position, -1));
		image.setBounds(0, 0, image.getIntrinsicWidth(),
				image.getIntrinsicHeight());
		SpannableString sb = new SpannableString(" ");
		ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
		sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return sb;
		// return fragment_title[position];
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return FragmentContact.newInstance();
		case 1:
			return FragmentPersonalChat.newInstance();
		case 2:
			return FragmentListGroupChat.newInstance();
		case 3:
			return FragmentPublicChat.newInstance();
		}

		return null;
	}

}
