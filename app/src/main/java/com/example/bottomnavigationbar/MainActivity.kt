package com.example.bottomnavigationbar

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dashbordFragment = DashbordFragment()
    private val settingFragment = SettingFragment()
    private val infoFragment  = InfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fragments
        navigationFragments(DashbordFragment())

        navigtion_container.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.id_dashbord -> navigationFragments(DashbordFragment())
                R.id.id_setting -> navigationFragments(SettingFragment())
                R.id.id_info -> navigationFragments(InfoFragment())
            }
            true
        }


    }

    fun navigationFragments(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_container, fragment)
            transaction.commit()
        }
    }
}