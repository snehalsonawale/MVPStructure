package com.example.mvpstructure

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() ,Contract.View{


    private var textView: TextView? = null


    private var button: Button? = null


    private var progressBar: ProgressBar? = null

    var presenter: Presenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            setContentView(R.layout.activity_main)


            progressBar = findViewById(R.id.progressBar)

            button = findViewById(R.id.button)

            textView = findViewById(R.id.textView)



            presenter = Presenter(this, Model())

            this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })

        }
    }

    override fun showProgress() {

        textView!!.visibility = View.INVISIBLE
        progressBar!!.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
    }


    override fun updateBlog(string: String?) {


        textView!!.text = string
    }

    override fun hideProgress() {

        textView!!.visibility = View.VISIBLE
        progressBar!!.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }
}



