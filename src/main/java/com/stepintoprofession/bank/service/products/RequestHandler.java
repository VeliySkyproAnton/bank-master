package com.stepintoprofession.bank.service.products;

import com.stepintoprofession.bank.model.Request;

public interface RequestHandler {
    boolean check(Request request);
    void preExecute(Request request);
    void postExecute(Request request);
    boolean ready(Request request);
}
