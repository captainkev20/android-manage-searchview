package com.sandbox.managesearchview

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout

open class BaseFragment: Fragment() {
    lateinit var rootActivity: MainActivity
    lateinit var appBarLayout: AppBarLayout
    lateinit var searchView: androidx.appcompat.widget.SearchView

    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.rootActivity = context as MainActivity
        appBarLayout = rootActivity.findViewById(R.id.app_bar_layout)
        searchView = rootActivity.findViewById(R.id.search_input)
    }

    override fun onResume() {
        super.onResume()

        resetAppBarLayout()
    }

    private fun resetAppBarLayout() {
        appBarLayout.elevation = 14f
    }

    fun setupSearch(query: String) {
        searchView.visibility = View.VISIBLE
        searchView.clearFocus()
        when(query.isNotEmpty()) {
            true -> {
                searchView.setQuery(query, true)
                searchView.isIconified = false
            }
            false -> {
                searchView.isIconified = true
                searchView.isIconified = true
            }
        }
    }

    fun hideSearchKeyboard() {
        context?.let {
            KeyboardHelper.hideSearchKeyboard(it, searchView.findViewById(R.id.search_src_text))
        }
    }

    fun hideSearch() {
        searchView.visibility = View.GONE
        searchView.clearFocus()
    }
}