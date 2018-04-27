package com.boco.jvm.memory;

/**
 * 栈上分配内存
 * Created by Sheamus on 2018/4/24.
 */
public class StackAllocation {

    public StackAllocation obj;

    /**
     * 本方法是发生逃逸的
     * @return
     */
    public StackAllocation getInstance() {
        return obj == null ? new StackAllocation() : obj;
    }

    /**
     * 本方法是发生逃逸的
     * @return
     */
    public void setobj() {
        this.obj = new StackAllocation();
    }

    /**
     * 对象的作用域仅在当前方法上有效，没有发生逃逸
     */
    public void useStackAllocation() {
        StackAllocation s = new StackAllocation();
    }

    /**
     * 这种情况也是会发生逃逸的
     *  引用成员变量的值发生了逃逸。
     */
    public void useStackAllocation2() {
        StackAllocation s = getInstance();
    }

    public static void main(String[] args) {

    }
}
