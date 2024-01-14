package com.syscers.envs;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context. */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page. */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showAlert(String alert) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(alert)
                .setTitle(alert);

        builder.create().show();
    }
}
