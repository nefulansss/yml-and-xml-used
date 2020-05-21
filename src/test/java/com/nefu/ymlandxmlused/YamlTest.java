package com.nefu.ymlandxmlused;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhanglan61
 * @Date: 2020/5/21 16:41
 * @Version: 1.0
 */
@Slf4j
public class YamlTest extends BaseTest {


    @Test
    public void YamlTest(){
       final String src = "src/main/resources/flagyml.yml";
        Yaml yaml = new Yaml();
        try {
            Object load = yaml.load(new FileInputStream(src));
            log.info("加载的文件：{}",load);

            Map<String,Object> data = new HashMap<>();
            data.put("name","ZZZZZ");
            data.put("H","HH");
            FileWriter file = null;
            try {
                file = new FileWriter(src);
            } catch (IOException e) {
                e.printStackTrace();
                log.info("写入文件出错");
            }
            yaml.dump(data,file);

        } catch (FileNotFoundException e) {
            log.info("文件加载失败..");
        }
    }
}
