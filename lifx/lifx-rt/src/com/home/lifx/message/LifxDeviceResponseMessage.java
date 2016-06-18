package com.home.lifx.message;

import com.tridium.ndriver.datatypes.BAddress;

/**
 * Created by Aaron D'souza on 6/12/2016.
 */
public abstract class LifxDeviceResponseMessage extends LifxResponseMessage {
    public LifxDeviceResponseMessage(BAddress address) {
        super(address);
    }
}
