package com.tridium.lifx.message;

import com.tridium.ndriver.datatypes.BAddress;

/**
 * Created by Aaron D'souza on 6/8/2016.
 */
public class LifxGetService extends LifxRequestMessage {
    public LifxGetService(BAddress address) {
        super(address);
        tagged = true;
        messageType = 2;
        size = 34;
    }
}
