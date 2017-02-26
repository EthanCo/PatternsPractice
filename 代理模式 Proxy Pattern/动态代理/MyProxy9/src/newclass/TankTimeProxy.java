package newclass;
import java.lang.reflect.Method;
import domain.*;
public class TankTimeProxy implements domain.UserMgr{
    public TankTimeProxy (InvocationHandler h) {
        this.h = h;
    }
    domain.InvocationHandler h;
@Override
public void addUser() {
    try {
    Method md = domain.UserMgr.class.getMethod("addUser");
    h.invoke(this, md);
    }catch(Exception e) {e.printStackTrace();}
}}