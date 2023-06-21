package com.spring.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    private String[] course;

    private List<String> list;

    private Map<String, String> map;

    private Set<String> set;

    private List<Course> lc;

    @Override
    public String toString() {
        return "Stu{" +
                "course=" + Arrays.toString(course) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", lc=" + lc +
                '}';
    }

    public void setLc(List<Course> lc) {
        this.lc = lc;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

}
