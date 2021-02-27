/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReadConfig;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
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

    @Test
    public void testSeparated() {
        // 生成目录
        String generateRootDir = "/Users/kiwi/work/文档/MD/obsidian/文字素材";
        final List<String> articleCells = FileUtil.listFileNames(generateRootDir);
        // 读取文章
        final String document = FileUtil.readString("/Users/kiwi/work/文档/MD/obsidian/收集箱/文字素材.md", Charset.defaultCharset());
        final List<String> nodes = Arrays.asList(StrUtil.split(document, "##"));
        for (String node : nodes) {
            if (StrUtil.isBlank(node)) {
                continue;
            }
            final String header = ReUtil.getGroup0(".*?\n", node);
            final String cellName = StrUtil.trim(header) + ".md";
            final String content = StrUtil.removePrefix(node, header).trim();
            // 如果存在就跳过
            if (articleCells.contains(cellName)) {
                continue;
            }
            FileUtil.writeString(content, new File(generateRootDir + "/" + cellName), Charset.defaultCharset());
        }
    }

    @Test
    public void testDownloadImg() {
        final CsvReadConfig config = new CsvReadConfig();
        config.setContainsHeader(true);
        CsvReader reader = CsvUtil.getReader(config);
        final CsvData data = reader.read(new File("/Users/kiwi/work/文档/EXCEL&CSV/zhihu-img-1.csv"), Charset.defaultCharset());
        final List<CsvRow> rows = data.getRows();
        rows.forEach(it -> HttpUtil.downloadFile(it.get(2), "/Users/kiwi/work/文档/IMG/其它"));
    }

}