package com.example.mvpstructure

import com.example.mvpstructure.Contract
import java.util.Arrays
import android.os.Handler

class Model : Contract.Model {
    private val blogs = Arrays.asList("C/C++","Java","Python","Kotlin/Android","Operating Systems")
    private var index = 0


    override fun getNextBlog(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({ onFinishedListener!!.onFinished(getNextBlogWithIndex(getNextIndex())) }, 900)
    }

    private fun getNextIndex(): Int{
        index = (index + 1)% blogs.size
        return index
    }

    private fun getNextBlogWithIndex(get_index: Int): String{
        return blogs[get_index]
    }
}
