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
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;
import java.util.Arrays;

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


        Term term = new Term("content", "name");
        Query query = new TermQuery(term);


        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);


        TopDocs search = isearcher.search(query, 10);

        Arrays.stream(search.scoreDocs).forEach(d -> {
            System.out.println(d.score);
            try {
                Document doc1 = isearcher.doc(d.doc);
                System.out.println(doc1.get("content"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("------");
        });

        ireader.close();
        directory.close();


    }

}
