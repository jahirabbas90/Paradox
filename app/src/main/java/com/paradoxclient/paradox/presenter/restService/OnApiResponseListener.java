package com.paradoxclient.paradox.presenter.restService;

/**
 * Created by Jahir on 14/9/18.
 */

public interface OnApiResponseListener {
    public <E> void onSuccess(E t);
    public <E> void onError(E t);
    public  void onError();
}
