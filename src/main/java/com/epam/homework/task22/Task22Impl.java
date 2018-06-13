package com.epam.homework.task22;

import java.util.*;

public class Task22Impl implements Task22 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> resultList = new ArrayList<>();

        for (IPoem ipoem: poems ) {
            if (ipoem.getAuthor().equals(author)){
                resultList.addAll(ipoem.getLines());
            }
        }

        resultList.sort(Comparator.comparingInt(String::length));
        return resultList;
    }
}

class IPoem implements Task22.IPoem{

    private List<String> poemLines;
    private String author;

    IPoem(String author, List<String> poemLines){
        this.author = author;
        this.poemLines = poemLines;
    }

    @Override
    public List<String> getLines() {
        return poemLines;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
