package boy.learning.service;

import boy.learning.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {

    /**
     * 保存
     * @param book
     * @return
     */
    public boolean save(Book book);


    /**
     * 修改
     * @param book
     * @return
     */
    public boolean update(Book book);


    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Book getById(Integer id);


    /**
     * 查询所有
     * @return
     */
    public List<Book> getAll();
}
