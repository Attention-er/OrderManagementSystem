package com.binan.buy.handler;

import io.swagger.models.auth.In;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

public class FoodInfoMapResultHandler implements ResultHandler {

    private final Map<String,Integer> mapResult = new HashMap<String,Integer>();

    @Override
    public void handleResult(ResultContext resultContext) {
        Map resultObject = (Map)resultContext.getResultObject();
        mapResult.put((String)resultObject.get("key") ,(Integer)resultObject.get("value"));
    }

    public Map<String,Integer> getMapResult(){
        return mapResult;
    }
}
