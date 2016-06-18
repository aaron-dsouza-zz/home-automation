package com.home.lifx.message;

import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedOutputStream;

import java.io.OutputStream;

/**
 * Created by Aaron D'souza on 6/8/2016.
 */
public class LifxGetService extends LifxDeviceRequestMessage {
    public LifxGetService(BAddress address) {
        super(address);
        tagged = true;
        messageType = 2;
        size = 36;
    }

    @Override
    public void writePayload(TypedOutputStream out) {

    }
}
