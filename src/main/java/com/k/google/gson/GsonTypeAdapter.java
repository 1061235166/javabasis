package com.k.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * gson类型适配器
 * 根据特定需求解析或者读取json
 * Created by k on 2019/5/5.
 */
public class GsonTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        JsonWriter jsonWriter = out.beginObject();
        jsonWriter.endObject();

        jsonWriter.close();
    }

    @Override
    public Object read(JsonReader in) throws IOException {
        Object o = new Object();
        JsonToken jsonToken = in.peek();
        String valueName = jsonToken.name();
        if(valueName.equals("xxxx")){
            //o.xxx
        }
        return o;
    }
}
