package com.boco.jvm.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheamus on 2018/5/20.
 */
public class JConsoleTool {

    byte[] bb1 = new byte[128 * 1024];

    public JConsoleTool() {
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("starting ...");
        fill(1000);
    }

    private static void fill(int n) {
        List<JConsoleTool> consoleTools = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            JConsoleTool tool = new JConsoleTool();
            consoleTools.add(tool);
        }
    }
}
