package com.example.jianyang.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends FragmentActivity
{

	FragmentPagerAdapter adapterViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ViewPager viewPager = (ViewPager)findViewById(R.id.vpPager);
		adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapterViewPager);
		viewPager.setOffscreenPageLimit(5);

//		viewPager.setPageTransformer(false, new ViewPager.PageTransformer()
//		{
//
//			@Override
//			public void transformPage(View page, float position)
//			{
//				int pageWidth = page.getWidth();
//				int pageHeight = page.getHeight();
//
//				if (position < -1)
//				{
//					page.setAlpha(0f);
//				}
//				else if (position <= 1)
//				{
//
//				}
//				else
//				{
//					page.setAlpha(0);
//				}
//			}
//		});

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i, float v, int i2)
			{

			}

			@Override
			public void onPageSelected(int i)
			{
				Toast.makeText(MainActivity.this,
							   "Selected page position: " + i, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onPageScrollStateChanged(int i)
			{

			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public static class MyPagerAdapter extends FragmentPagerAdapter
	{
		private static int NUM_ITEMS = 3;

		public MyPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int i)
		{
			switch (i) {
				case 0: // Fragment # 0 - This will show FirstFragment
					return FirstFragment.newInstance(0, "Page # 1");
				case 1: // Fragment # 0 - This will show FirstFragment different title
					return FirstFragment.newInstance(1, "Page # 2");
				case 2: // Fragment # 1 - This will show SecondFragment
					return SecondFragment.newInstance(2, "Page # 3");
				default:
					return null;
			}
		}

		@Override
		public int getCount()
		{
			return NUM_ITEMS;
		}


		// Returns the page title for the top indicator
		@Override
		public CharSequence getPageTitle(int position) {
			return "Page " + position;
		}
	}
}
