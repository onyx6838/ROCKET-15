package com.vti.entity.impl.ex2;

import com.vti.entity.ex2.IAttack;

public abstract class Phone implements IAttack {
    public abstract void answer();

    public abstract void call();

    public abstract void sendMessage();

    public abstract void receiveMessages();
}
