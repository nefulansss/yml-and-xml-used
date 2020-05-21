package com.nefu.ymlandxmlused;

import com.nefu.ymlandxmlused.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @Author: zhanglan61
 * @Date: 2020/5/14 18:49
 * @Version: 1.0
 */
@Slf4j
public class XmlTest extends BaseTest{
    private static final String xmlUrl = "src/main/resources/flagxml.xml";

    @Autowired
    XmlUtil xmlUtil;

    @Test
    public void readAndWriteTest(){
        xmlUtil.readAndWrite();
    }


}
