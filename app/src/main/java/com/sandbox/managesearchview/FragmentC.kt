package com.sandbox.managesearchview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentC : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment, container, false)
        val textView: TextView = root.findViewById(R.id.textView)
        textView.text = "Fragment C\nwithout search"
        return root
    }

    override fun onResume() {
        super.onResume()
        super.hideSearch()
    }
}