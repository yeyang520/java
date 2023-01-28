package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {
    @Insert("insert into tbl_log  values(null,now(),#{info})")
    void log(String info);
}
