package boy.learning.dao.impl;

import boy.learning.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private int connectionNum;
    private String dataBase;


    public BookDaoImpl(int connectionNum, String dataBase) {
        this.connectionNum = connectionNum;
        this.dataBase = dataBase;
    }

    @Override
    public void save() {
        System.out.println("BookDaoImpl is saving"+connectionNum+" "+dataBase);
    }

//    public void setConnectionNum(int connectionNum) {
//        this.connectionNum = connectionNum;
//    }

//    public void setDataBase(String dataBase) {
//        this.dataBase = dataBase;
//    }
}
