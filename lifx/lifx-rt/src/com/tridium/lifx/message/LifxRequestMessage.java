package com.tridium.lifx.message;

import com.tridium.ndriver.datatypes.BAddress;

import java.io.OutputStream;

/**
 * Created by Aaron D'souza on 6/8/2016.
 */
public class LifxRequestMessage extends LifxDeviceMessage {
    public LifxRequestMessage(BAddress address) {
        super(address);
    }

    @Override
    public void writePayload(OutputStream out) {

    }
}
