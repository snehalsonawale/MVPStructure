package com.example.mvpstructure

interface Contract {

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
        fun getNextBlog(onFinishedListener: OnFinishedListener?)
    }

    interface View {
        fun showProgress()
        fun updateBlog(string: String?)
        fun hideProgress()
    }

    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}