import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name = "Record", eager = true)
@SessionScoped
public class RecordBean implements Serializable {

    private Double x;
    private Double y;
    private Double r;

    private Boolean inArea;


    public RecordBean() {
        this.x = 0.;
        this.y = 0.;
        this.r = 1.;
        this.inArea = false;
    }

    public void onSubmit() {
        inArea = Result.calculate(x, y, r);
        Result result = new Result(x, y, r, inArea);
        result.save();
    }

    public void onRChecked(Double value) {
        if (Arrays.asList(1d, 1.5d, 2d, 2.5d, 3d).contains(value))
            this.r = value;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

}
