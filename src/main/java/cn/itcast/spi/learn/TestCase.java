package cn.itcast.spi.learn;

import cn.itcast.spi.learn.Search;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestCase {


    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search = iterator.next();
            search.searchDoc("hello world");
        }
    }


}
