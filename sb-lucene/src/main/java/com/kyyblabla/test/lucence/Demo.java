package com.kyyblabla.test.lucence;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kyy on 2017/7/14.
 */
public class Demo {


    public static void main(String[] args) throws IOException, ParseException {

        RAMDirectory directory = new RAMDirectory();
        Analyzer analyzer = new StandardAnalyzer();// 创建一个分词器
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(directory, indexWriterConfig);

        Document doc = new Document();
        String text = "my name is kyy";
        doc.add(new Field("content", text, TextField.TYPE_STORED));

        writer.addDocument(doc);
        writer.close();


        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("content", analyzer);
        Query query = parser.parse("text");

        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            assertEquals("This is the text to be indexed.", hitDoc.get("content"));
        }
        ireader.close();
        directory.close();


    }

}
