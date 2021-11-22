package zul.android.chat;

import java.util.ArrayList;

import zul.android.chat.adapter.NavDrawerAdapter;
import zul.android.chat.adapter.ViewPagerAdapter;
import zul.android.chat.lib.SlidingTabLayout;
import zul.android.chat.model.NavDrawerModel;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

public class HomeActivity extends ActionBarActivity {

	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private FragmentManager mFragman;
	private LinearLayout slide_menu;
	private ListView mDrawerList;
	private NavDrawerAdapter adapter;
	private ArrayList<NavDrawerModel> navDrawerItems;
	private Toolbar toolbar;
	public static ViewPager mViewPager;
	private SlidingTabLayout mSlidingTab;

	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	public String slidingTitles[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/**
		 * (non-Javadoc) Setting Toolbar
		 * ---------------------------------------------------------------------
		 **/
		toolbar = (Toolbar) findViewById(R.id.action_bar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Android Chat Messaging");

		/**
		 * (non-Javadoc) Setting Navigation Drawer
		 * ---------------------------------------------------------------------
		 **/
		mDrawerList = (ListView) findViewById(R.id.nav_drawer_list);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		navMenuTitles = getResources().getStringArray(R.array.nav_list_title);
		navMenuIcons = getResources().obtainTypedArray(R.array.nav_list_icon);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
				R.string.drawer_open, R.string.drawer_close) {
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
				syncState();
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
				syncState();
			}
		};

		navDrawerItems = new ArrayList<NavDrawerModel>();

		for (int i = 0; i < navMenuTitles.length; i++) {
			navDrawerItems.add(new NavDrawerModel(navMenuTitles[i],
					navMenuIcons.getResourceId(i, -1)));
		}
		navMenuIcons.recycle();

		adapter = new NavDrawerAdapter(getApplicationContext(), navDrawerItems);
		mDrawerList.setAdapter(adapter);

		/**
		 * (non-Javadoc) Setting Sliding Tab and Fragment
		 * ---------------------------------------------------------------------
		 **/
		slide_menu = (LinearLayout) findViewById(R.id.slide_menu);

		slidingTitles = getResources().getStringArray(
				R.array.fragment_toolbar_title);

		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();

		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mFragman = getSupportFragmentManager();
		mViewPager.setAdapter(new ViewPagerAdapter(this, mFragman));
		mViewPager.setCurrentItem(1, true);

		mSlidingTab = (SlidingTabLayout) findViewById(R.id.sliding_tab);
		mSlidingTab.setCustomTabView(R.layout.custom_sliding_tab, 0);
		mSlidingTab.setDistributeEvenly(true);
		mSlidingTab.setViewPager(mViewPager);

		mSlidingTab
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						toolbar.setTitle(slidingTitles[position]);
						super.onPageSelected(position);
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		mDrawerToggle.syncState();
		super.onPostCreate(savedInstanceState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		mDrawerToggle.onConfigurationChanged(newConfig);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.home:
			if (mDrawerLayout.isDrawerOpen(slide_menu)) {
				mDrawerLayout.closeDrawer(slide_menu);
			} else {
				mDrawerLayout.openDrawer(slide_menu);
			}
			return true;
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
}
