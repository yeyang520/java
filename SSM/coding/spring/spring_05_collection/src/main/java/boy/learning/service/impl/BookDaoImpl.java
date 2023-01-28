package boy.learning.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BookDaoImpl {
    private Integer[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        System.out.println(array[0]);
        this.array = array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
