package id.filkom.ti.coronaapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import id.filkom.ti.coronaapp.adapter.ChildAdapter
import id.filkom.ti.coronaapp.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var topButton: Button
    private lateinit var vaccineButton: Button
    private lateinit var indoButton: Button
    private lateinit var usButton: Button

    private lateinit var mViewPagerChild: ViewPager
    private lateinit var mPagerViewAdapter: ChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //init buttons
        topButton = view!!.findViewById(R.id.buttonTop)
        vaccineButton = view!!.findViewById(R.id.buttonVaccine)
        indoButton = view!!.findViewById(R.id.buttonIndo)
        usButton = view!!.findViewById(R.id.buttonUS)

        //init views
        mViewPagerChild = view!!.findViewById(R.id.viewPagerChild)

        //onclick listener
        topButton.setOnClickListener{
            mViewPagerChild.currentItem = 0
        }
        vaccineButton.setOnClickListener{
            mViewPagerChild.currentItem = 1
        }
        indoButton.setOnClickListener{
            mViewPagerChild.currentItem = 2
        }
        usButton.setOnClickListener{
            mViewPagerChild.currentItem = 3
        }

        mPagerViewAdapter = ChildAdapter(childFragmentManager)
        mViewPagerChild.adapter = mPagerViewAdapter
        mViewPagerChild.offscreenPageLimit = 4

        //add page change listener
        mViewPagerChild.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
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
        mViewPagerChild.currentItem = 0
        topButton.setBackgroundResource(R.drawable.roundbuttonselected)
        topButton.setTextColor(resources.getColor(R.color.white))

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun changingTabs(position: Int) {
        if(position == 0){
            topButton.setBackgroundResource(R.drawable.roundbuttonselected)
            vaccineButton.setBackgroundResource(R.drawable.roundbutton)
            indoButton.setBackgroundResource(R.drawable.roundbutton)
            usButton.setBackgroundResource(R.drawable.roundbutton)
            topButton.setTextColor(resources.getColor(R.color.white))
            vaccineButton.setTextColor(resources.getColor(R.color.dark_grey))
            indoButton.setTextColor(resources.getColor(R.color.dark_grey))
            usButton.setTextColor(resources.getColor(R.color.dark_grey))
        }
        if(position == 1){
            topButton.setBackgroundResource(R.drawable.roundbutton )
            vaccineButton.setBackgroundResource(R.drawable.roundbuttonselected)
            indoButton.setBackgroundResource(R.drawable.roundbutton)
            usButton.setBackgroundResource(R.drawable.roundbutton)
            topButton.setTextColor(resources.getColor(R.color.dark_grey))
            vaccineButton.setTextColor(resources.getColor(R.color.white))
            indoButton.setTextColor(resources.getColor(R.color.dark_grey))
            usButton.setTextColor(resources.getColor(R.color.dark_grey))
        }
        if(position == 2){
            topButton.setBackgroundResource(R.drawable.roundbutton)
            vaccineButton.setBackgroundResource(R.drawable.roundbutton)
            indoButton.setBackgroundResource(R.drawable.roundbuttonselected)
            usButton.setBackgroundResource(R.drawable.roundbutton)
            topButton.setTextColor(resources.getColor(R.color.dark_grey))
            vaccineButton.setTextColor(resources.getColor(R.color.dark_grey))
            indoButton.setTextColor(resources.getColor(R.color.white))
            usButton.setTextColor(resources.getColor(R.color.dark_grey))
        }
        if(position == 3){
            topButton.setBackgroundResource(R.drawable.roundbutton)
            vaccineButton.setBackgroundResource(R.drawable.roundbutton)
            indoButton.setBackgroundResource(R.drawable.roundbutton)
            usButton.setBackgroundResource(R.drawable.roundbuttonselected)
            topButton.setTextColor(resources.getColor(R.color.dark_grey))
            vaccineButton.setTextColor(resources.getColor(R.color.dark_grey))
            indoButton.setTextColor(resources.getColor(R.color.dark_grey))
            usButton.setTextColor(resources.getColor(R.color.white))
        }
    }
}
