package id.filkom.ti.coronaapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.filkom.ti.coronaapp.fragment.*

internal class ChildAdapter (fm: FragmentManager?):
    FragmentPagerAdapter(fm!!){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                TopFragment()
            }
            1 -> {
                VaccineFragment()
            }
            2 -> {
                IndoFragment()
            }
            3 -> {
                USFragment()
            }
            else -> TopFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }
}