package com.xlearn.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Description:序列化的时候利用jackson进行时间转换
 *
 * @author 轩辚
 * @date 2019/3/17 23:16
 */
public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //序列化的时候自动将日期转换成以秒为单位的时间戳
        jsonGenerator.writeNumber(date.getTime()/1000);
    }
}
