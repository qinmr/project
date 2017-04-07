package com.qinmr.mylibrary.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Eric on 2017/1/17.
 */

public class NetUtil {

    /**
     * 检查当前网络是否可用
     *
     * @return 是否连接到网络
     */
    public static boolean isNetworkAvailable(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetworkErrThenShowMsg(Context mContext) {
        if (!isNetworkAvailable(mContext)) {
            //TODO: 刚启动app Snackbar不起作用，延迟显示也不好使，这是why？
            Toast.makeText(mContext, "网络异常,请检查网络设置", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
