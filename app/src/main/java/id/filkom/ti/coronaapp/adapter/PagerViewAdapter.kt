package id.filkom.ti.coronaapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.filkom.ti.coronaapp.fragment.CoronaFragment
import id.filkom.ti.coronaapp.fragment.HelpFragment
import id.filkom.ti.coronaapp.fragment.HomeFragment

internal class PagerViewAdapter (fm: FragmentManager?):
    FragmentPagerAdapter(fm!!){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                HomeFragment()
            }
            1 -> {
                CoronaFragment()
            }
            2 -> {
                HelpFragment()
            }
            else -> HomeFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}