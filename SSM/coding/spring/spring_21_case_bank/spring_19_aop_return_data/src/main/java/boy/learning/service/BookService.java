package boy.learning.service;

public interface BookService {
    String save(int id,String name);

    void delete();

    void update();

    void select();

    int selectById();
}
