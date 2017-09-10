package com.cw.chwo.common.lucene;

import com.cw.chwo.BaseTest;
import org.junit.Test;

import java.io.File;

/**
 * Created by handl on 2017/9/8.
 */
public class IndexManagerTest extends BaseTest {

    private static String INDEX_DIR = "D:\\luceneIndex";
    private static String DATA_DIR = "D:\\luceneData";

    @Test
    public void luceneTest(){
        File fileIndex = new File(INDEX_DIR);
        if(IndexManager.deleteDir(fileIndex)){
            fileIndex.mkdir();
        }else{
            fileIndex.mkdir();
        }

        IndexManager.createIndex(DATA_DIR);
        IndexManager.searchIndex("java");
    }
}
