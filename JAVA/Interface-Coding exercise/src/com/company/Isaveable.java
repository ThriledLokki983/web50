package com.company;

import java.util.List;

public interface Isaveable {
    List<String> write(); // returns a list but takes no argument
    void read(List<String> myMedium); // has no return value but takes a list as an argument/parameter

}
