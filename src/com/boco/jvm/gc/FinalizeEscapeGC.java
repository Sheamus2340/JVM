package com.boco.jvm.gc;

/**
 * 此代码演示了两点
 * 1、对象可以在被GC时自我拯救
 * 2、这种自救的机会只有一次，因为一个对象的finalize()方法最多只能被系统自动调用一次。
 *
 *  从结果可以看出，SAVE_HOOK对象的finalize()方法确实被GC收集器触发过，并且在被收集前成功逃脱了。
 注意：任何一个对象的finalize()方法都只会被系统自动调用一次，如果对象面临下一次回收，它的finalize()方法不会被再次执行，因此第二段代码的自救行动失败了。 并且建议大家尽量避免使用它
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, I am still alive");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        //因为finalize方法优先级很低，所有暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ,I am dead QAQ!");
        }

        //-----------------------
        //以上代码与上面的完全相同,但这次自救却失败了！！！
        SAVE_HOOK = null;
        System.gc();

        //因为finalize方法优先级很低，所有暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ,I am dead QAQ!");
        }
    }
}
