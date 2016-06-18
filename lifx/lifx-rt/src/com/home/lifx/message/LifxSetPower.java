package com.home.lifx.message;

import com.home.lifx.BLifxAddress;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.io.TypedOutputStream;

import java.io.OutputStream;

/**
 * Created by Aaron D'souza on 6/18/2016.
 */
public class LifxSetPower extends LifxDeviceRequestMessage {
    public LifxSetPower(BAddress address, int powerLevel, long duration) {
        super(((BLifxAddress)address).getIpAddress());
        tagged = false;
        target = ((BLifxAddress)address).getMacAddress();
        messageType = 117;
        size = 42;
        this.powerLevel = powerLevel;
        this.duration = duration;
    }

    @Override
    public void writePayload(TypedOutputStream to) {
        to.writeUnsigned16(swap((short)powerLevel));
        to.writeUnsigned32(swap((int)duration));
    }

    private int powerLevel; // The power level to set (0-65535)
    private long duration; // The power level transition time in milliseconds
}
