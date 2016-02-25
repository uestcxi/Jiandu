package com.jason.jiandu.bmob;

import android.content.Context;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Jason on 2016/2/21.
 */
public class GetArticle
{
    public GetArticle(Context context, String time, final SuccessCallback successCallback, final FailCallback
            failCallback)
    {
        BmobQuery<ArticleObj> query = new BmobQuery<ArticleObj>();
        query.addWhereEqualTo("artTime", time);
        query.setLimit(1);
        query.findObjects(context, new FindListener<ArticleObj>()
        {
            @Override
            public void onSuccess(List<ArticleObj> list)
            {
                if (successCallback!=null)
                {
                    successCallback.onSuccess(list.get(0));
                }
            }

            @Override
            public void onError(int i, String s)
            {
                if (failCallback != null)
                {
                    String str = null;
                    switch (i)
                    {
                        case ErrorCode.NET_UNAVAILABLE:
                            str = "无网络连接，请检查您的手机网络";
                            break;
                        case ErrorCode.OTHERS:
                            str = "未知错误,请重启软件";
                            break;
                        case ErrorCode.TIME_OUT:
                            str = "网络超时";
                            break;
                    }
                    failCallback.onFail(i,str);
                }
            }
        });
    }

    public static interface SuccessCallback
    {
        void onSuccess(ArticleObj art);
    }

    public static interface FailCallback
    {
        void onFail(int i, String s);
    }
}
