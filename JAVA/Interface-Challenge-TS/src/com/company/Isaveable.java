package com.company;

import java.util.ArrayList;
import java.util.List;

public interface Isaveable {
    // these should be objects
    List<String> write();
    void read(List<String> savedMedia);
}
