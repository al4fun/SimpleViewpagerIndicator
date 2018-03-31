package cn.szx.myindicator;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SimpleViewpagerIndicator indicator;
    ViewPager viewPager;

    String[] pageTitles = {"记录", "排行", "魔兽世界", "EA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new VpAdapter(getSupportFragmentManager()));

        indicator = findViewById(R.id.indicator);
        //indicator.setExpand(true)//设置tab宽度为包裹内容还是平分父控件剩余空间，默认值：false,包裹内容
        //        .setIndicatorWrapText(false)//设置indicator是与文字等宽还是与整个tab等宽，默认值：true,与文字等宽
        //        .setIndicatorColor(Color.parseColor("#ff3300"))//indicator颜色
        //        .setIndicatorHeight(2)//indicator高度
        //        .setShowUnderline(true, Color.parseColor("#dddddd"), 2)//设置是否展示underline，默认不展示
        //        .setShowDivider(true, Color.parseColor("#dddddd"), 10, 1)//设置是否展示分隔线，默认不展示
        //        .setTabTextSize(16)//文字大小
        //        .setTabTextColor(Color.parseColor("#ff999999"))//文字颜色
        //        .setTabTypeface(null)//字体
        //        .setTabTypefaceStyle(Typeface.NORMAL)//字体样式：粗体、斜体等
        //        .setTabBackgroundResId(0)//设置tab的背景
        //        .setTabPadding(0)//设置tab的左右padding
        //        .setSelectedTabTextSize(20)//被选中的文字大小
        //        .setSelectedTabTextColor(Color.parseColor("#ff3300"))//被选中的文字颜色
        //        .setSelectedTabTypeface(null)
        //        .setSelectedTabTypefaceStyle(Typeface.BOLD)
        //        .setScrollOffset(120);//滚动偏移量
        indicator.setViewPager(viewPager);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class VpAdapter extends FragmentPagerAdapter {
        VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitles[position % 4];
        }

        @Override
        public Fragment getItem(int position) {
            return new TestFragment();
        }
    }
}