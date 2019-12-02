/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.xmind;

import org.junit.Test;
import org.xmind.core.Core;
import org.xmind.core.CoreException;
import org.xmind.core.ISheet;
import org.xmind.core.ITopic;
import org.xmind.core.IWorkbook;
import org.xmind.core.IWorkbookBuilder;

import java.io.IOException;

/**
 * @author buhao
 * @version TestXmind.java, v 0.1 2019-11-28 21:39 buhao
 */
public class TestXmind {

    @Test
    public void test() throws IOException, CoreException {

        IWorkbookBuilder workbookBuilder = Core.getWorkbookBuilder();
        IWorkbook workbook = workbookBuilder.createWorkbook();

        // 获得默认sheet
        ISheet primarySheet = workbook.getPrimarySheet();
        // 获得根主题
        ITopic rootTopic = primarySheet.getRootTopic();
        rootTopic.setTitleText("根主题");
        // 创建主题
        ITopic topic = workbook.createTopic();
        topic.setTitleText("子主题");
        // 添加子主题
        rootTopic.add(topic, ITopic.ATTACHED);

        // 保存
        workbook.save("/Users/kiwi/Desktop/test.xmind");


    }

}