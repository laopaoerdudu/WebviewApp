package com.wwe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProxyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: run {
            dispatchIntent(intent)
        }

        finish()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        dispatchIntent(intent)
        finish()
    }

    /**
     * 通过 Scheme 拉起的 Activity，在其 Intent 中会包含 Web 端传递过来的深度链接参数。
     * 参数实体是一个 URI 格式的字符串，获取到这个 URI 后，App 就可以根据自定义协议来拉起落地页。
     */
    private fun dispatchIntent(intent: Intent?) {
        intent ?: return
        val uri: Uri = intent.data ?: return
        // 根据自定义协议解析 Uri

        // if (SchemeHelper.getRunningActivityCount() == 1) {
        //            // 1. 冷启动
        //            // 1.1 将 Uri 临时存储到全局静态域
        //            SchemeHelper.setPendingSchemeUri(intent.data)
        //            // 1.2 转而启动 SplashActivity，走正常点 Launcher 的启动流程
        //            startActivity(Intent(this, SplashActivity::class.java))
        //        } else {
        //            // 2. 热启动，直接打开落地页
        //            SchemeHelper.handleDeepLink(this, uri)
        //        }
    }
}