package com.home.lifx.comm;

import com.home.lifx.message.LifxMessageFactory;
import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.datatypes.BUdpCommConfig;

import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Created by Aaron D'souza on 6/12/2016.
 */
public class BLifxUDPCommConfig extends BUdpCommConfig {
    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BLifxUDPCommConfig.class);

    public BLifxUDPCommConfig() {
        this.getAddress().setPort(56700);
    }
    @Override
    protected IMessageFactory makeMessageFactory() {
        return new LifxMessageFactory();
    }
}
