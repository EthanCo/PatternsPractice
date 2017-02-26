package com.ethanco.bridgepattern.bridge;

/**
 * 老师
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public abstract class Teacher {
    protected String name;

    private Subject subject;

    public Teacher(Subject _subject) {
        this.subject = _subject;
    }

    /**
     * 教学
     */
    public void teaching() {
        subject.showKnowledge();
    }
}
