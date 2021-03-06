package com.jsonstatham.hackathonapp.ui.Main.Story

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsonstatham.hackathonapp.R
import dagger.android.support.DaggerFragment

/**
 * A simple [Fragment] subclass.
 */
class StoryFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

}
