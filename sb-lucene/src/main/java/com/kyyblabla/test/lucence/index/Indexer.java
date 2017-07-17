package com.kyyblabla.test.lucence.index;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;

import java.io.IOException;
import java.util.Map;

/**
 * Created by kyy on 2017/7/17.
 */
public class Indexer {

    private Directory directory;
    private IndexWriter writer;
    private Analyzer analyzer;

    public Indexer(Directory directory, Analyzer analyzer) {
        this.directory = directory;
        this.analyzer = analyzer;
        try {
            writer = new IndexWriter(directory, new IndexWriterConfig(analyzer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String id, Map<String, String> docInfo) throws IOException {
        Document doc = new Document();
        docInfo.forEach((k, v) -> {
            doc.add(new Field(k, v, TextField.TYPE_STORED));
        });
        doc.add(new Field("id", id, TextField.TYPE_STORED));
        writer.addDocument(doc);
        writer.commit();
    }



}
