package com.heiko.mediatorpattern;

/**
 * 抽象同事类
 *
 * @author Heiko
 * @date 2020/4/10 0010
 */
public class AbstractColleague {
    protected AbstractMediator mediator;
    public AbstractColleague(AbstractMediator _mediator){
        this.mediator = _mediator;
    }
}
