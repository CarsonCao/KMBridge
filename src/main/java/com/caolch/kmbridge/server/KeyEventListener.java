package com.caolch.kmbridge.server;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.HashSet;
import java.util.Set;

public class KeyEventListener extends KeyAdapter {
    private Set<Integer> pressKeys = new HashSet<Integer>();
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressKeys.remove(e.getKeyCode());
        System.out.println("Press key: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressKeys.add(e.getKeyCode());
        System.out.println("Release key:" + KeyEvent.getKeyText(e.getKeyCode()));
    }

    /**
     * get size of press keys
     * @return
     */
    public int getPressSize() {
        return pressKeys.size();
    }

}
