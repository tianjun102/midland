package com.huixin.test.bean;

import com.huixin.core.feature.test.TestSupport;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * SpiderTest : 爬虫测试类
 *
 * @author 
 * @since 2014-10-27 22:44
 */
public class SpiderTest extends TestSupport {

    @Resource
    private Spider spider;

    @Test
    public void testInjectSpider() throws Exception {
        System.out.println(spider);
    }
}
