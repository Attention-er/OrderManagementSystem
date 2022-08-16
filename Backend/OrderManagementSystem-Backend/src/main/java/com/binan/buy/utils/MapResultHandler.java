package com.binan.buy.utils;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

public class MapResultHandler implements ResultHandler {

    private final Map mapResult = new HashMap<>();

    @Override
    public void handleResult(ResultContext resultContext) {
        Map map = (Map)resultContext.getResultObject();
        mapResult.put(map.get("key"),map.get("value"));
    }

    public Map getMapResult(){
        return mapResult;
    }
}
