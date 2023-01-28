package boy.learning.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 小飞舞
 * @since 2023-01-28
 */
public class Salarygrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "grade", type = IdType.ASSIGN_ID)
    private Integer grade;

    private Integer losalary;

    private Integer hisalary;


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getLosalary() {
        return losalary;
    }

    public void setLosalary(Integer losalary) {
        this.losalary = losalary;
    }

    public Integer getHisalary() {
        return hisalary;
    }

    public void setHisalary(Integer hisalary) {
        this.hisalary = hisalary;
    }

    @Override
    public String toString() {
        return "Salarygrade{" +
        "grade=" + grade +
        ", losalary=" + losalary +
        ", hisalary=" + hisalary +
        "}";
    }
}
