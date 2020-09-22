/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author buhao
 * @version TestFile.java, v 0.1 2020-08-28 14:28 buhao
 */
public class TestFile {

    /**
     * 标签替换
     */
    @Test
    public void testFileReplace() {
        // 获得文件列表
        final List<File> mkFiles = FileUtil.loopFiles("/Users/kiwi/study/hexo/source/_posts/yuque", file -> StrUtil.startWithIgnoreCase(file.getName(), "【"));
        for (File mkFile : mkFiles) {
            // 获得标签名称
            final String tagName = ReUtil.getGroup1("【(.*?)】.*?", mkFile.getName());
            // 获得文章内容
            String content = FileUtil.readString(mkFile, "utf-8");
            // 替换空标签
            content = StrUtil.replace(content, "tags: []", "tags: [" + tagName + "]");
            FileUtil.writeString(StrUtil.replace(content, "categories: []", "categories: [" + tagName + "]"), mkFile, "utf-8");
        }
    }
}