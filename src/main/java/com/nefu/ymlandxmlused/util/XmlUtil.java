package com.nefu.ymlandxmlused.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;

import javax.sql.rowset.spi.XmlWriter;
import java.io.*;
import java.util.Iterator;

/**
 * @Author: zhanglan61
 * @Date: 2020/5/14 18:53
 * @Version: 1.0
 */
@Component
@Slf4j
public class XmlUtil {

    private static final String xmlUrl = "src/main/resources/flagxml.xml";

    public String readAndWrite() {

        SAXReader saxReader = new SAXReader();
        log.info("开始读取xml文件");
        Document doc = null;
        try {
            //开始读
            doc = saxReader.read(new File(xmlUrl));
            Element rootElement = doc.getRootElement();
            Element flag = rootElement.element("flag");
            log.info("flag中的文本 {}",flag.getText());
            Element name = rootElement.element("name");
            log.info("name节点的内容 {}",name.getText());
            //转型
            if (Boolean.getBoolean(flag.getText())) {
                boolean b = Boolean.parseBoolean(flag.getText());
                log.info("转成boolean为: {}",b);
            }

            //开始写
            flag.setText("false");
            flag.addAttribute("zhansgan","true");
            name.setText("张三");
            log.info("增加： li节点");
            rootElement.addAttribute("li","aa");

            log.info("枚举。。");
            for (Iterator iterator = rootElement.elementIterator();iterator.hasNext();){
                Element element = (Element)iterator.next();
                log.info("{} 节点的值为： {}",element.getName(),element.getText());

            }

            //写入原文件
          //  XMLWriter writer = new XMLWriter();  默认输出控制台
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(xmlUrl),format);
            writer.write(doc);
            writer.close();

        } catch (DocumentException e) {
            log.error("读取失败...");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("写入失败");
        }
        return null;
    }

}
