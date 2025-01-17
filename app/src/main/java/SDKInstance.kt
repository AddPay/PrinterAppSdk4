import android.content.Context
import wangpos.sdk4.libbasebinder.Core
import wangpos.sdk4.libbasebinder.Printer
import wangpos.sdk4.libbasebinder.Version


object SDKInstance {
    var mCore: Core? = null
    var mPrinter: Printer? = null
    var mContext: Context? = null

    fun initSDK(context: Context?) {
        mContext = context
        mCore = Core(context, true)
        mPrinter = Printer(context)
        Version.showPackageName(context)
    }
}