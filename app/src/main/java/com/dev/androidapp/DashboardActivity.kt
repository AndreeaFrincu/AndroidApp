package com.dev.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.androidapp.fragments.FilesFragment
import com.dev.androidapp.fragments.GalleryFragment
import com.dev.androidapp.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val homeFragment = HomeFragment()
        val filesFragment = FilesFragment()
        val galleryFragment = GalleryFragment()

        setCurrentFragment(homeFragment)

        bottomNav.setOnItemReselectedListener {
            when(it.itemId) {
                R.id.ic_home -> setCurrentFragment(homeFragment)
                R.id.ic_files -> setCurrentFragment(filesFragment)
                R.id.ic_gallery -> setCurrentFragment(galleryFragment)
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
        replace(R.id.dashFrame, fragment)
            commit()
    }
}