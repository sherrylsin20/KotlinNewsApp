package id.filkom.ti.coronaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import id.filkom.ti.coronaapp.adapter.PagerViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var homeIcon: ImageButton
    private lateinit var coronaIcon: ImageButton
    private lateinit var helpIcon: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapter: PagerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init views
        mViewPager = findViewById(R.id.mViewPager)

        //init image buttons
        homeIcon = findViewById(R.id.homeIcon)
        coronaIcon = findViewById(R.id.mapIcon)
        helpIcon = findViewById(R.id.helpIcon)

        //onclick listener
        homeIcon.setOnClickListener{
            mViewPager.currentItem = 0
        }
        coronaIcon.setOnClickListener{
            mViewPager.currentItem = 1
        }
        helpIcon.setOnClickListener{
            mViewPager.currentItem = 2
        }

        mPagerViewAdapter = PagerViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerViewAdapter
        mViewPager.offscreenPageLimit = 3

        //add page change listener
        mViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changingTabs(position)
            }
        })

        //default tab
        mViewPager.currentItem = 0
        homeIcon.setImageResource(R.drawable.ic_baseline_home_24)
    }

    private fun changingTabs(position: Int) {
        if(position ==  0){
            homeIcon.setImageResource(R.drawable.ic_baseline_home_24)
            coronaIcon.setImageResource(R.drawable.ic_baseline_map)
            helpIcon.setImageResource(R.drawable.ic_baseline_help)
        }
        if(position == 1){
            homeIcon.setImageResource(R.drawable.ic_baseline_home)
            coronaIcon.setImageResource(R.drawable.ic_baseline_map_24)
            helpIcon.setImageResource(R.drawable.ic_baseline_help)
        }
        if(position == 2){
            homeIcon.setImageResource(R.drawable.ic_baseline_home)
            coronaIcon.setImageResource(R.drawable.ic_baseline_map)
            helpIcon.setImageResource(R.drawable.ic_baseline_help_24)
        }
    }
}