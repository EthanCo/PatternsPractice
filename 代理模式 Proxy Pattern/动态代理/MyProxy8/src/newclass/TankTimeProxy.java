package newclass;
import java.lang.reflect.Method;
import domain.*;
public class TankTimeProxy implements domain.Moveable{
    public TankTimeProxy (InvocationHandler h) {
        this.h = h;
    }
    domain.InvocationHandler h;
@Override
public void move() {
    try {
    Method md = domain.Moveable.class.getMethod("move");
    h.invoke(this, md);
    }catch(Exception e) {e.printStackTrace();}
}
}