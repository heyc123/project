package com.heyc.gasstation.softem.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class XmlUtil {

    public static Map xmlToMap( HttpServletRequest req) {
        Map<String, String> map = new HashMap<>();
        try{
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = req.getInputStream();
            Document dom =  saxReader.read(inputStream);
            Element root = dom.getRootElement();
            List<Element> list = root.elements();
            list.forEach(ite -> {
                map.put(ite.getName(),ite.getText());
            });
        }catch (Exception e) {}
        return map;
    }

    public static<T> T mapToObj(Class<T> t, Map<String, String> map) {
        try {
            T obj = t.newInstance();
            BeanUtils.populate(obj, map);
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}