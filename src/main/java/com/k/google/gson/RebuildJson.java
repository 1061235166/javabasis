package com.k.google.gson;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.*;

import java.util.*;

/**
 * 修改一个json字符串的内容
 * Created by k on 2018/5/16.
 */
public class RebuildJson {

    private static Gson gson = new GsonBuilder().setPrettyPrinting()
            .create();


    public static void main(String[] args) {
        rebuildJson();
    }

    /**
     * 根据e.d.f | h=444,k=33 这个表达式修改指定路径json的值
     */
    public static void rebuildJson(){
        String json = generateJson();
        System.out.println(json);

        String path = "e.d.f";
        String[] split = path.split("\\.");
        Spliterator<String> spliterator = Arrays.spliterator(split);
        List<String>result = new ArrayList<>();
        spliterator.forEachRemaining((s)->result.add(s));
        System.out.println(result);

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonElement temp = jsonObject;
        for(int i=0;i<result.size();i++){
            if(temp.isJsonObject()){
                JsonObject tj = temp.getAsJsonObject();
                temp = tj.get(result.get(i));
            }
        }
        System.out.println(temp);
        //如果是json对象
        if(temp.isJsonObject()){
            JsonObject asJsonObject = temp.getAsJsonObject();
            asJsonObject.addProperty("h","jkdlsajkl");
            asJsonObject.addProperty("k","jd9au98d7u98a98dsa");
            System.out.println("==============");
            System.out.println(gson.toJson(jsonObject));
        }
        //如果是json数组xxx
        if(temp.isJsonArray()){
            JsonArray asJsonArray = temp.getAsJsonArray();
        }
    }

    public static String generateJson(){
        Map<String,Object>map= Maps.newHashMap();
        map.put("a","aaa");
        map.put("b",123);
        map.put("c", Lists.newArrayList(1,2,3,5,6,7));
        map.put("d",Lists.newArrayList(Double.MAX_EXPONENT,Double.MIN_NORMAL));
        HashMap<Object, Object> e = Maps.newHashMap();
        map.put("e",e);
        e.put("a","a");
        e.put("b",Lists.newArrayList(123,8989));
        HashMap<Object, Object> d = Maps.newHashMap();
        e.put("d",d);
        d.put("name","e");
        d.put("age",10);
        HashMap<Object, Object> f = Maps.newHashMap();
        d.put("f",f);
        f.put("k",3);
        f.put("h",1);
        return gson.toJson(map);
    }
}
