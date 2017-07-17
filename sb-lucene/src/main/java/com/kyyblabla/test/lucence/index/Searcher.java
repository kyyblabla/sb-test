package com.kyyblabla.test.lucence.index;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by kyy on 2017/7/17.
 */
public class Searcher {


    private Directory directory;
    IndexSearcher indexSearcher;

    public Searcher(Directory directory) {
        this.directory = directory;
        try {
            indexSearcher = new IndexSearcher(DirectoryReader.open(this.directory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void search(Map<String, String> params) throws IOException {
        Term term = new Term("content", "name");
        Query query = new TermQuery(term);
        TopDocs search = indexSearcher.search(query, 10);
    }

}
