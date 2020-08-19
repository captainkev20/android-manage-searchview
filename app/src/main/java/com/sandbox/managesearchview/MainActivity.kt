package com.sandbox.managesearchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private var currentTabIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachToolbar()
        setupViewPager()
    }

    private fun attachToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    private fun setupViewPager() {
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentTabIndex = position
            }

            override fun onPageScrollStateChanged(p0: Int) {}

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}
        })

        val viewPageAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPageAdapter.addFragment(FragmentA(), "Fragment A")
        viewPageAdapter.addFragment(FragmentB(), "Fragment B")
        viewPageAdapter.addFragment(FragmentC(), "Fragment C")
        viewPager.adapter = viewPageAdapter
        viewPager.currentItem = currentTabIndex
        tabLayout.setupWithViewPager(viewPager)
    }
}