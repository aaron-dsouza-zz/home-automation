package com.home.lifx.message;

import com.tridium.ndriver.datatypes.BAddress;

/**
 * Created by Aaron D'souza on 6/8/2016.
 */
public abstract class LifxDeviceRequestMessage extends LifxRequestMessage {
    public LifxDeviceRequestMessage(BAddress address){super(address);}


}
