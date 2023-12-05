package com.example.mvpstructure

class Presenter(private var mainView: Contract.View?,private val model: Contract.Model) :
    Contract.Presenter, Contract.Model.OnFinishedListener {

    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        model.getNextBlog(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView!!.updateBlog(string) // Update the blog to be displayed
            mainView!!.hideProgress() // After updating, hide the progress bar
        }
    }
}