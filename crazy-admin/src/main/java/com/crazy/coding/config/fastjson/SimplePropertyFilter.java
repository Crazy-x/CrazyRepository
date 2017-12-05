package com.crazy.coding.config.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * 在fastjson中使用，用于忽略指定属性；
 * 类似于 SimplePropertyPreFilter 这个类；
 * 只不过我们这里使用的是自定义。
 */
public class SimplePropertyFilter implements PropertyPreFilter {

    private Set<String> excludes = new HashSet<String>();

    public SimplePropertyFilter() {
        super();
    }

    // 加入需要排除的属性
    public SimplePropertyFilter(String... properties) {
        super();
        for (String item : properties) {
            if (item != null) {
                this.excludes.add(item);
            }
        }
    }

    /**
     * 这个方法表示如果加入了忽略属性，那么这个属性就不序列化。
     */
    @Override
    public boolean apply(JSONSerializer serializer, Object object, String name) {

        if (null == object || excludes.size() == 0) {
            return true;
        }

        if (excludes.contains(name)) {
            return false;
        }

        return true;
    }

}
