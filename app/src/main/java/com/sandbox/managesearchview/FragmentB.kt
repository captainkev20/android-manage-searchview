package com.sandbox.managesearchview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentB : BaseFragment() {
    private var searchQuery = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment, container, false)
        val textView: TextView = root.findViewById(R.id.textView)
        textView.text = "Fragment B"
        return root
    }

    override fun onResume() {
        super.onResume()

        setupSearch()
    }

    private fun setupSearch() {
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                when(newText.isNullOrEmpty()) {
                    true -> searchQuery = ""
                    false -> searchQuery = newText
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                hideSearchKeyboard()
                return true
            }
        })

        super.setupSearch(searchQuery)
    }
}